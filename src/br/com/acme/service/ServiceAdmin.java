package br.com.acme.service;

import br.com.acme.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceAdmin {

    private Armazenamento armazenamento;

    public ServiceAdmin(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public boolean verificaCodigo(int codigo) {
        List<Localizacao> verifica = armazenamento.getLocalizacao().stream().filter(c -> c.getCodigo() == codigo).toList();
        return verifica.isEmpty();
    }

    public boolean verificaIdentificador(int identificador) {
        List<Drone> verifica = armazenamento.getDrone().stream().filter(c -> c.getIdentificador() == identificador).toList();
        return verifica.isEmpty();
    }

    public boolean verificaEmail(String email) {
        List<Cliente> verifica = armazenamento.getCliente().stream().filter(c -> c.getEmail().equals(email)).toList();
        return verifica.isEmpty();
    }

    public boolean verificaEntrega(int numero) {
        List<Entrega> verifica = armazenamento.getEntrega().stream().filter(c -> c.getNumero() == numero).toList();
        return verifica.isEmpty();
    }

    public boolean buscaDrone(double peso, double distanciaEntrega) {
        List<Drone> drones = armazenamento.getDrone().stream().filter(d -> d.getAutonomiaKm() >= distanciaEntrega).
                filter(d -> d.getCargaMaxima() >= peso).toList();
        return drones.isEmpty();
    }

    public boolean cadastraLocal(int codigo, String logradouro, double latitude, double longitude) {
        if (verificaCodigo(codigo)) {
            System.out.println("Codigo ja existe no sistema.");
            return false;
        } else {
            armazenamento.addLocalizacao(new Localizacao(codigo, logradouro, latitude, longitude));
            return true;
        }
    }

    public boolean cadastraDrone(int identificador, double cargaMaxima, int autonomiaKm, Localizacao base) {
        if (verificaIdentificador(identificador)) {
            System.out.println("Identificador ja existe no sistema.");
            return false;
        } else {
            armazenamento.addDrone(new Drone(identificador, cargaMaxima, autonomiaKm, base));
            return true;
        }
    }

    public boolean cadastraCliente(String nome, String email, String senha, Localizacao endereco) {
        if (verificaEmail(email)) {
            System.out.println(("Email ja cadastrado no sistema."));
            return false;
        } else {
            armazenamento.addCliente(new Cliente(nome, email, senha, endereco));
            return true;
        }
    }

    public boolean cadastraEntrega(int numero, String descricao, LocalDate data, double peso, int situacao,
                                   boolean isPerecivel, Localizacao origem, Localizacao destino, LocalDate validade, Cliente cliente) {

        Entrega entrega = new Entrega(numero, descricao, data, peso, situacao, origem, destino, cliente) {
            @Override
            public double getDistanciaEmKm() {
                return super.getDistanciaEmKm();
            }
        };

        if (verificaEntrega(numero)) {
            System.out.println("Numero de entrega ja existe no sistema.");
            return false;
        } else if (buscaDrone(peso, entrega.getDistanciaEmKm())) {
            System.out.println("Não temos drones disponiveis no momento");
            return false;
        } else if (isPerecivel) {
            armazenamento.addEntrega(new EntregaPerecivel(numero, descricao, data, peso, situacao, origem, destino, validade, cliente));
        } else if (!isPerecivel) {
            armazenamento.addEntrega(new EntregaNaoPerecivel(numero, descricao, data, peso, situacao, origem, destino, "", cliente));
        }
        return false;
    }

    public ArrayList consultaEntrega() {
        return armazenamento.getEntrega();
    }

    public boolean inicializar() {
        return false;
    }

}
