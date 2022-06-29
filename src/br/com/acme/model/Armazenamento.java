package br.com.acme.model;

import java.util.ArrayList;

public class Armazenamento {

    private ArrayList<Localizacao> localizacao;

    private ArrayList<Cliente> cliente;

    private ArrayList<Entrega> entrega;

    private ArrayList<Drone> drone;

    public Armazenamento() {
        localizacao = new ArrayList<Localizacao>();
        cliente = new ArrayList<Cliente>();
        entrega = new ArrayList<Entrega>();
        drone = new ArrayList<Drone>();
    }

    public ArrayList<Localizacao> getLocalizacao() {
        return localizacao;
    }

    public void addLocalizacao(Localizacao localizacao) {
        this.localizacao.add(localizacao);
    }

    public ArrayList<Cliente> getCliente() {
        return cliente;
    }

    public void addCliente(Cliente cliente) {
        this.cliente.add(cliente);
    }

    public ArrayList<Entrega> getEntrega() {
        return entrega;
    }

    public void addEntrega(Entrega entrega) {
        this.entrega.add(entrega);
    }

    public ArrayList<Drone> getDrone() {
        return drone;
    }

    public void addDrone(Drone drone) {
        this.drone.add(drone);
    }
}
