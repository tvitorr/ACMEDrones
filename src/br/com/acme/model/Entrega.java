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

	public double calculaValor() {
		return 0;
	}

}
