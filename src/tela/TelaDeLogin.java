package Tela;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Janelas.JanelaPadrao;
import Ouvinte.OuvinteTelaDeLogin;

public class TelaDeLogin extends JanelaPadrao {
	
	OuvinteTelaDeLogin ouvinte = new OuvinteTelaDeLogin(this);

	private JTextField campoEmail;
	private JPasswordField campoSenha;
	private JButton buttonProseguir;
	private JButton buttonEsqueciSenha;

	public TelaDeLogin(String titulo) {
		super(titulo);
		adicionarTitulo();
		adicionarJLabel();
		adicionarJTextFiled();;
		adicionarButtonProseguir();
		adicionarButtonEsqueciSenha();
		setVisible(true);
	}

	private void adicionarTitulo() {

		JLabel jLabel = new JLabel("TELA DE LOGIN", JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 50);
		jLabel.setOpaque(true);
		jLabel.setBackground(Color.GRAY);
		jLabel.setForeground(Color.WHITE);
		add(jLabel);
	}
	
	

	private void adicionarJLabel() {

		JLabel email = new JLabel("Email:");
		email.setBounds(30, 80, 100, 30);
		email.setFont(new Font("Arial", Font.BOLD, 16));
		add(email);

		JLabel senha = new JLabel("Senha:");
		senha.setBounds(30, 130, 100, 30);
		add(senha);
	}
	
	private void adicionarJTextFiled() {
		
		campoEmail = new JTextField();
		campoEmail.setBounds(130, 80, 200, 30);
		add(campoEmail);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(130, 130, 200, 30);
		add(campoSenha);
	}
	
	public void adicionarButtonProseguir() {

		buttonProseguir = new JButton("Prosseguir");
		buttonProseguir.setBounds(520, 400, 130, 30);
		buttonProseguir.addActionListener(proseguir());
		buttonProseguir.setBackground(Color.DARK_GRAY);
		buttonProseguir.setForeground(Color.WHITE);
		add(buttonProseguir);

	}
	
	public ActionListener proseguir() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	public void adicionarButtonEsqueciSenha() {

		buttonEsqueciSenha = new JButton("Esqueci Senha");
		buttonEsqueciSenha.setBounds(30, 400, 130, 30);
		buttonEsqueciSenha.addActionListener(senha());
		add(buttonEsqueciSenha);
		
	}
	
	public ActionListener senha() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedSenha(e);
				
			}
		};
	}
	
	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public JButton getButtonProseguir() {
		return buttonProseguir;
	}

	public JButton getButtonEsqueciSenha() {
		return buttonEsqueciSenha;
	}
}
