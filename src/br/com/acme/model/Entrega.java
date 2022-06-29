package br.com.acme.model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Entrega {

    private int numero;

    private String descricao;

    private LocalDate data;

    private double peso;

    private int situacao;

    private Localizacao origem;

    private Localizacao destino;

    private Cliente cliente;

    public Entrega(int numero, String descricao, LocalDate data, double peso, int situacao, Localizacao origem, Localizacao destino, Cliente cliente) {
        this.numero = numero;
        this.descricao = descricao;
        this.data = data;
        this.peso = peso;
        this.situacao = situacao;
        this.origem = origem;
        this.destino = destino;
        this.cliente = cliente;
    }

    public double getPeso() {
        return peso;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getAno(){
        return data.getYear();
    }

    public int getMes(){
        return data.getMonthValue();
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
