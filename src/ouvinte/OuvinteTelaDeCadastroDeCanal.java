package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Canal;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaDeCadastroDeCanal;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeCanal implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeCadastroDeCanal telaDeCadastroDeCanal;

	public TelaDeCadastroDeCanal getTelaDeCadastroDeCanal() {
		return telaDeCadastroDeCanal;
	}

	public OuvinteTelaDeCadastroDeCanal(TelaDeCadastroDeCanal tela) {
		this.telaDeCadastroDeCanal = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new TelaDeMenu(null);
		telaDeCadastroDeCanal.setVisible(false);

	} // end actionPerformed

	public void actionPerformedsalvar(ActionEvent e) {

		String nome = telaDeCadastroDeCanal.getCampoNome().getText();
		String tipoDeCanal = telaDeCadastroDeCanal.getCampoForma().getText();
		String canalOuLink = telaDeCadastroDeCanal.getCampoLinkNumero().getText();

		if (nome.isBlank() || tipoDeCanal.isBlank() || canalOuLink.isBlank()) {
			Mensagem.usuarioCampoVazio();
		} else {
			Canal canal = new Canal(nome, tipoDeCanal, canalOuLink);
			centralDeInformacoes.salvarCanal(canal);
			persistencia.salvarCentral(centralDeInformacoes);
			Mensagem.canalSalvo();
			new TelaDeCadastroDeCanal(null);
			telaDeCadastroDeCanal.setVisible(false);
			
		} // end else
	} // end if
} // end class
