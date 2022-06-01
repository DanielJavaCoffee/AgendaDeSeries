package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Agenda;
import entity.ProgramaDeTV;
import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaDeMenu;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaListarTodosOsProgramas implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	
	private TelaListarTodosOsProgramas telaListarTodosOsProgrmas;

	public TelaListarTodosOsProgramas getTelaListarTodosOsProgrmas() {
		return telaListarTodosOsProgrmas;
	}

	public OuvinteTelaListarTodosOsProgramas(TelaListarTodosOsProgramas tela) {
		this.telaListarTodosOsProgrmas = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaListarTodosOsProgrmas.setVisible(false);

	}

	public void actionPerformedExcluir(ActionEvent e) {

	}

	public void actionPerformedAtualizar(ActionEvent e) {

	}

	public void actionPerformedDetalhar(ActionEvent e) {

	}

	public void actionPerformedAdicionarNaAgenda(ActionEvent e) {
		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));
			
			ProgramaDeTV  programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);
			
			if(programaDeTV != null) {
				if(centralDeInformacoes.AdicionarAgenda(programaDeTV)) {
					persistencia.salvarCentral(centralDeInformacoes);
				} else {
					Mensagem.programaNaoEncontradoComEsteID();
				}
			} else {
				Mensagem.programaNaoEncontradoComEsteID();
			}
			
		} catch (NumberFormatException erro) {
            Mensagem.numberFormatException(erro);
		}
	}
}
