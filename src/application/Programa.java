package application;
import model.CentralDeInformacoes;
import model.Hiato;
import model.Persistencia;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeLogin;

public class Programa {

	public static void main(String[] args) {
		
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
		
		Hiato hiato = new Hiato();
		Thread thread = new Thread(hiato);
		thread.start();
		
		if (centralDeInformacoes.getTodosOsUsuarios().size() > 0) {
			new TelaDeLogin(null);
		} else {
			new TelaDeCadastroDeUsuario(null);
		}
	}
}
