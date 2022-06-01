package tela;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.ProgramaContinuo;
import entity.ProgramaDeRealityShows;
import entity.ProgramaDeTV;
import janelas.JanelaListarProgramas;
import model.CentralDeInformacoes;
import model.Persistencia;
import ouvinte.OuvinteTelaListarTodosOsProgramas;

public class TelaListarTodosOsProgramas extends JanelaListarProgramas {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	OuvinteTelaListarTodosOsProgramas ouvinte = new OuvinteTelaListarTodosOsProgramas(this);

	private JButton buttonVoltar;
	private JButton buttonExcluir;
	private JButton buttonAtualizar;
	private JButton buttonDetalhar;
	private JButton buttonAdicionarNaAgenda;
	private JTextField campoBusca;

	public TelaListarTodosOsProgramas(String titulo) {
		super(titulo);

		adicionarJLabel();
		adicionarJButtonVoltar();
		adicionarJButtonAtualizar();
		adicionarJButtonExcluir();
		adicionarJButtonDetalhar();
		adicionarJButtonAdcionar();
		listarCanal();
		setVisible(true);
	}

	private void adicionarJLabel() {

		JLabel jLabel = new JLabel("TELA DE LISTAR PROGRAMA, EXCLUIR E ATUALIZAR", JLabel.CENTER);
		jLabel.setBackground(Color.GRAY);
		jLabel.setOpaque(true);
		jLabel.setBounds(0, 0, 1200, 50);
		add(jLabel);
	}

	private void adicionarJButtonVoltar() {

		buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(80, 600, 100, 30);
		buttonVoltar.addActionListener(voltar());
		add(buttonVoltar);
	}

	public ActionListener voltar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformed(e);
			}
		};
	}

	private void adicionarJButtonAtualizar() {

		buttonAtualizar = new JButton("Atualizar");
		buttonAtualizar.setBounds(850, 600, 100, 30);
		buttonAtualizar.addActionListener(atualizar());
		add(buttonAtualizar);
	}

	public ActionListener atualizar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedAtualizar(e);
			}
		};
	}

	private void adicionarJButtonExcluir() {

		buttonExcluir = new JButton("Excluir");
		buttonExcluir.setBounds(980, 600, 100, 30);
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

	private void adicionarJButtonDetalhar() {

		buttonDetalhar = new JButton("Detalhar");
		buttonDetalhar.setBounds(700, 600, 100, 30);
		buttonDetalhar.addActionListener(detalhar());
		add(buttonDetalhar);
	}

	public ActionListener detalhar() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedDetalhar(e);
			}
		};
	}
	
	public void adicionarJButtonAdcionar(){
		
		buttonAdicionarNaAgenda = new JButton("Adicionar na minha Agenda");
		buttonAdicionarNaAgenda.setBounds(430, 600, 200, 30);
		buttonAdicionarNaAgenda.addActionListener(adicionar());
		add(buttonAdicionarNaAgenda);
	}
	
	public ActionListener adicionar() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ouvinte.actionPerformedAdicionarNaAgenda(e);
			}
		};
	}

	private void listarCanal() {

		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Tipo De Programa");
		modelo.addColumn("Nome");
		modelo.addColumn("Apresentador");
		modelo.addColumn("Status De Exebição");
		modelo.addColumn("Canal");
		modelo.addColumn("Dia Da Semana");
		modelo.addColumn("Horario");
		modelo.addColumn("Data");
		modelo.addColumn("Temporada");
		modelo.addColumn("Genero");
		modelo.addColumn("Estilo");
		modelo.addColumn("ID");

		List<ProgramaDeTV> programa = centralDeInformacoes.getTodosOsProgramas();

		Collections.sort(programa);

		Object[] linhas = new Object[programa.size()];

		for (ProgramaDeTV p : programa) {

			p = new ProgramaContinuo();
			if (p instanceof ProgramaDeRealityShows) {
				ProgramaDeRealityShows pc = (ProgramaDeRealityShows) p;

				Object[] linha = new Object[9];
				linha[0] = p.getTipoDePrograma();
				linha[1] = p.getNome();
				linha[2] = pc.getNomeDosApresentadores();
				linha[3] = p.getStatusDeExebicao();
				linha[4] = p.getCanal().getNome();
				linha[5] = p.getDias();
				linha[6] = p.getHorario();
				linha[7] = p.getHorario();
				linha[8] = pc.getTemporada();

				modelo.addRow(linha);
			}

		}
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(80, 60, 1000, 400);
		add(painelTabela);
	}

	public JButton getButtonVoltar() {
		return buttonVoltar;
	}

	public JButton getButtonExcluir() {
		return buttonExcluir;
	}

	public JButton getButtonAtualizar() {
		return buttonAtualizar;
	}

	public JTextField getCampoBusca() {
		return campoBusca;
	}

	public JButton getButtonDetalhar() {
		return buttonDetalhar;
	}
	
	public JButton getButtonAdicionarNaAgenda() {
		return buttonAdicionarNaAgenda;
	}
}
