package personalizedMessage;

import javax.swing.JOptionPane;

import entity.ProgramaDeTV;

public class MensagemPrograma {

	public static void programaSalvo() {
		JOptionPane.showMessageDialog(null, "Programa Salvo Com Sucesso!");
	}

	public static void programaNaoEncontradoComEsteID() {
		JOptionPane.showMessageDialog(null, "Programa não encontrado com este ID!");
	}

	public static void programaExcluidoComSucesso() {
		JOptionPane.showMessageDialog(null, "Programa excluido com sucesso!");
	}

	public static void detalharPrograma(ProgramaDeTV programa) {
		JOptionPane.showMessageDialog(null, programa.toString());
	}
}
