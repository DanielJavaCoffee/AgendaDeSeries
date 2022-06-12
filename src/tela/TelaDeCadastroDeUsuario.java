package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import janelas.JanelaPadrao;
import ouvinte.OuvinteTelaDeCadastroDeUsuario;


public class TelaDeCadastroDeUsuario extends JanelaPadrao {
	
	OuvinteTelaDeCadastroDeUsuario ouvinte = new OuvinteTelaDeCadastroDeUsuario(this);
	
	private JTextField campoNome;
	private JTextField campoEmail;
	private JPasswordField campoSenha01;
	private JPasswordField campoSenha02;
	private JButton buttonSalvar;
	

	public TelaDeCadastroDeUsuario(String titulo) {
		super(titulo);
		titulo();
		adicionarJLabel();
		adicionarJTextFiled();
		buttonSalvar();
		setVisible(true);
		
	}
	
	private void titulo() {
		JLabel jLabel = new JLabel("CADASTRAMENTO DO USUÁRIO", JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 50);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		add(jLabel);
	}
	
	
	private void adicionarJLabel() {
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(30, 70, 100, 30);
		add(nome);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(30, 110, 100, 30);
		add(email);
		
		JLabel senha01 = new JLabel("Senha:");
		senha01.setBounds(30, 150, 100, 30);
		add(senha01);
		
		JLabel senha02 = new JLabel("Senha: ");
		senha02.setBounds(30, 190, 100, 30);
		add(senha02);
	}
	
	private void adicionarJTextFiled() {
		
		campoNome = new JTextField();
		campoNome.setBounds(130, 70, 250, 30);
		add(campoNome);
		
		campoEmail =  new JTextField();
		campoEmail.setBounds(130, 110, 250, 30);
		add(campoEmail);
		
		campoSenha01 = new JPasswordField();
		campoSenha01.setBounds(130, 150, 200, 30);
		add(campoSenha01);
		
		campoSenha02 = new JPasswordField();
		campoSenha02.setBounds(130, 190, 200, 30);
		add(campoSenha02);
	}
	
	private void buttonSalvar() {
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setBounds(520, 400, 130, 30);
		buttonSalvar.addActionListener(salvar());
		add(buttonSalvar);
	}
	
	public ActionListener salvar() {
		return new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
				
			}
		};
	}
	
	public JTextField getCampoNome() {
		return campoNome;
	}

	public JTextField getCampoEmail() {
		return campoEmail;
	}

	public JPasswordField getCampoSenha01() {
		return campoSenha01;
	}

	public JPasswordField getCampoSenha02() {
		return campoSenha02;
	}

	public JButton getButtonSalvar() {
		return buttonSalvar;
	}
}
