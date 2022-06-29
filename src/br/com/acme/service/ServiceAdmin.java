package br.com.acme.service;

import br.com.acme.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceAdmin {

    private Armazenamento armazenamento;

    public ServiceAdmin(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public boolean cadastraLocal(int codigo, String logradouro, double latitude, double longitude) {
        armazenamento.addLocalizacao(new Localizacao(codigo, logradouro, latitude, longitude));
        return false;
    }

    public boolean cadastraDrone(int identificador, double cargaMaxima, int autonomiaKm, Localizacao base) {
        armazenamento.addDrone(new Drone(identificador, cargaMaxima, autonomiaKm, base));
        return false;
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
