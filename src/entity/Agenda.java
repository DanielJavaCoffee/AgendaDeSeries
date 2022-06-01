package entity;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private List<ProgramaDeTV> agendaDePrograma = new ArrayList<>();

	public boolean adicionarProgramaNaAgenda(ProgramaDeTV programa) {
		for (int i = 0; i < agendaDePrograma.size(); i++) {
			if (agendaDePrograma.get(i).getId() == programa.getId()) {
				return false;
			}
		}
		agendaDePrograma.add(programa);
		return true;
	}
	
	public boolean excluirProgramaDaAgenda(ProgramaDeTV p) {
		if(agendaDePrograma.contains(p)) {
			agendaDePrograma.remove(p);
			return true;
		}
		return false;
	}
	
	public List<ProgramaDeTV> getAgenda() {
		return agendaDePrograma;
	}

	public void setAgenda(List<ProgramaDeTV> agendaDePrograma) {
		this.agendaDePrograma = agendaDePrograma;
	}
}
