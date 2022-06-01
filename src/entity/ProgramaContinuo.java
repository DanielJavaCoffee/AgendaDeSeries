package entity;

import java.util.Date;
import java.util.List;

import enuns.DiasDaSemanas;
import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;

public class ProgramaContinuo extends ProgramaDeTV{

	private String nomeDosApresentadoroes;
	
	public ProgramaContinuo () {
		
	}
	
	public ProgramaContinuo(String nome, String nomeApresentador, StatusDeExebicao status, Canal canal, 
			List<DiasDaSemanas> dias, String horario, Date data) {
		
		this.setTipoDePrograma(TipoDePrograma.PROGRAMAS_CONTINUOS);
		this.setNome(nome);
		this.nomeDosApresentadoroes = nomeApresentador;
		this.setStatusDeExebicao(status);
		this.setCanal(canal);
		this.setDias(dias);
		this.setHorario(horario);
		this.setDataHiato(data);
		this.setId(System.currentTimeMillis());
	}
	
	public String toString() {
		return "Tipo De Programa: " + this.getTipoDePrograma() + "\n" + 
	      "Nome Do Programa: " + this.getNome() + "\n" + "Apresentador: " + this.nomeDosApresentadoroes + 
	      "\n" +"Status De Exebi��o: " + this.getStatusDeExebicao() + "\n" + "Canal: " + this.getCanal() + "\n" + "Dia/s Da Semana/s: " + this.getDias() + "\n" +
	      "Data :" + this.getDataHiato() + "\n" + "ID: " + this.getId();
	}

	public String getNomeDosApresentadores() {
		return nomeDosApresentadoroes;
	}

	public void setNomeDoApresentador(String nomeDosApresentadores) {
		this.nomeDosApresentadoroes = nomeDosApresentadores;
	}

	@Override
	public int compareTo(ProgramaDeTV o) {

		return 0;
	}
}
