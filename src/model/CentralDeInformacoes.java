package model;

import java.util.ArrayList;
import java.util.List;

import entity.Agenda;
import entity.Canal;
import entity.ProgramaDeTV;
import entity.Usuario;

public class CentralDeInformacoes {

	private List<ProgramaDeTV> todosOsProgramas = new ArrayList<ProgramaDeTV>();
	private List<Canal> todosOsCanais = new ArrayList<Canal>();
	private List<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	
	
	private List<ProgramaDeTV> todasAsAgendas = new ArrayList<>();

	public boolean adicionarProgramaDeTV(ProgramaDeTV programa) {
		ProgramaDeTV programas = this.recuperarProgramaDeTVporId(programa.getId());

		if (programas != null) {
			return false;
		}
		this.todosOsProgramas.add(programa);
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

	public boolean excluirPrograma(ProgramaDeTV programa) {
		if (todosOsProgramas.contains(programa)) {
			todosOsProgramas.remove(programa);
			return true;
		}
		return false;
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
		for (int i = 0; i < todosOsCanais.size(); i++) {
			if (todosOsCanais.get(i).getId() == id) {
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

	public boolean AdicionarAgenda(ProgramaDeTV programaDeTV) {
	     for(int i = 0; i < todasAsAgendas.size(); i++) {
	    	 if(todasAsAgendas.get(i).getId() == programaDeTV.getId());
	    	 return false;
	     }
	     todasAsAgendas.add(programaDeTV);
	     return true;
	}

	public List<Canal> getTodosOsCanais() {
		return todosOsCanais;
	}

	public void setTodosOsCanais(ArrayList<Canal> todosOsCanais) {
		this.todosOsCanais = todosOsCanais;
	}

	public List<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}

	public void setTodosOsUsuarios(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}

	public List<ProgramaDeTV> getTodasAsAgendas() {
		return todasAsAgendas;
	}

	public void setTodasAsAgendas(List<ProgramaDeTV> todasAsAgendas) {
		this.todasAsAgendas = todasAsAgendas;
	}

	public List<ProgramaDeTV> getTodosOsProgramas() {
		return todosOsProgramas;
	}

	public void setTodosOsProgramasSeriesRegulares(List<ProgramaDeTV> todosOsProgramas) {
		this.todosOsProgramas = todosOsProgramas;
	}
}