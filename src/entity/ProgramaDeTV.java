package entity;

import java.util.ArrayList;

import enuns.DiasDaSemanas;



public abstract class ProgramaDeTV {

	private String nome;
	private long id;
	private Canal canal;
	private ArrayList<DiasDaSemanas> dias = new ArrayList<DiasDaSemanas>();
	private String horario;

	public abstract String toString();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public long getId() {
		return id;
	}

	public ArrayList<DiasDaSemanas> getDias() {
		return dias;
	}

	public void setDias(ArrayList<DiasDaSemanas> dias) {
		this.dias = dias;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public void setId(long id) {
		this.id = id;
	}
}
