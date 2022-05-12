package application;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Canal;
import entity.ProgramaDeTV;
import enuns.diasDaSemanas;
import enuns.tipoDePrograma;
import model.CentralDeInformacoes;
import model.GeradorDeRelatorio;
import model.Mensageiro;
import model.Persistencia;

public class Programa {

	public static void main(String[] args) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

		Scanner leitor = new Scanner(System.in);
		boolean sair = false;
		boolean maisAlgumDia = false;
		ArrayList<diasDaSemanas> diasDaSemana = new ArrayList<diasDaSemanas>();

		while (sair == false) {

			System.out.println("1 - Novo Programa");
			System.out.println("2 - Listar Todos Os Programas");
			System.out.println("3 - Listar Todos Os Programas Do Mesmo Tipo");
			System.out.println("4 - Novo Canal De Televisão");
			System.out.println("5 - Listar Todos Os Canais De Televisão");
			System.out.println("6 - Gerar PDF");
			System.out.println("7 - Enviar Email");
			System.out.println("S - sair");
			String resposta = leitor.nextLine();

			switch (resposta) {

			case "1":

				System.out.println("Nome Do Programa:");
				String nome = leitor.nextLine();
				System.out.println("1 - Séries regulares. 2 Reality Shows. 3 Progra,a contínuos");
				String op = leitor.nextLine();
				tipoDePrograma programa = null;

				if (op.equals("1")) {
					programa = tipoDePrograma.SERIES_REGULARES;
				} else if (op.equals("2")) {
					programa = tipoDePrograma.REALITY_SHOWS;
				} else {
					programa = tipoDePrograma.PROGRAMAS_CONTINUOS;
				}

				diasDaSemanas dia = null;
				while (maisAlgumDia == false) {

					System.out.println("Dia Da Semana: S para não perguntar mais");
					String dias = leitor.nextLine();
					dias.toLowerCase();

					switch (dias) {
					case "segunda":
						dia = diasDaSemanas.SEGUNDA;
						diasDaSemana.add(dia);
						break;
					case "terça":
						dia = diasDaSemanas.TERÇA;
						diasDaSemana.add(dia);
						break;
					case "quarta":
						dia = diasDaSemanas.QUARTA;
						diasDaSemana.add(dia);
						break;
					case "quinta":
						dia = diasDaSemanas.QUINTA;
						diasDaSemana.add(dia);
						break;
					case "sexta":
						dia = diasDaSemanas.SEXTA;
						diasDaSemana.add(dia);
						break;
					case "sabado":
						dia = diasDaSemanas.SABADO;
						diasDaSemana.add(dia);
						break;
					case "domingo":
						dia = diasDaSemanas.DOMINGO;
						diasDaSemana.add(dia);
						break;
					case "S":
						maisAlgumDia = true;
					}
					
				}
				
				for (Canal c : centralDeInformacoes.getTodosOsCanais()) {
					System.out.println(c);
				}

				System.out.println("Qual canal se passa o programa?");
				String nomeDoCanal = leitor.nextLine();

				if (centralDeInformacoes.recuperarCanal(nomeDoCanal) != null) {
					ProgramaDeTV programaDeTV = new ProgramaDeTV(nome, programa,
							centralDeInformacoes.recuperarCanal(nomeDoCanal), diasDaSemana);

					if (centralDeInformacoes.adicionarProgramaDeTV(programaDeTV)) {
						System.out.println("Programa Salvo Com Sucesso!");
						persistencia.salvarCentral(centralDeInformacoes);
					} else {
						System.out.println("Algo deu errado!");
					}
				} else {
					System.out.println("Canal não encontrado");
				}
				break;
			case "2":

				for (ProgramaDeTV tv : centralDeInformacoes.getTodosOsProgramas()) {
					System.out.println(tv.toString());
				}
				break;

			case "3":

				System.out.println(
						"informe o tipo do Programa: 1 Séries regulares. 2 Reality Shows. 3 Progra,a contínuos");
				String tipo = leitor.nextLine();

				if (tipo.equals("1")) {
					programa = tipoDePrograma.SERIES_REGULARES;
				} else if (tipo.equals("2")) {
					programa = tipoDePrograma.REALITY_SHOWS;
				} else {
					programa = tipoDePrograma.PROGRAMAS_CONTINUOS;
				}

				for (int i = 0; i < centralDeInformacoes.getTodosOsProgramas().size(); i++) {
					if (centralDeInformacoes.getTodosOsProgramas().get(i).getTipoDePrograma().equals(programa)) {
						System.out.println(centralDeInformacoes.getTodosOsProgramas().get(i));
						continue;
					}
					continue;
				}
				break;

			case "4":

				System.out.println("Nome Do Canal: ");
				String nomeCanal = leitor.nextLine();
				System.out.println("Tipo Do Canal: ");
				String tipoCanal = leitor.nextLine();
				Canal canalDeTV = new Canal(nomeCanal, tipoCanal);

				if (centralDeInformacoes.salvarCanal(canalDeTV)) {
					persistencia.salvarCentral(centralDeInformacoes);
					System.out.println("Canal Salvo");
				} else {
					System.out.println("Canal já existe com esse nome");
				}

				break;
			case "5":

				for (Canal c : centralDeInformacoes.getTodosOsCanais()) {
					System.out.println(c.toString());
				}

				break;
			case "6":

				GeradorDeRelatorio.obterProgramacaoDeUmCana(centralDeInformacoes.getTodosOsProgramas());
				System.out.println("PDF criado");
				break;

			case "7":

				System.out.println("Assunto: ");
				String assunto = leitor.nextLine();
				System.out.println("Informe o Email do destinatio: ");
				String destinatario = leitor.nextLine();
				for (int i = 0; i < centralDeInformacoes.getTodosOsProgramas().size(); i++) {
					Mensageiro.enviarProgramacaoDeHoje(assunto, destinatario, centralDeInformacoes.toString());
				}
				break;

			case "S":
				sair = true;
				System.out.println("Você saiu!");
				persistencia.salvarCentral(centralDeInformacoes);
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
		leitor.close();
	}
}
