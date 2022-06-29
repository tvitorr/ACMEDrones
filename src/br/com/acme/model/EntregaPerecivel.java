package br.com.acme.model;

import java.time.LocalDate;
import java.util.Date;

public class EntregaPerecivel extends Entrega {

    private LocalDate validade;

    public EntregaPerecivel(int numero, String descricao, LocalDate data, double peso, int situacao, Localizacao origem, Localizacao destino, LocalDate validade, Cliente cliente) {
        super(numero, descricao, data, peso, situacao, origem, destino, cliente);
        this.validade = validade;
    }

    public double calculaValor() {
        return getValorEmReais() + getValorEmReais() * 0.1;
    }

}
