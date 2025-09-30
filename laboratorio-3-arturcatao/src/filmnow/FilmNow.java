package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 * 
 * @author eliane / artur catao
 *
 */
public class FilmNow {

	private static final int TAMANHO = 100;

	private int numeroFilmes;

	private Filme[] filmes; // uma representacao simploria da lista de filmes

	private HotList ht;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.numeroFilmes = 0;
		this.ht = new HotList();
	}

	/**
	 * Acessa a lista de filmes mantida.
	 * 
	 * @return O array de filmes.
	 */
	public String mostrarFilmes() {

		String saida = "";

		for (int i = 0; i < TAMANHO; i++) {
			if (filmes[i] != null) {

				saida += "\n" + (i + 1) + " - " + filmes[i].getNome();
			}
		}

		return saida;
	}

	/**
	 * Acessa os dados de um filme específico.
	 * 
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String detalharFilme(int posicao) {
		if (verificaPosicao(posicao, 1, 100)) {

			if (filmes[posicao - 1] != null) {
				return "\nDados do filme:\n" + filmes[posicao - 1].toString();

			} else {
				return "";
			}
		} else {
			return "\nPOSIÇÃO INVÁLIDA";
		}
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve
	 * o anterior.
	 * 
	 * @param posicao Posição do filme.
	 * @param nome    Nome do filme.
	 * @param ano     Ano de lançamento do filme.
	 * @param local   Local onde o filme pode ser assitido.
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local) {

		if (!verificaPosicao(posicao, 1, 100)) {
			return "POSIÇÃO INVÁLIDA";
		} else if (nome.equals("")) {
			return "FILME INVALIDO";
		}

		Filme filme = new Filme(nome, ano, local);

		if (taNaLista(filme) && !filme.equals(filmes[posicao - 1])) {
			return "FILME JÁ ADICIONADO";
		} else {
			this.filmes[posicao - 1] = filme;
			this.numeroFilmes++;
			return "FILME ADICIONADO";
		}
	}

	private boolean taNaLista(Filme f) {
		for (int i = 0; i < TAMANHO; i++) {
			if (f.equals(filmes[i])) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Repassa o Array de Strings da HotList para o main para gerar uma
	 * representação textual da HotList
	 * 
	 * @return String[] para a representação textual da HL
	 */
	public String[] exibirHotList() {
		return ht.exibir();
	}

	/*
	 * Retorna a quantidade de filmes cadastrados na HL
	 * 
	 * @return int de quantidade de Hots
	 */
	public int getQtdHotList() {
		return ht.getQtdFilmes();
	}

	/*
	 * Adiciona ou nao um filme a HotList e retorna uma String que representa o
	 * estado do pedido
	 * 
	 * @param int posição do filme no FN e int posicao que o filme vai para o
	 * HotList
	 * 
	 * @return String que representa qual o resultado do uso do metodo para ser
	 * retornada ao usuario
	 */
	public String atribuirHot(int posicaoFilme, int posicaoHot) {

		if (!verificaPosicao(posicaoFilme, 1, 100) || !verificaPosicao(posicaoHot, 1, 10)
				|| filmes[posicaoFilme - 1] == null) {
			return "POSIÇÃO INVÁLIDA";
		} else {
			Filme filme = filmes[posicaoFilme - 1];
			if (filme.isHot()) {
				return "FILME JÁ ADICIONADO";
			} else {
				ht.rmvFilme(posicaoHot);
				ht.addFilme(filme, posicaoHot);
				return "ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!";
			}
		}
	}

	/*
	 * Remove um filme da HotList a partir de sua posição na mesma
	 * 
	 * @param int posicao do filme na HL
	 * 
	 * @return boolean que diz se o filme foi removido ou nao
	 */
	public boolean removerHot(int posicao) {
		return ht.rmvFilme(posicao);
	}

	private boolean verificaPosicao(int p, int min, int max) {
		if (p >= min && p <= max) {
			return true;
		}

		return false;
	}

}
