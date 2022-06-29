package br.com.acme.model;

public class Cliente {

	private String nome;

	private String email;

	private String senha;

	private Localizacao endereco;

	public Cliente(String nome, String email, String senha, Localizacao endereco) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}
}
