package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Canal;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaDeListarCanal;
import tela.TelaEditarCadastroDeCanal;

public class OuvinteTelaEditarCadastroDeCanal implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaEditarCadastroDeCanal telaEditarCadastroDeCanal;

	public TelaEditarCadastroDeCanal getTelaEditarCadastroDeCanal() {
		return telaEditarCadastroDeCanal;
	}

	public OuvinteTelaEditarCadastroDeCanal(TelaEditarCadastroDeCanal tela) {
		this.telaEditarCadastroDeCanal = tela;
	}

	public void actionPerformed(ActionEvent e) {

		String nome = telaEditarCadastroDeCanal.getCampoNome().getText();
		String tipoDeCanal = telaEditarCadastroDeCanal.getCampoFormaDeAssistir().getText();
		String linkOuCanal = telaEditarCadastroDeCanal.getCampoNumeroOuLink().getText();
		long id = Long.parseLong(telaEditarCadastroDeCanal.getCampoid().getText());

		Canal canal = centralDeInformacoes.recuperarCanalId(id);

		if (canal != null) {
			canal.setNome(nome);
			canal.setTipoDoCanal(tipoDeCanal);
			canal.setLinkOuCanal(linkOuCanal);
			persistencia.salvarCentral(centralDeInformacoes);
			Mensagem.canalAtualizado();
			new TelaDeListarCanal(null);
			telaEditarCadastroDeCanal.setVisible(false);
		} else {
			Mensagem.canalNaoEncontardo();
		}
	}

	public void actionPerformedVoltar(ActionEvent e) {
		new TelaDeListarCanal(null);
		telaEditarCadastroDeCanal.setVisible(false);
	} // end action
}
