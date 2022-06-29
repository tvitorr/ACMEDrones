package br.com.acme.model;

import java.time.LocalDate;

public class EntregaNaoPerecivel extends Entrega {

    private String descricaoMateriais;

    public EntregaNaoPerecivel(int numero, String descricao, LocalDate data, double peso, int situacao, Localizacao origem, Localizacao destino, String descricaoMateriais, Cliente cliente) {
        super(numero, descricao, data, peso, situacao, origem, destino, cliente);
        this.descricaoMateriais = descricaoMateriais;
    }

    public String getDescricaoMateriais() {
        return descricaoMateriais;
    }

    public double calculaValor() {
        return getValorEmReais();
    }

}
