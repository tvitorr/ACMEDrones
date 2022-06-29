package br.com.acme.service;

import br.com.acme.model.Armazenamento;
import br.com.acme.model.Entrega;

import java.util.List;

public class ServiceCliente {

    private Armazenamento armazenamento;

    public ServiceCliente(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public List<Entrega> consultaEntrega(String nomeCliente) {
        return armazenamento.getEntrega().stream().filter(e -> e.getCliente().getNome().equals(nomeCliente)).toList();

    }

    public long consultaCobrancaMensal(int ano, int mes) {
        return armazenamento.getEntrega().stream().filter(e -> e.getAno() == ano).filter(e -> e.getMes() == mes).map(Entrega::getValorEmReais).count();
    }

}
