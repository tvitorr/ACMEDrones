package br.com.acme.model;

public class Drone {

	private int identificador;

	private double cargaMaxima;

	private int autonomiaKm;

	private Localizacao base;

	public Drone(int identificador, double cargaMaxima, int autonomiaKm, Localizacao base) {
		this.identificador = identificador;
		this.cargaMaxima = cargaMaxima;
		this.autonomiaKm = autonomiaKm;
		this.base = base;
	}
}
