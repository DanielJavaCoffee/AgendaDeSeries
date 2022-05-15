package model;

import java.util.ArrayList;

import entity.Agenda;
import entity.Canal;
import entity.ProgramaDeTV;
import entity.ProgramaSeriesRegulares;
import entity.Usuario;

public class CentralDeInformacoes {

	private ArrayList<ProgramaSeriesRegulares> todosOsProgramasSeriesRegulares = new ArrayList<ProgramaSeriesRegulares>();
	private ArrayList<Canal> todosOsCanais = new ArrayList<Canal>();
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private ArrayList<Agenda> todasAsAgendas = new ArrayList<>();

	public boolean adicionarProgramaDeTV(ProgramaSeriesRegulares programaDeSeries) {
		ProgramaDeTV programa = this.recuperarProgramaDeTVporId(programaDeSeries.getId());

		if (programa != null) {
			return false;
		}
		this.todosOsProgramasSeriesRegulares.add(programaDeSeries);
		return true;
	}

	public ProgramaDeTV recuperarProgramaDeTVporId(long id) {
		for (int i = 0; i < todosOsProgramasSeriesRegulares.size(); i++) {
			if (todosOsProgramasSeriesRegulares.get(i).getId() == id) {
				return todosOsProgramasSeriesRegulares.get(i);
			}
		}
		return null;
	}

	public boolean salvarCanal(Canal canal) {
		Canal canalNome = this.recuperarCanal(canal.getNome());
		if (canalNome != null) {
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
	
	public boolean excluirCanal(Canal canal) {
		if (todosOsCanais.contains(canal)) {
			todosOsCanais.remove(canal);
			return true;
		}
		return false;
	}
	
	public Canal recuperarCanalId(long id) {
		for(int i = 0; i < todosOsCanais.size(); i++) {
			if(todosOsCanais.get(i).getId() == id) {
				return todosOsCanais.get(i);
			}
		}
		return null;
	}

	public boolean salvarUsuario(Usuario usuario) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(usuario.getNome())) {
				return false;
			}
		}
		todosOsUsuarios.add(usuario);
		return true;
	}

	public Usuario recuperarUsuario(String nome) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getNome().equals(nome)) {
				return todosOsUsuarios.get(i);
			}
		}
		return null;
	}

	public boolean excluirUsuario(Usuario usuario) {
		if (todosOsUsuarios.contains(usuario)) {
			todosOsUsuarios.remove(usuario);
			return true;
		}
		return false;
	}

	public boolean isLogin(String email, String senha) {
		for (int i = 0; i < todosOsUsuarios.size(); i++) {
			if (todosOsUsuarios.get(i).getEmail().equals(email) && todosOsUsuarios.get(i).getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<ProgramaSeriesRegulares> getTodosOsProgramas() {
		return todosOsProgramasSeriesRegulares;
	}

	public void setTodosOsProgramas(ArrayList<ProgramaSeriesRegulares> todosOsProgramasSeriesRegulares) {
		this.todosOsProgramasSeriesRegulares = todosOsProgramasSeriesRegulares;
	}

	public ArrayList<Canal> getTodosOsCanais() {
		return todosOsCanais;
	}

	public void setTodosOsCanais(ArrayList<Canal> todosOsCanais) {
		this.todosOsCanais = todosOsCanais;
	}

	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}

	public ArrayList<Agenda> getTodasAsAgendas() {
		return todasAsAgendas;
	}

	public void setTodasAsAgendas(ArrayList<Agenda> todasAsAgendas) {
		this.todasAsAgendas = todasAsAgendas;
	}
}
