	package mrbet;
	
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.*;
	
	public class MainMrBet {
		public static void main(String[] args) {
	
			MrBetFachada mb = new MrBetFachada();
	
			Scanner scanner = new Scanner(System.in);
			String escolha = "";
			while (true) {
				escolha = menu(scanner);
				comando(escolha, mb, scanner);
			}
	
		}
	
		private static String menu(Scanner sc) {
			System.out.println("\n(M)Minha inclusão de times\n" + "(R)Recuperar time\n" + "(.)Adicionar campeonato\n"
					+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
					+ "(E)Exibir campeonatos que o time participa\n" + "(T)Tentar a sorte e status\n"
					+ "(!)Já pode fechar o programa!\n\n" + "Opção> ");
			return sc.nextLine().toUpperCase();
		}
	
		private static String menu2(Scanner sc) {
			System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time esta em campeonato?");
	
			return sc.nextLine().toUpperCase();
		}
	
		private static String menu3(Scanner sc) {
			System.out.println("(A) Apostar ou (S) Status das Apostas?");
	
			return sc.nextLine().toUpperCase();
		}
	
		private static void comando(String opcao, MrBetFachada mb, Scanner sc) {
			switch (opcao) {
			case "M":
				incluirTime(mb, sc);
				break;
			case "R":
				recuperarTime(mb, sc);
				break;
			case ".":
				incluirCampeonato(mb, sc);
				break;
			case "B":
				switch (menu2(sc)) {
				case "I":
					incluirTimeCampeonato(mb, sc);
					break;
				case "V":
					verificaTimeCampeonato(mb, sc);
					break;
				default:
					System.out.println("Opção inválida!");
				}
				break;
			case "E":
				exibirCampeonatosTime(mb, sc);
				break;
			case "T":
				switch (menu3(sc)) {
				case "A":
					tentarSorte(mb, sc);
					break;
				case "S":
					statusAposta(mb, sc);
					break;
				default:
					System.out.println("Opção inválida!");
				}
				break;
			case "!":
				sai();
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	
		private static void incluirTime(MrBetFachada mb, Scanner sc) {
	
			System.out.println("Codigo: ");
			String codigo = sc.nextLine();
	
			System.out.println("Nome: ");
			String nome = sc.nextLine();
	
			System.out.println("Mascote: ");
			String mascote = sc.nextLine();
	
			System.out.println(mb.incluirTime(codigo, nome, mascote));
	
		}
	
		private static void recuperarTime(MrBetFachada mb, Scanner sc) {
			System.out.println("Codigo: ");
			String codigo = sc.nextLine();
	
			System.out.println(mb.recuperarTime(codigo));
		}
	
		private static void incluirCampeonato(MrBetFachada mb, Scanner sc) {
			System.out.println("nome: ");
			String nome = sc.nextLine();
	
			System.out.println("Quantidade de Participantes: ");
			int participantes = sc.nextInt();
	
			System.out.println(mb.incluirCampeonato(nome, participantes));
		}
	
		private static void incluirTimeCampeonato(MrBetFachada mb, Scanner sc) {
			System.out.println("Codigo do time: ");
			String codTime = sc.nextLine();
	
			System.out.println("Nome do campeonato: ");
			String nomeCamp = sc.nextLine();
	
			System.out.println(mb.incluirTimeCampeonato(codTime, nomeCamp));
		}
	
		private static void verificaTimeCampeonato(MrBetFachada mb, Scanner sc) {
			System.out.println("Codigo do time: ");
			String codTime = sc.nextLine();
	
			System.out.println("Nome do campeonato: ");
			String nomeCamp = sc.nextLine();
	
			System.out.println(mb.verificaTimeCampeonato(codTime, nomeCamp));
		}
	
		private static void exibirCampeonatosTime(MrBetFachada mb, Scanner sc) {
			System.out.println("Codigo do time: ");
			String codTime = sc.nextLine();
	
			System.out.println(mb.campsParticipando(codTime));
		}
	
		private static void tentarSorte(MrBetFachada mb, Scanner sc) {
			System.out.println("Codigo do time: ");
			String codTime = sc.nextLine();
	
			System.out.println("Nome do campeonato: ");
			String nomeCamp = sc.nextLine();
	
			System.out.println("Colocacao: ");
			int coloc = sc.nextInt();
	
			System.out.println("Valor: ");
			double valor = sc.nextDouble();
	
			System.out.println(mb.tentarSorte(codTime, nomeCamp, coloc, valor));
	
		}
	
		private static void statusAposta(MrBetFachada mb, Scanner sc) {
			System.out.println(mb.statusAposta());
		}
	
		private static void sai() {
			System.out.println("\npor hoje e so pessoal\n");
			System.exit(0);
		}
	
	}
