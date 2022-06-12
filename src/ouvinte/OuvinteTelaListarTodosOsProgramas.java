package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.ProgramaContinuo;
import entity.ProgramaDeTV;
import entity.Usuario;
import enuns.TipoDePrograma;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemAgenda;
import personalizedMessage.MensagemPrograma;
import tela.TelaDeMenu;
import tela.TelaEditarProgramaContinuo;
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

		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));
			ProgramaDeTV programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {
				centralDeInformacoes.excluirPrograma(programaDeTV);
				persistencia.salvarCentral(centralDeInformacoes);
				MensagemPrograma.programaExcluidoComSucesso();
				telaListarTodosOsProgrmas.setVisible(true);
				new TelaListarTodosOsProgramas(null);
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			}
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		}
	}

	public void actionPerformedAtualizar(ActionEvent e) {

		try {
			long id = Long
					.parseLong(JOptionPane.showInputDialog(telaListarTodosOsProgrmas, "Informe o ID do Programa"));
			ProgramaDeTV programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {

				if (programaDeTV.getTipoDePrograma().equals(TipoDePrograma.PROGRAMAS_CONTINUOS)) {
					new TelaEditarProgramaContinuo(null, (ProgramaContinuo) programaDeTV);
					telaListarTodosOsProgrmas.setVisible(false);
				} else if (programaDeTV.getTipoDePrograma().equals(TipoDePrograma.SERIES_REGULARES)) {
					telaListarTodosOsProgrmas.setVisible(false);
				} else {
					telaListarTodosOsProgrmas.setVisible(false);
				}

			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			}
		} catch (NumberFormatException erro) {
			MensagemException.numberFormatException(erro);
		}
	}

	public void actionPerformedDetalhar(ActionEvent e) {

		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));
			ProgramaDeTV programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);

			if (programaDeTV != null) {
				MensagemPrograma.detalharPrograma(programaDeTV);
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			}
		} catch (Exception erro) {
			MensagemException.numberFormatException(erro);
		}
	}

	public void actionPerformedAdicionarNaAgenda(ActionEvent e) {
		
		try {
			long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do Programa"));

			ProgramaDeTV programaDeTV = centralDeInformacoes.recuperarProgramaDeTVporId(id);
			
			Usuario usuario = centralDeInformacoes.recuperarUsuario("daniel");

			if (programaDeTV != null) {
				if (centralDeInformacoes.AdicionarAgenda(programaDeTV)) {
					
					persistencia.salvarCentral(centralDeInformacoes);
					centralDeInformacoes.recuperarUsuario(null);
					
					if(usuario != null) {
						usuario.setMinhaAgenda((ArrayList<ProgramaDeTV>) centralDeInformacoes.getTodasAsAgendas());
					}
					MensagemAgenda.adicionarNaMinhaAgenda();
					
				} else {
					MensagemPrograma.programaNaoEncontradoComEsteID();
				}
			} else {
				MensagemPrograma.programaNaoEncontradoComEsteID();
			}
		} catch (NumberFormatException erro) {
			MensagemException.numberFormatException(erro);
		}
	}
}
