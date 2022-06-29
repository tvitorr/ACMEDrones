package br.com.acme.model;

public class Drone {

	private int identificador;

	private double cargaMaxima;

	private double autonomiaKm;

	private Localizacao base;

	public Drone(int identificador, double cargaMaxima, double autonomiaKm, Localizacao base) {
		this.identificador = identificador;
		this.cargaMaxima = cargaMaxima;
		this.autonomiaKm = autonomiaKm;
		this.base = base;
	}
}
