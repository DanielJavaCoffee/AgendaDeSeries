package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import janelas.JanelaPadrao;
import ouvinte.OuvinteTelaDeMenu;

public class TelaDeMenu extends JanelaPadrao {

    OuvinteTelaDeMenu ouvinte = new OuvinteTelaDeMenu(this);
	
	private JButton buttonExcluir;
	private JMenuBar jMenuBar;

	public TelaDeMenu(String titulo) {
		super(titulo);
		adicionarTitulo();
		excluirUsuario();
		adicionarMenu();
		setVisible(true);
	}

	private void adicionarTitulo() {

		JLabel jLabel = new JLabel("TELA DE MENU", JLabel.CENTER);
		jLabel.setBounds(0, 0, 700, 50);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		add(jLabel);
	}

	private void excluirUsuario() {

		buttonExcluir = new JButton("Excluir Usuário");
		buttonExcluir.setBounds(500, 370, 150, 30);
		buttonExcluir.addActionListener(excluir());
		add(buttonExcluir);
	}

	public ActionListener excluir() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                 ouvinte.actionPerformedExcluir(e);
			}
		};
	}

	private void adicionarMenu() {

		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		JMenu menuOp = new JMenu("Opçoes");
		jMenuBar.add(menuOp);

		JMenuItem cadastroDeCanal = new JMenuItem("Cadastrar Canal");
		menuOp.add(cadastroDeCanal);
		cadastroDeCanal.addActionListener(ouvinte);
		
		JMenuItem listarCanal = new JMenuItem("Listar Canal");
		menuOp.add(listarCanal);
		listarCanal.addActionListener(ouvinte);	
		
		JMenuItem cadastrarPrograma = new JMenuItem("Cadastrar Programas");
		menuOp.add(cadastrarPrograma);
		cadastrarPrograma.addActionListener(ouvinte);
		
		JMenuItem listarPrograma = new JMenuItem("Listar Programas");
		menuOp.add(listarPrograma);
		listarPrograma.addActionListener(ouvinte);
		
		JMenuItem gerarPDF = new JMenuItem("Gerar PDF");
		menuOp.add(gerarPDF);
		gerarPDF.addActionListener(ouvinte);
		
		JMenuItem foto = new JMenuItem("Foto");
		menuOp.add(foto);
		foto.addActionListener(ouvinte);
		
		JMenuItem agenda = new JMenuItem("Minha Agenda");
		menuOp.add(agenda);
		agenda.addActionListener(ouvinte);
		
		JMenuItem emial = new JMenuItem("Enviar Minha Agenda Por Email");
		menuOp.add(emial);
		emial.addActionListener(ouvinte);
		
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}
}
