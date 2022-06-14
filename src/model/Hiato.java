package model;

import java.util.Calendar;
import java.util.Date;

import enuns.StatusDeExebicao;
import personalizedMessage.MensagemAgenda;

public class Hiato implements Runnable {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	public Date getData(Date aDate) {
		final Calendar myCalendar = Calendar.getInstance();
		myCalendar.setTime(aDate);
		myCalendar.set(Calendar.HOUR_OF_DAY, 0);
		myCalendar.set(Calendar.MINUTE, 0);
		myCalendar.set(Calendar.SECOND, 0);
		myCalendar.set(Calendar.MILLISECOND, 0);
		return myCalendar.getTime();
	}

	@Override
	public void run() {

		Date hiato = new Date();
		for (int i = 0; i < centralDeInformacoes.getTodasAsAgendas().size(); i++) {
			if (getData(hiato).equals(centralDeInformacoes.getTodasAsAgendas().get(i).getDataHiato())) {
				MensagemAgenda.hiatoHoje(hiato, centralDeInformacoes.getTodasAsAgendas().get(i));
				centralDeInformacoes.getTodasAsAgendas().get(i).setStatusDeExebicao(StatusDeExebicao.EXIBICAO);
				centralDeInformacoes.getTodasAsAgendas().get(i).setDataHiato(new Date());
				persistencia.salvarCentral(centralDeInformacoes);
			}
		}
	}
}
