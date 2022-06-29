package br.com.acme.model;

import java.util.Date;

public abstract class Entrega {

    private int numero;

    private String descricao;

    private Date data;

    private double peso;

    private int situacao;

    private Localizacao origem;

    private Localizacao destino;

    public Entrega(int numero, String descricao, Date data, double peso, int situacao, Localizacao origem, Localizacao destino) {
        this.numero = numero;
        this.descricao = descricao;
        this.data = data;
        this.peso = peso;
        this.situacao = situacao;
        this.origem = origem;
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistanciaEmKm() {
        double firstLatToRad = Math.toRadians(origem.getLatitude());
        double secondLatToRad = Math.toRadians(destino.getLatitude());


        double deltaLongitudeInRad = Math.toRadians(destino.getLongitude()) - origem.getLongitude();

        return Math.acos(Math.cos(firstLatToRad) * Math.cos(secondLatToRad) * Math.cos(deltaLongitudeInRad)
                + Math.sin(firstLatToRad) * Math.sin(secondLatToRad)) * 6371;

    }

    public double getValorEmReais() {
        double valorPesoEmReais = getPeso() * 20;
        double valorDistanciaEmReias = getDistanciaEmKm() * 30;
        return valorPesoEmReais + valorDistanciaEmReias;
    }

    public double calculaValor() {
        return 0;
    }

}
