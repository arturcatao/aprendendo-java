package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author eliane
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */

	private static String menu(Scanner scanner) {
		System.out.println("\n---\nMENU\n" + "(A)Adicionar filme\n" + "(M)Mostrar todos\n" + "(D)Detalhar filme\n"
				+ "(E)Exibir HotList\n" + "(H)Atribuir Hot\n" + "(R)Remover Hot\n" + "(S)air\n" + "\n" + "Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn      O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			atribuirHot(fn, scanner);
			break;
		case "R":
			removerHot(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {
		System.out.println(fn.mostrarFilmes());
	}

	/**
	 * Imprime os detalhes de um dos filmes.
	 * 
	 * @param fn      O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = scanner.nextInt();
		String filme = fn.detalharFilme(posicao);
		System.out.println(filme);
	}

	/**
	 * Formata um filme para impressão.
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme   O filme a ser impresso.
	 * @return A String formatada.
	 */

	/**
	 * Cadastra um filme no sistema.
	 * 
	 * @param fn      O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.print("\nAno> ");
		String ano = scanner.next();
		System.out.print("\nLocal> ");
		String local = scanner.next();
		System.out.println(fn.cadastraFilme(posicao, nome, ano, local));

	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv.
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn            O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();

		int carregados = leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	private static void exibirHotList(FilmNow fn) {
		String[] saida = fn.exibirHotList();

		for (int i = 0; i < fn.getQtdHotList(); i++) {
			System.out.println(saida[i]);
		}
	}

	private static void atribuirHot(FilmNow fn, Scanner scanner) {
		System.out.print("\nFilme> ");
		int posicaoFilme = scanner.nextInt();
		System.out.print("\nPosição> ");
		int posicaoHot = scanner.nextInt();

		System.out.println(fn.atribuirHot(posicaoFilme, posicaoHot));
	}

	private static void removerHot(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		fn.removerHot(posicao);
	}

}
