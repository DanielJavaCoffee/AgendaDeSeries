package personalizedMessage;

import javax.swing.JOptionPane;

import entity.Canal;

public class Mensagem {
	
	//User
	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}
	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas n�o s�o iguais!");
	}
	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}
	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usu�rio exluido com sucesso!");
	}
	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
	}
	public static void usuarioErro() {
		JOptionPane.showMessageDialog(null, "Houve algum erro na cria��o de sua conta. tente novamente!");
	}

	
	//Exception
	public static void exception(Exception e) {
		JOptionPane.showMessageDialog(null, "Erro. " + e.getMessage());
	}
	
	//E-mail
	public static void emailEnviadoUsuario() {
		JOptionPane.showMessageDialog(null, "Senha enviada com sucesso!");
	}
	public static void emailErro() {
		JOptionPane.showConfirmDialog(null, "Houve Algum erro");
	}
	
	//Canal
	public static void canalOpcaoInvalida() {
		JOptionPane.showConfirmDialog(null, "Op��o errada.");
	}
	public static void canalSalvo() {
		JOptionPane.showMessageDialog(null, "Canal Salvo Com Sucesso!");
	}
	public static void canalExcluido() {
		JOptionPane.showMessageDialog(null, "Canal Exclu�do Com Sucesso!");
	}
	public static void canalNaoEncontardo() {
		JOptionPane.showMessageDialog(null, "Canal N�o Encontrado!");
	}
	public static void canalAtualizado() {
		JOptionPane.showMessageDialog(null, "Canal Atualizado Com Sucesso!");
	}
	public static void detalharCanal(Canal canal) {
		JOptionPane.showMessageDialog(null, canal.toString());
	}
	
	//program
	
	public static void programaSalvo() {
		JOptionPane.showMessageDialog(null, "Programa Salvo Com Sucesso!");
	}
	
	// NumberFormatException
	public static void numberFormatException(NumberFormatException e) {
		JOptionPane.showMessageDialog(null, "Erro." + e.getMessage());
	}
	// NullPointerException
	public static void nullPointerException(NullPointerException e) {
		JOptionPane.showMessageDialog(null, "Erro." + e.getMessage());
	}
}
