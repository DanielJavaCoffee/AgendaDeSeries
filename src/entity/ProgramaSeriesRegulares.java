package entity;

import java.util.ArrayList;

import enuns.EstiloSeriesRegulares;
import enuns.DiasDaSemanas;

public class ProgramaSeriesRegulares extends ProgramaDeTV implements Comparable<ProgramaSeriesRegulares> {

	private String genero;
	private EstiloSeriesRegulares estilo;
	private String temparada;

	public ProgramaSeriesRegulares(String genero, EstiloSeriesRegulares estilo, String temporada, String nome,
			Canal canal, String horario, ArrayList<DiasDaSemanas> dia) {
		this.genero = genero;
		this.estilo = estilo;
		this.temparada = temporada;
		setNome(nome);
		setCanal(canal);
		setHorario(horario);
		setDias(dia);
		setId(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return null;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public EstiloSeriesRegulares getEstilo() {
		return estilo;
	}

	public void setEstilo(EstiloSeriesRegulares estilo) {
		this.estilo = estilo;
	}

	public String getTemparada() {
		return temparada;
	}

	public void setTemparada(String temparada) {
		this.temparada = temparada;
	}

	@Override
	public int compareTo(ProgramaSeriesRegulares o) {
		return 0;
	}
}
