package ouvinte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entity.Canal;
import entity.ProgramaSeriesRegulares;
import enuns.EstiloSeriesRegulares;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaSeriesRegulares implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaSeriesRegulares telaCadastroDePrograma;

	public TelaCadastroDeProgramaSeriesRegulares getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaSeriesRegulares(TelaCadastroDeProgramaSeriesRegulares tela) {
		this.telaCadastroDePrograma = tela;
	}

	public void actionPerformed(ActionEvent e) {
		new TelaDeMenu(null);
		telaCadastroDePrograma.setVisible(false);
	} // end action

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String genero = telaCadastroDePrograma.getCampoGenero().getText();
			String temporada = telaCadastroDePrograma.getCampoTemporada().getText();
			
			if (nome.isBlank() || horario.isBlank() || genero.isBlank() || temporada.isBlank()) {
				Mensagem.usuarioCampoVazio();
			} else {
				
				Canal canal = centralDeInformacoes.recuperarCanalId(id);
				
				if(canal != null) {
					
					String[] opercao = {"Live Action", "Animada" };
					String entrada = (String) JOptionPane.showInputDialog(null, "Estilo Dá Séries: ", "",
							JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);
					EstiloSeriesRegulares estilo = null;
					
					if(opercao[0] == entrada) {
						estilo = EstiloSeriesRegulares.LIVI_ACTION;
					} else {
						estilo = EstiloSeriesRegulares.ANIMADA;
					} // end else
					
					ProgramaSeriesRegulares programa = new ProgramaSeriesRegulares(genero, estilo, temporada, nome, canal, horario, null);
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					Mensagem.programaSalvo();
					new TelaCadastroDeProgramaSeriesRegulares(null);
				} else {
					Mensagem.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			Mensagem.numberFormatException(number);
		} // end catch
	} // end action
} // end class
