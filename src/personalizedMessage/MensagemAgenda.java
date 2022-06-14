package personalizedMessage;

import java.util.Date;

import javax.swing.JOptionPane;

import entity.ProgramaDeTV;

public class MensagemAgenda {
	
	public static void adicionarNaMinhaAgenda() {
		JOptionPane.showMessageDialog(null, "Programa adicionado na sua Agenda com sucesso");
	}
	
	public static void removerDaMinhaAgenda() {
		JOptionPane.showMessageDialog(null, "Programa removido com sucesso");
	}
	
	public static void programaNaoEncontrada() {
		JOptionPane.showMessageDialog(null, "programa não encontrado");
	}
	
	public static void detalhar(ProgramaDeTV programaDeTV) {
		JOptionPane.showMessageDialog(null, programaDeTV.toString());
	}
	
	public static void hiatoHoje(Date date, ProgramaDeTV programaDeTV) {
		JOptionPane.showMessageDialog(null, "Existe um programa seu em Hiato " + date + " você pode mudar o status para em andamento. " 
				+ programaDeTV);
	}

}
