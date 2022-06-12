package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Canal;
import entity.ProgramaSeriesRegulares;
import enuns.DiasDaSemanas;
import enuns.EstiloSeriesRegulares;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
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

			SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
			Date data = null;
			String nome = telaCadastroDePrograma.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(telaCadastroDePrograma.getCampoIDCanal().getText());
			String horario = telaCadastroDePrograma.getCampoHorario().getText();
			String genero = telaCadastroDePrograma.getCampoGenero().getText();
			String temporada = telaCadastroDePrograma.getCampoTemporada().getText();
	        String dia = telaCadastroDePrograma.getCampoDiasDaSemana().getText();
	        dia.toUpperCase();
	        DiasDaSemanas dias = null;
	        
	        
			if (nome.isBlank() || horario.isBlank() || genero.isBlank() || temporada.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					String[] opercao = { "Live Action", "Animada" };
					String entrada = (String) JOptionPane.showInputDialog(null, "Estilo D� S�ries: ", "",
							JOptionPane.WARNING_MESSAGE, null, opercao, opercao[0]);
					EstiloSeriesRegulares estilo = null;

					if (opercao[0] == entrada) {
						estilo = EstiloSeriesRegulares.LIVI_ACTION;
					} else {
						estilo = EstiloSeriesRegulares.ANIMADA;
					} // end else

					String[] status = { "Exibi��o", "Hiato", "Finalizado", "Cancelado" };
					String entradaStatus = (String) JOptionPane.showInputDialog(null, "Estilo D� S�ries: ", "",
							JOptionPane.WARNING_MESSAGE, null, status, status[0]);

					StatusDeExebicao exebicao = null;

					if (status[0] == entradaStatus) {
						exebicao = StatusDeExebicao.EXIBICAO;
					} else if (status[1] == entradaStatus) {
						exebicao = StatusDeExebicao.HIATO;
						data = formatar.parse(JOptionPane.showInputDialog("Data de exebi��o: Separe por barras /. "));
					} else if (status[2] == entradaStatus) {
						exebicao = StatusDeExebicao.FINALIZADO;
					} else {
						exebicao = StatusDeExebicao.CANCELADO;
					}

					ProgramaSeriesRegulares programa = new ProgramaSeriesRegulares(nome, exebicao, canal, null, horario, data, temporada, genero, estilo);
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					MensagemPrograma.programaSalvo();
					new TelaCadastroDeProgramaSeriesRegulares(null);
					telaCadastroDePrograma.setVisible(false);
				} else {
					MensagemCanal.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
	} // end action
} // end class
