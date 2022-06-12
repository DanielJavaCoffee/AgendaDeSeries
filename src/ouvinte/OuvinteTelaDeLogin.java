package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Usuario;
import model.CentralDeInformacoes;
import model.Mensageiro;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemEmail;
import personalizedMessage.MensagemUsuario;
import tela.TelaDeLogin;
import tela.TelaDeMenu;

public class OuvinteTelaDeLogin implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaDeLogin telaDeLogin;

	public TelaDeLogin getTelaDeLogin() {
		return telaDeLogin;
	}

	public OuvinteTelaDeLogin(TelaDeLogin tela) {
		this.telaDeLogin = tela;
	}

	public void actionPerformed(ActionEvent proseguir) {

		String email = telaDeLogin.getCampoEmail().getText();
		String senha = telaDeLogin.getCampoSenha().getText();

		try {

			if (email.isBlank() || senha.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {
				if(centralDeInformacoes.isLogin(email, senha)) {
					new TelaDeMenu(null);
					telaDeLogin.setVisible(false);
				} else {
					MensagemUsuario.usuarioNaoEncontrado();
				} // end else
			} // end else
		} catch (NullPointerException e) {
			MensagemException.nullPointerException(e);
		} // end catch
	} // actionPerformed

	public void actionPerformedSenha(ActionEvent senha) {

		String nome = JOptionPane.showInputDialog(telaDeLogin, "Informe o nome do usu�rio: ");
		Usuario usuario = centralDeInformacoes.recuperarUsuario(nome);
		
		if(usuario != null) {
			Mensageiro.enviarProgramacaoDeHoje("Seus Dados Do APP", usuario.getEmail(), usuario.toString());
			MensagemEmail.emailEnviadoUsuario();
		} else {
			MensagemUsuario.usuarioNaoEncontrado();
		} // end else
	} // end actionPerformedSenha
}
