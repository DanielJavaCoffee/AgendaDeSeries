package model;

import java.util.ArrayList;

import entity.Canal;
import entity.ProgramaDeTV;

public class CentralDeInformacoes {

	private ArrayList<ProgramaDeTV> todosOsProgramas = new ArrayList<ProgramaDeTV>();
	private ArrayList<Canal> todosOsCanais = new ArrayList<Canal>();

	public boolean adicionarProgramaDeTV(ProgramaDeTV programaDeTV) {
		ProgramaDeTV programa = this.recuperarProgramaDeTVporId(programaDeTV.getId());

		if (programa != null) {
			return false;
		}
		this.todosOsProgramas.add(programaDeTV);
		return true;
	}

	public ProgramaDeTV recuperarProgramaDeTVporId(long id) {
		for (int i = 0; i < todosOsProgramas.size(); i++) {
			if (todosOsProgramas.get(i).getId() == id) {
				return todosOsProgramas.get(i);
			}
		}
		return null;
	}

	public boolean salvarCanal(Canal canal) {
		Canal canals = this.recuperarCanal(canal.getNome());
		if (canals != null) {
			return false;
		}
		todosOsCanais.add(canal);
		return true;
	}

	public Canal recuperarCanal(String nome) {
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getNome().equals(nome)) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	public ArrayList<ProgramaDeTV> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramas(ArrayList<ProgramaDeTV> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}

	public ArrayList<Canal> getTodosOsCanais() {
		return todosOsCanais;
	}

	public void setTodosOsCanais(ArrayList<Canal> todosOsCanais) {
		this.todosOsCanais = todosOsCanais;
	}
}
