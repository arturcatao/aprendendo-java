package filmnow;

/**
 * Representação da HOT LIST do sistema FILMNOW.
 * 
 * @author Artur Catão
 */

public class HotList {

	// inteiro que representa o tamanho fixo da HOT LIST
	private static int TAMANHO = 10;

	// lista para armazenar os filmes da hot list
	private Filme[] lista;

	// inteiro que representa a quantidade de filmes na hotlist
	private int qtdFilmes;

	/*
	 * Constroi a hot list sem parametros
	 */
	public HotList() {
		this.lista = new Filme[TAMANHO];
	}

	/*
	 * Adiciona um filme a hot list em determinada posição
	 * 
	 * @param f ,filme e posicao, inteiro que representa o local do filme na lista
	 * 
	 * @return boolean que representa se o filme foi adicionado ou nao
	 */
	public boolean addFilme(Filme f, int posicao) {
		if (verificaPosicao(posicao) && !(f.isHot())) {
			lista[posicao - 1] = f;
			this.qtdFilmes++;
			f.setHot(true);
			return true;
		}

		return false;
	}

	/*
	 * Remove um filme da hot list em determinada posição
	 * 
	 * @param f ,filme e posicao, inteiro que representa o local do filme na lista
	 * 
	 * @return boolean que representa se o filme foi removido ou nao
	 */
	public boolean rmvFilme(int posicao) {
		if (verificaPosicao(posicao) && lista[posicao - 1] != null) {
			lista[posicao - 1].setHot(false);
			lista[posicao - 1] = null;
			this.qtdFilmes--;
			return true;
		}

		return false;
	}

	/*
	 * Retorna um array de strings que vai ser usado para representar textualmente o
	 * HotList
	 * 
	 * @return Array de strings representando a HotList
	 */
	public String[] exibir() {
		String[] saida = new String[getQtdFilmes()];

		int i = 0;
		int j = 0;

		while (j < saida.length && i < TAMANHO) {
			if (lista[i] != null) {
				saida[j] = (i + 1) + " - " + lista[i].getNome() + ", " + lista[i].getAno();
				j++;
			}
			i++;
		}

		return saida;
	}

	public int getQtdFilmes() {
		return this.qtdFilmes;
	}

	private boolean verificaPosicao(int posicao) {
		if (posicao >= 1 && posicao <= TAMANHO) {
			return true;
		}

		return false;
	}
}