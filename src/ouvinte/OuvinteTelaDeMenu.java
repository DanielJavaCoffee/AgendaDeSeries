package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaCadastroDeProgramaContinuo;
import tela.TelaCadastroDeProgramaDeRealityShows;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeCadastroDeCanal;
import tela.TelaDeImagem;
import tela.TelaListarTodosOsCanal;
import tela.TelaDeMenu;
import tela.TelaGerarPDF;
import tela.TelaListarTodosOsProgramas;

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
			new TelaListarTodosOsCanal(null);
			telaDeMenu.setVisible(false);
		} else if (comando.equals("Cadastrar Programas")) {

			String[] opercao = { "Programa S�ries Regulares", "Programa De RealityShows", "Programa Continuo" };
			String entrada = (String) JOptionPane.showInputDialog(null, "Qual Tipo De Programa Voc� Deseja Cadastrar: ",
					"", JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);
			if (opercao[0] == entrada) {
				new TelaCadastroDeProgramaSeriesRegulares(null);
				telaDeMenu.setVisible(false);
			} else if (opercao[1] == entrada) {
                new TelaCadastroDeProgramaDeRealityShows(null);
				telaDeMenu.setVisible(false);
			} else {
				new TelaCadastroDeProgramaContinuo(null);
				telaDeMenu.setVisible(false);
			}
					
		} else if (comando.equals("Listar Programas")) {
            new TelaListarTodosOsProgramas(null);
			telaDeMenu.setVisible(false);
		} else if (comando.equals("Gerar PDF")) {
			new TelaGerarPDF(null);
			telaDeMenu.setVisible(false);
		} else if(comando.equals("Foto")) {
			new TelaDeImagem(null);
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
