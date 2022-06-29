package br.com.acme.model;

public class Localizacao {

	private int codigo;

	private String logradouro;

	private double latitude;

	private double longitude;

	public Localizacao(int codigo, String logradouro, double latitude, double longitude) {
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
