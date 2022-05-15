package personalizedMessage;

import javax.swing.JOptionPane;

import entity.Canal;

public class Mensagem {
	
	//User
	public static void usuarioSalvo() {
		JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
	}
	public static void usuarioSenhaErrada() {
		JOptionPane.showMessageDialog(null, "As senhas não são iguais!");
	}
	public static void usuarioCampoVazio() {
		JOptionPane.showMessageDialog(null, "Campo/s vazio/s!");
	}
	public static void usuarioExcluir() {
		JOptionPane.showMessageDialog(null, "Usuário exluido com sucesso!");
	}
	public static void usuarioNaoEncontrado() {
		JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
	}
	public static void usuarioErro() {
		JOptionPane.showMessageDialog(null, "Houve algum erro na criação de sua conta. tente novamente!");
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
		JOptionPane.showConfirmDialog(null, "Opção errada.");
	}
	public static void canalSalvo() {
		JOptionPane.showMessageDialog(null, "Canal Salvo Com Sucesso!");
	}
	public static void canalExcluido() {
		JOptionPane.showMessageDialog(null, "Canal Excluído Com Sucesso!");
	}
	public static void canalNaoEncontardo() {
		JOptionPane.showMessageDialog(null, "Canal Não Encontrado!");
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
