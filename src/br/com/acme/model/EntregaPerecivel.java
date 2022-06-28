package br.com.acme.model;

import java.time.LocalDate;

public class EntregaPerecivel extends Entrega {

	private LocalDate validade;

	public double calculaValor() {
		return 0;
	}

}
