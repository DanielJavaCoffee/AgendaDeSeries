package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Canal;
import entity.ProgramaContinuo;
import entity.ProgramaSeriesRegulares;
import enuns.DiasDaSemanas;
import enuns.EstiloSeriesRegulares;
import enuns.StatusDeExebicao;
import enuns.TipoDePrograma;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.Mensagem;
import tela.TelaCadastroDeProgramaContinuo;
import tela.TelaCadastroDeProgramaSeriesRegulares;
import tela.TelaDeMenu;

public class OuvinteTelaDeCadastroDeProgramaContinuo implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
	private TelaCadastroDeProgramaContinuo telaCadastroDePrograma;

	public TelaCadastroDeProgramaContinuo getTelaCadastroDePrograma() {
		return telaCadastroDePrograma;
	}

	public OuvinteTelaDeCadastroDeProgramaContinuo(TelaCadastroDeProgramaContinuo tela) {
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
	        String dia = telaCadastroDePrograma.getCampoDiasDaSemana().getText();
	        String apresentador = telaCadastroDePrograma.getCampoApresentador().getText();
	        dia.toUpperCase();
	        DiasDaSemanas dias = null;
	        
			if (nome.isBlank() || horario.isBlank()) {
				Mensagem.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					String[] status = { "Exibição", "Hiato", "Finalizado", "Cancelado" };
					String entradaStatus = (String) JOptionPane.showInputDialog(null, "Status De Exebição: ", "",
							JOptionPane.WARNING_MESSAGE, null, status, status[0]);

					StatusDeExebicao exebicao = null;

					if (status[0] == entradaStatus) {
						exebicao = StatusDeExebicao.EXIBICAO;
					} else if (status[1] == entradaStatus) {
						exebicao = StatusDeExebicao.HIATO;
						data = formatar.parse(JOptionPane.showInputDialog("Data de exebição: Separe por barras /. "));
					} else if (status[2] == entradaStatus) {
						exebicao = StatusDeExebicao.FINALIZADO;
					} else {
						exebicao = StatusDeExebicao.CANCELADO;
					} // end else

					ProgramaContinuo programa = new ProgramaContinuo(nome, apresentador, exebicao, canal, null, horario, data);
					centralDeInformacoes.adicionarProgramaDeTV(programa);
					persistencia.salvarCentral(centralDeInformacoes);
					Mensagem.programaSalvo();
					new TelaCadastroDeProgramaSeriesRegulares(null);
					telaCadastroDePrograma.setVisible(false);
				} else {
					Mensagem.canalNaoEncontardo();
				} // end else
			} // end if
		} catch (NumberFormatException number) {
			Mensagem.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
	} // end action
} // end class
