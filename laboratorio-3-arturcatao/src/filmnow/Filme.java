package filmnow;

/**
 * Representação de um filme para o sistema FILMNOW.
 * 
 * @author Artur Catão
 */
import java.util.Objects;

public class Filme {
	/*
	 * Nome do filme.
	 */
	private String nome;

	/*
	 * Ano de lançameto do filme
	 */
	private String ano;

	/*
	 * Estado hot do filme, se ele é ou nao.
	 */
	private boolean hot;

	/*
	 * Onde o cliente assistiu o filme.
	 */
	private String local;

	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		this.hot = false;
	}

	/*
	 * Retorna uma representação textual do filme para o sistema.
	 * 
	 * @return String que representa o filme
	 */
	public String toString() {

		String saida = "";

		if (ano.equals("")) {
			saida = this.nome + "\n" + this.local;
		} else if (local.equals("")) {
			saida = this.nome + ", " + this.ano;
		} else {
			saida = this.nome + ", " + this.ano + "\n" + this.local;
		}

		if (isHot()) {
			saida = "🔥 " + saida;
		}

		return saida;

	}

	public String getNome() {
		return nome;
	}

	public String getAno() {
		return ano;
	}

	public String getLocal() {
		return local;
	}

	/*
	 * Altera o estado do filme, se ele é hot ou nao
	 */
	public void setHot(boolean b) {
		this.hot = b;
	}

	/*
	 * Retorna um boolean que diz se o filme esta na hotlis ou nao
	 * 
	 * @return boolean que representa se o filme é hot ou nao
	 */
	public boolean isHot() {
		return this.hot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(nome, other.nome);
	}

}
