package ouvinte;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Canal;
import entity.ProgramaContinuo;
import entity.ProgramaDeTV;
import enuns.DiasDaSemanas;
import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Persistencia;
import personalizedMessage.MensagemException;
import personalizedMessage.MensagemCanal;
import personalizedMessage.MensagemPrograma;
import personalizedMessage.MensagemUsuario;
import tela.TelaEditarProgramaContinuo;
import tela.TelaListarTodosOsProgramas;

public class OuvinteTelaEditarProgramaContinuo implements ActionListener {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	private TelaEditarProgramaContinuo editarProgramaContinuo;

	public TelaEditarProgramaContinuo tela() {
		return editarProgramaContinuo;
	}

	public OuvinteTelaEditarProgramaContinuo(TelaEditarProgramaContinuo tela) {
		this.editarProgramaContinuo = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new TelaListarTodosOsProgramas(null);
		editarProgramaContinuo.setVisible(true);
	}

	public void actionPerformedSalvar(ActionEvent e) {

		try {

			SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");

			Date data = null;
			String nome = editarProgramaContinuo.getCampoNomeDoPrograma().getText();
			long id = Long.parseLong(editarProgramaContinuo.getCampoIDCanal().getText());
			String horario = editarProgramaContinuo.getCampoHorario().getText();
			String dia = editarProgramaContinuo.getCampoDiasDaSemana().getText();
			String apresentador = editarProgramaContinuo.getCampoApresentador().getText();
			dia.toUpperCase();
			DiasDaSemanas dias = null;
			long idPrograma = Long.parseLong(editarProgramaContinuo.getCampoID().getText());

			if (nome.isBlank() || horario.isBlank()) {
				MensagemUsuario.usuarioCampoVazio();
			} else {

				Canal canal = centralDeInformacoes.recuperarCanalId(id);

				if (canal != null) {

					String[] status = { "Exibi��o", "Hiato", "Finalizado", "Cancelado" };
					String entradaStatus = (String) JOptionPane.showInputDialog(null, "Status De Exebi��o: ", "",
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
					} // end else

					ProgramaDeTV programa = centralDeInformacoes.recuperarProgramaDeTVporId(idPrograma);

					if (programa instanceof ProgramaContinuo) {
						ProgramaContinuo pc = (ProgramaContinuo) programa;

						if (programa != null) {

							pc.setNome(nome);
							pc.setNomeDoApresentador(apresentador);
							pc.setStatusDeExebicao(exebicao);
							pc.setCanal(canal);
							pc.setDias(null);
							pc.setHorario(horario);
							pc.setDataHiato(data);
							
							persistencia.salvarCentral(centralDeInformacoes);
							MensagemPrograma.programaSalvo();
							new TelaListarTodosOsProgramas(null);
							editarProgramaContinuo.setVisible(false);
						}
					} else {
						MensagemCanal.canalNaoEncontardo();
					}
				}
			}  
		} catch (NumberFormatException number) {
			MensagemException.numberFormatException(number);
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
	}
}
