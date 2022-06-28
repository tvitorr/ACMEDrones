package br.com.acme.service;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServiceAdmin {

	public boolean cadastraLocal(int codigo, String logradouro, double latitude, double longitude) {
		return false;
	}

	public boolean cadastraDrone(int identificador, double cargaMaxima, int autonomiaKm) {
		return false;
	}

	public boolean cadastraCliente(String nome, String email, String senha) {
		return false;
	}

	public boolean cadastraEntrega(int numero, String descricao, LocalDate data, double peso, int situacao) {
		return false;
	}

	public ArrayList consultaEntrega() {
		return null;
	}

	public boolean inicializar() {
		return false;
	}

}
