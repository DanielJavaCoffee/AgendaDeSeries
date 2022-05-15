package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeCadastroDeCanal;
import tela.TelaDeListarCanal;
import tela.TelaDeMenu;

public class OuvinteTelaDeMenu implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeMenu telaDeMenu;

	public TelaDeMenu getTelaDeMenu() {
		return telaDeMenu;
	}

	public OuvinteTelaDeMenu(TelaDeMenu tela) {
		this.telaDeMenu = tela;
	}

	public void actionPerformed(ActionEvent clique) {

		String comando = clique.getActionCommand();
		if (comando.equals("Cadastrar Canal")) {
			new TelaDeCadastroDeCanal(null);
			telaDeMenu.setVisible(false);
		} else if (comando.equals("Listar Canal")) {
			new TelaDeListarCanal(null);
			telaDeMenu.setVisible(false);
		} else if (comando.equals("Cadastrar Programa")) {

			String[] opercao = { "Programa Séries Regulares", "Orçado" };
			String entrada = (String) JOptionPane.showInputDialog(null, "Qual Tipo De Programa Você Deseja Cadastrar: ", "",
					JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);
			if (opercao[0] == entrada) {
				new TelaCadastroDeProgramaSeriesRegulares(null);
				telaDeMenu.setVisible(false);
			}
		} else if (comando.equals("Listar Programas")) {

			telaDeMenu.setVisible(false);
		}
	}

	public void actionPerformedExcluir(ActionEvent clique) {

		try {

			String nome = JOptionPane.showInputDialog("informe o email");
			Usuario usuario = centralDeInformacoes.recuperarUsuario(nome);

			if (usuario != null) {
				centralDeInformacoes.excluirUsuario(usuario);
				persistencia.salvarCentral(centralDeInformacoes);
				Mensagem.usuarioExcluir();
			} else {
				Mensagem.usuarioNaoEncontrado();
			}

		} catch (NullPointerException e) {
			Mensagem.nullPointerException(e);
		}
	}
}
