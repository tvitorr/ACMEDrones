package br.com.acme.model;

import java.time.LocalDate;
import java.util.Date;

public class EntregaNaoPerecivel extends Entrega {

    private String descricaoMateriais;

    public EntregaNaoPerecivel(int numero, String descricao, LocalDate data, double peso, int situacao, Localizacao origem, Localizacao destino, String descricaoMateriais) {
        super(numero, descricao, data, peso, situacao, origem, destino);
        this.descricaoMateriais = descricaoMateriais;
    }

    public String getDescricaoMateriais() {
        return descricaoMateriais;
    }

    public double calculaValor() {
        return getValorEmReais();
    }

}
