package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.ProgramaDeTV;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemAgenda;
import tela.TelaAgendaDePrograma;
import tela.TelaDeMenu;

public class OuvinteTelaAgendaDePrograma implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaAgendaDePrograma telaAgendaDePrograma;

	public TelaAgendaDePrograma getTelaAgendaDePrograma() {
		return telaAgendaDePrograma;
	}

	public OuvinteTelaAgendaDePrograma(TelaAgendaDePrograma tela) {
		this.telaAgendaDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {

		new TelaDeMenu(null);
		telaAgendaDePrograma.setVisible(false);
	}

	public void actionPerformedExcluir(ActionEvent e) {

		try {

			long id = Long.parseLong(JOptionPane.showInputDialog("Informe um id"));
			ProgramaDeTV programa = centralDeInformacoes.recuperarAgenda(id);

			if (programa != null) {
				centralDeInformacoes.excluirAgenda(programa);
				persistencia.salvarCentral(centralDeInformacoes);
				MensagemAgenda.removerDaMinhaAgenda();
				telaAgendaDePrograma.setVisible(false);
				new TelaAgendaDePrograma(null);
			} else {
				MensagemAgenda.programaNaoEncontrada();
			}
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		}
	}

	public void actionPerformedDetalhar(ActionEvent e) {

		try {
			
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID"));
			
			ProgramaDeTV programaDeTV = centralDeInformacoes.recuperarAgenda(id);
			
			if(programaDeTV != null) {
				MensagemAgenda.detalhar(programaDeTV);
			} else {
				MensagemAgenda.programaNaoEncontrada();
			}

		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		}
	}
}
