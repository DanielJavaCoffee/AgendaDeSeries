package entity;

import Enuns.diasDaSemanas;
import Enuns.tipoDePrograma;

public class ProgramaDeTV {
	
	private String nome;
	private long id;
	private tipoDePrograma tipoDePrograma;
	private diasDaSemanas diasDaSemanas;
	private Canal canal;
	
	public ProgramaDeTV() {
		this.id = System.currentTimeMillis();
	}

	public ProgramaDeTV(String nome, tipoDePrograma tipo, diasDaSemanas dia, Canal canal) {
		this.nome = nome;
		this.tipoDePrograma = tipo;
		this.diasDaSemanas = dia;
		this.canal = canal;
		this.id = System.currentTimeMillis();
	}
	
	public String toString() {
		return "Nome: " + this.nome + " Tipo De Programa: " + this.tipoDePrograma + " Dias Da Semana: " + this.diasDaSemanas +
				" ID: " + this.id + " " + this.canal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public tipoDePrograma getTipoDePrograma() {
		return tipoDePrograma;
	}

	public void setTipoDePrograma(tipoDePrograma tipoDePrograma) {
		this.tipoDePrograma = tipoDePrograma;
	}

	public diasDaSemanas getDiasDaSemanas() {
		return diasDaSemanas;
	}

	public void setDiasDaSemanas(diasDaSemanas diasDaSemanas) {
		this.diasDaSemanas = diasDaSemanas;
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
}
