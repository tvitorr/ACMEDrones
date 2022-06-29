package br.com.acme.controller;

import br.com.acme.model.Armazenamento;
import br.com.acme.service.ServiceAdmin;
import br.com.acme.service.ServiceCliente;

import java.util.ArrayList;

public class ACMEController {

    private Armazenamento armazenamento = new Armazenamento();
    private ServiceAdmin serviceAdmin = new ServiceAdmin(armazenamento);
    private ServiceCliente serviceCliente = new ServiceCliente(armazenamento);

    public ACMEController() {}

    public boolean realizaLogin(String email, String senha) {
        return false;
    }

    public ArrayList consultaEntrega(int usuario) {
        return null;
    }

}
