package entity;

import java.util.Date;
import java.util.List;

import enuns.DiasDaSemanas;
import enuns.EstiloSeriesRegulares;
import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;

public class ProgramaSeriesRegulares extends ProgramaDeTV {

	private String genero;
	private EstiloSeriesRegulares estilo;
	private String temparada;

	public ProgramaSeriesRegulares() {

	}

	public ProgramaSeriesRegulares(String nome, StatusDeExebicao exebicao, Canal canal, List<DiasDaSemanas> dias,
			String horario, Date data, String temporada, String genero, EstiloSeriesRegulares estilo) {

		this.setTipoDePrograma(TipoDePrograma.SERIES_REGULARES);
		this.setNome(nome);
		this.setStatusDeExebicao(exebicao);
		this.setCanal(canal);
		this.setDias(dias);
		this.setHorario(horario);
		this.setDataHiato(data);
		this.temparada = temporada;
		this.genero = genero;
		this.estilo = estilo;
		this.setId(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "Tipo De Programa: " + this.getTipoDePrograma() + "\n" + "Nome Do Programa: " + this.getNome() + "\n"
				+ "Status De Exebição: " + this.getStatusDeExebicao() + "\n" + "Canal: " + this.getCanal() + "\n"
				+ "Dias Da Semana: " + this.getDias() + "\n" + "Horario: " + this.getHorario() + "\n" + "Data: "
				+ this.getDataHiato() + "\n" + "Temporada: " + this.getTemparada() + "\n" + "Genero: "
				+ this.getGenero() + "\n" + "Estilo: " + this.getEstilo() + "\n" + "ID: " + this.getId();
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
	public int compareTo(ProgramaDeTV o) {
		return 0;
	}
}
