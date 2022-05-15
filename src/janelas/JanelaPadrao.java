package janelas;

import javax.swing.JFrame;

public class JanelaPadrao extends JFrame{

	public JanelaPadrao(String titulo) {
		
		setTitle(titulo);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
}
