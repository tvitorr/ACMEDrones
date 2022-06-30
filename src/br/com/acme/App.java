package br.com.acme;

import br.com.acme.model.Armazenamento;
import br.com.acme.model.Cliente;
import br.com.acme.model.Drone;
import br.com.acme.model.Localizacao;
import br.com.acme.service.ServiceAdmin;
import br.com.acme.service.ServiceCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class App {

    // 0 admin
    private String logado;
    private Armazenamento armazenamento;

    private ServiceAdmin serviceAdmin;
    private ServiceCliente serviceCliente;

    public void exec() {
        logar();
        if (logado.equals("admin")) admin();
        Scanner sc = new Scanner(System.in);
        int input = 10;
    }

    private void logar() {
        String email, senha;
        String temp;
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Insira o e-mail:");
            email = sc.next();
            System.out.println("Insira a senha");
            senha = sc.next();
            if (email.equals("administracao@mail.com") && senha.equals("admin123")) {
                this.logado = "admin";
                return;
            }
            temp = this.armazenamento.getCliente().stream().filter(n -> n.getEmail().equals(email)).filter(n -> n.getSenha().equals(senha)).map(Cliente::getEmail).toString();
            if (!temp.isEmpty()) {
                this.logado = temp;
                return;
            }
            System.out.println("Usuário ou senha errada");
        }
    }

    private void admin(){
        Scanner sc = new Scanner(System.in);
        int input = 10;


        while (input != 0) {
            System.out.println("INSIRA UMA DAS OPÇÕES ABAIXO:");
            System.out.println("1 - Cadastrar nova localização");
            System.out.println("2 - Cadastrar novo drone");
            System.out.println("3 - Cadastrar novo cliente");
            System.out.println("4 - Cadastrar nova entrega");
            System.out.println("5 - Consultar todas as entregas");
            System.out.println("6 - Simular carga de dados");
            System.out.println("0 - Sair");
            try {
                input = sc.nextInt();
                switch (input) {
                    case 1 -> criaLocalizacao();
                    case 2 -> criaDrone();
                    case 3 -> criaCliente();
                    case 4 -> criaEntrega();
                    case 6 -> System.out.println("Ain't ready yet chief");
                    case 0 -> System.out.println("Até mais");
                    default -> System.out.println("Opção inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo errado de entrada");
                sc.nextLine();
            }
        }
    }

    public void criaLocalizacao(){
        int codigo;
        String logradouro;
        double latitude, longitude;
        Scanner sca = new Scanner(System.in);
        System.out.println("Insira o codigo");
        codigo = sca.nextInt();
        System.out.println("Insira o logradouro");
        logradouro = sca.nextLine();
        System.out.println("Insira a latitude");
        latitude = sca.nextDouble();
        System.out.println("Insira a longitude");
        longitude = sca.nextDouble();
        serviceAdmin.cadastraLocal(codigo,logradouro,latitude,longitude);
    }
    public void criaDrone(){
        int identificador, codigoLocalizacao;
        Double cargaMaxima, autonomia;
        ArrayList<Localizacao> temp;
        Scanner sca = new Scanner(System.in);
        System.out.println("Insira o identificador");
        identificador = sca.nextInt();
        System.out.println("Insira a carga máxima");
        cargaMaxima = sca.nextDouble();
        System.out.println("Insira a autonomia");
        autonomia = sca.nextDouble();
        System.out.println("Insira o código da localização");
        codigoLocalizacao = sca.nextInt();
        temp = serviceAdmin.verificaCodigo(codigoLocalizacao);
        if (temp.isEmpty()) {
            System.out.println("Nenhuma localização cadastrada com esse código");
            return;
        }
        serviceAdmin.cadastraDrone(identificador,cargaMaxima,autonomia,temp.get(0));
    }

    public void criaCliente(){
        String nome, email, senha;
        int codigoLocalizacao;
        ArrayList<Localizacao> temp;
        Scanner sca = new Scanner(System.in);
        System.out.println("Insira o nome");
        nome = sca.nextLine();
        System.out.println("Insira o email");
        email = sca.nextLine();
        System.out.println("Insira a senha");
        senha = sca.nextLine();
        System.out.println("Insira o código da localização");
        codigoLocalizacao = sca.nextInt();
        temp = serviceAdmin.verificaCodigo(codigoLocalizacao);
        if (temp.isEmpty()) {
            System.out.println("Nenhuma localização cadastrada com esse código");
            return;
        }
        serviceAdmin.cadastraCliente(nome, email, senha, temp.get(0));
    }

    public void criaEntrega(){
        String descricao, email;
        int numero, situacao, codOrigem, codDestino;
        double peso;
        boolean perecivel;
        String tempo;

        LocalDate data, validade = null;
        ArrayList<Localizacao> temp, temp2;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Scanner sca = new Scanner(System.in);
        try {

            System.out.println("Insira o numero");
            numero = sca.nextInt();
            System.out.println("Insira a descrição");
            descricao = sca.nextLine();
            System.out.println("Insira a data seguindo o formato 2022-12-28");
            data = LocalDate.parse(sca.nextLine(), formatter);
            System.out.println("Insira o peso");
            peso = sca.nextDouble();
            System.out.println("Insira a situação");
            situacao = sca.nextInt();
            System.out.println("É uma entrega perecível? 1 para sim ou 0 para não");
            tempo = sca.nextLine();
            if (!tempo.equals("0") && !tempo.equals("1")) {
                throw new InputMismatchException();
            }
            perecivel = tempo.equals("1");
            System.out.println("Insira o código da localização origem");
            codOrigem = sca.nextInt();
            temp = serviceAdmin.verificaCodigo(codOrigem);
            if (temp.isEmpty()) {
                System.out.println("Nenhuma localização cadastrada com esse código");
                return;
            }
            System.out.println("Insira o código da localização destino");
            codDestino = sca.nextInt();
            temp2 = serviceAdmin.verificaCodigo(codDestino);
            if (temp2.isEmpty()) {
                System.out.println("Nenhuma localização cadastrada com esse código");
                return;
            }


            //serviceAdmin.cadastraEntrega();
        }
        catch (InputMismatchException e) {
            System.out.println("Tipo errado de entrada");
        }
    }
}