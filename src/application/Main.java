package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import applicationAgenda.Hiato;
import model.CentralDeInformacoes;
import model.Persistencia;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeLogin;

public class Main {

	public static void main(String[] args) {
		
	

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

		Hiato hiato = new Hiato();
		Thread thread = new Thread(hiato);
		thread.start();

		DayOfWeek dayOfWeekK = DayOfWeek.FRIDAY;
		System.out.println("Day: " + dayOfWeekK);

		int value = dayOfWeekK.getValue();
		System.out.println(value);

		if (centralDeInformacoes.getTodosOsUsuarios().size() > 0) {
			new TelaDeLogin(null);
		} else {
			new TelaDeCadastroDeUsuario(null);
		}
		
		
		DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        for (int i = 0; i < dayOfWeeks.length; i++) {
            DayOfWeek dayOfWeek = dayOfWeeks[i];
            System.out.println("dayOfWeek[" + i + "] = " + dayOfWeek + "; value = " +
                    dayOfWeek.getValue());
        }

        // Get DayOfWeek from int value
        DayOfWeek dayOfWeek = DayOfWeek.of(1);
        System.out.println("dayOfWeek = " + dayOfWeek);

        // Get DayOfWeek from string value
        dayOfWeek = DayOfWeek.valueOf("SATURDAY");
        System.out.println("dayOfWeek = " + dayOfWeek);

        // Get DayOfWeek of a date object
        LocalDate date = LocalDate.now();
        DayOfWeek dow = date.getDayOfWeek();

        System.out.println("Date  = " + date + "aqui");
        System.out.println("Dow   = " + dow + "; value = " + dow.getValue());

        // Get DayOfWeek display name in different locale.
        Locale locale = new Locale("id", "ID");
        String indonesian = dow.getDisplayName(TextStyle.SHORT, locale);
        System.out.println("ID = " + indonesian);

        String germany = dow.getDisplayName(TextStyle.FULL, Locale.GERMANY);
        System.out.println("DE = " + germany);

        // Adding number of days to DayOfWeek enum.
        System.out.println("DayOfWeek.MONDAY.plus(4) = " + DayOfWeek.MONDAY.plus(4));
    }
}
