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

    public boolean verificaCodigo (int codigo) {
        List<Localizacao> verifica = armazenamento.getLocalizacao().stream().filter(c -> c.getCodigo() == codigo).toList();
        return verifica.isEmpty();
    }

    public boolean verificaIdentificador (int identificador) {
        List<Drone> verifica = armazenamento.getDrone().stream().filter(c -> c.getIdentificador() == identificador).toList();
        return verifica.isEmpty();
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
        armazenamento.addCliente(new Cliente(nome, email, senha, endereco));
        return false;
    }

    public boolean cadastraEntrega(int numero, String descricao, LocalDate data, double peso, int situacao,
                                   boolean isPerecivel, Localizacao origem, Localizacao destino, LocalDate validade) {
        if (isPerecivel) {
            armazenamento.addEntrega(new EntregaPerecivel(numero, descricao, data, peso, situacao, origem, destino, validade));

        } else {
            armazenamento.addEntrega(new EntregaNaoPerecivel(numero, descricao, data, peso, situacao, origem, destino, ""));
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
