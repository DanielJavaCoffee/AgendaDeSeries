package entity;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String email;
	private String senha;
	private long id;
	private ArrayList<ProgramaDeTV> minhaAgenda = new ArrayList<ProgramaDeTV>();

	public Usuario(String nome, String email, String senha, ArrayList<ProgramaDeTV> agenda) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = System.currentTimeMillis();
		this.minhaAgenda = agenda;
	}

	public String toString() {
		return "Nome: " + this.nome + " Email: " + this.email + " Senha: " + this.senha + " ID: " + this.id
				+ " Minha Agenda De Séries: " + this.minhaAgenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}

	public ArrayList<ProgramaDeTV> getMinhaAgenda() {
		return minhaAgenda;
	}

	public void setMinhaAgenda(ArrayList<ProgramaDeTV> minhaAgenda) {
		this.minhaAgenda = minhaAgenda;
	}
}
