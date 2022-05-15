package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeUsuario implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaDeCadastroDeUsuario telaDeCadastroDeUsuario;

	public TelaDeCadastroDeUsuario getTelaDeCadastroDeUsuario() {
		return telaDeCadastroDeUsuario;
	}

	public OuvinteTelaDeCadastroDeUsuario(TelaDeCadastroDeUsuario tela) {
		this.telaDeCadastroDeUsuario = tela;
	}

	public void actionPerformed(ActionEvent e) {

		// salvarUsuario
		String nome = telaDeCadastroDeUsuario.getCampoNome().getText();
		String email = telaDeCadastroDeUsuario.getCampoEmail().getText();
		String senha01 = telaDeCadastroDeUsuario.getCampoSenha01().getText();
		String senha02 = telaDeCadastroDeUsuario.getCampoSenha02().getText();
		try {
			if (nome.isBlank() || email.isBlank() || senha01.isBlank() || senha02.isBlank()) {
				Mensagem.usuarioCampoVazio();
			} else if (!senha01.equals(senha02)) {
				Mensagem.usuarioSenhaErrada();
			} else {
				Usuario usuario = new Usuario(nome, email, senha01, null);
				if (centralDeInformacoes.salvarUsuario(usuario)) {
					persistencia.salvarCentral(centralDeInformacoes);
					Mensagem.usuarioSalvo();
					new TelaDeMenu(null);
					telaDeCadastroDeUsuario.setVisible(false);
				} else {
					Mensagem.usuarioErro();
				} // end else
			} // end else
		} catch (NullPointerException erro) {
			System.out.println(erro.getMessage());
			Mensagem.nullPointerException(erro);
		} // end catch
	} // end actionPerformed
} // end class
