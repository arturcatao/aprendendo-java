package mrbet;

/**
 * Representação de um campeonato para o sistema MrBet.
 * 
 * @author Artur Catão
 */

import java.util.HashSet;
import java.util.Objects;

public class Campeonato {

	/*
	 * Nome do campeonato
	 */
	private String nome;

	/*
	 * Maximo de participantes em um campeonato
	 */
	private int maxPaticipantes;

	/*
	 * Hash set de times para guardar os times participantes pelo codigo
	 */
	private HashSet<Time> times;

	/*
	 * Construtor da classe
	 */
	public Campeonato(String nome, int maxParticipantes) {
		this.nome = nome;
		this.maxPaticipantes = maxParticipantes;
		this.times = new HashSet<>();
	}

	/*
	 * Metodo que inclui um time no campeonato O time é armazenado em um HashSet
	 * 
	 * @return uma representação textual do status da operação
	 */
	public String incluirTime(Time t) {
		if (maxPaticipantes <= times.size()) {
			return "TODOS OS TIMES DESSE CAMPEONATO JA FORAM INCLUIDOS!";
		} else if (times.contains(t)) {
			return "O TIME JA FOI INCLUIDO ANTERIORMENTE!";
		}

		times.add(t);

		return "TIME INCLUIDO NO CAMPEONATO!";
	}

	/*
	 * Metodo que verifica se um time esta ou nao no campeonato a partir de um time
	 * passado pelo sistema
	 * 
	 * @return uma representação textual que diz se o time esta ou nao no campeonato
	 */
	public String verificarTime(Time t) {
		if (times.contains(t)) {
			return "O TIME ESTA NO CAMPEONATO!";
		}

		return "O TIME NAO ESTA NO CAMPEONATO!";
	}

	public String getNome() {
		return nome;
	}

	public int getMaxParticipantes() {
		return this.maxPaticipantes;
	}

	/*
	 * Retorna uma representação textual do Campeonato ao sistema.
	 * 
	 * @return String que representa o Campeonato
	 */
	@Override
	public String toString() {
		return "* " + nome + " - " + times.size() + "/" + maxPaticipantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome.toLowerCase(), other.nome.toLowerCase());
	}
}
