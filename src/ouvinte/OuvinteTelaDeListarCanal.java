package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Canal;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaDeListarCanal;
import tela.TelaDeMenu;

public class OuvinteTelaDeListarCanal implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaDeListarCanal telaDeListarCanal;

	public TelaDeListarCanal getTelaDeListarCanal() {
		return telaDeListarCanal;
	}

	public OuvinteTelaDeListarCanal(TelaDeListarCanal tela) {
		this.telaDeListarCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaDeListarCanal.setVisible(false);
	}

	public void actionPerformedExcluir(ActionEvent e) {
		try {
			String nome = JOptionPane.showInputDialog("Informe o nome do Canal: ");
			Canal canal = centralDeInformacoes.recuperarCanal(nome);
			if (canal != null) {
				centralDeInformacoes.excluirCanal(canal);
				Mensagem.canalExcluido();
				persistencia.salvarCentral(centralDeInformacoes);
				telaDeListarCanal.setVisible(false);
				new TelaDeListarCanal(null);
			} else {
				Mensagem.canalNaoEncontardo();
			}
		} catch (NumberFormatException erro) {
			Mensagem.numberFormatException(erro);
		}
	}

	public void actionPerformedAtualizar(ActionEvent e) {
		try {

			String nome = JOptionPane.showInputDialog("Informe o nome do Canal: ");
			Canal canal = centralDeInformacoes.recuperarCanal(nome);
			if (canal != null) {
                new tela.TelaEditarCadastroDeCanal(null, canal);
				telaDeListarCanal.setVisible(false);
			} else {
				Mensagem.canalNaoEncontardo();
			}
		} catch (NumberFormatException erro) {
			Mensagem.numberFormatException(erro);
		}
	}

	public void actionPerformedDetalhar(ActionEvent e) {
		
		String nome = JOptionPane.showInputDialog("Nome Do Canal");
		Canal canal = centralDeInformacoes.recuperarCanal(nome);
		
		if(canal != null) {
			Mensagem.detalharCanal(canal);
		} else {
			Mensagem.canalNaoEncontardo();
		}
	}
}
