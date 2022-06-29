package br.com.acme.model;

import java.time.LocalDate;
import java.util.Date;

public class EntregaPerecivel extends Entrega {

    private LocalDate validade;

    public EntregaPerecivel(int numero, String descricao, Date data, double peso, int situacao, Localizacao origem, Localizacao destino, LocalDate validade) {
        super(numero, descricao, data, peso, situacao, origem, destino);
        this.validade = validade;
    }

    public double calculaValor() {
        return getValorEmReais() * 0.01;
    }

}
