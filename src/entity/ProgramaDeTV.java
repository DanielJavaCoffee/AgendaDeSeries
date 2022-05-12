package entity;

import java.util.ArrayList;

import enuns.diasDaSemanas;
import enuns.tipoDePrograma;

public class ProgramaDeTV {

	private String nome;
	private long id;
	private tipoDePrograma tipoDePrograma;
	private diasDaSemanas diasDaSemanas;
	private Canal canal;
	private ArrayList<diasDaSemanas> dias = new ArrayList<diasDaSemanas>();

	public ProgramaDeTV() {
		this.id = System.currentTimeMillis();
	}

	public ProgramaDeTV(String nome, tipoDePrograma tipo, Canal canal, ArrayList<diasDaSemanas> dias) {
		this.nome = nome;
		this.tipoDePrograma = tipo;
		this.canal = canal;
		this.dias = dias;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Nome: " + this.nome + " Tipo De Programa: " + this.tipoDePrograma + " ID: " + this.id
				+ "Dias Da Semana: " + this.dias + this.canal;
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

	public ArrayList<diasDaSemanas> getDias() {
		return dias;
	}

	public void setDias(ArrayList<diasDaSemanas> dias) {
		this.dias = dias;
	}
}
