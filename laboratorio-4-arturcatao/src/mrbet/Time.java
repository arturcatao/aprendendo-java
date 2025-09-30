package mrbet;

/**
 * Representação de um time para o sistema MrBet.
 * 
 * @author Artur Catão
 */

import java.util.HashSet;
import java.util.Objects;

public class Time {
	/*
	 * Codigo de identificação do time no sistema
	 */
	private String codigo;

	/*
	 * Nome do time
	 */
	private String nome;

	/*
	 * Mascote do time
	 */
	private String mascote;

	/*
	 * Hash set usado para guardar os campeonatos em que o time participa
	 */
	private HashSet<Campeonato> campeonatos;

	/*
	 * Construtor da classe
	 */
	public Time(String codigo, String nome, String mascote) {
		this.codigo = codigo;
		this.nome = nome;
		this.mascote = mascote;
		this.campeonatos = new HashSet<>();
	}

	/*
	 * Adiciona um campeonato ao time a partir de um campeonato passado pelo sistema
	 * 
	 * @return void
	 */
	public void addCampeonato(Campeonato c) {
		campeonatos.add(c);
	}

	/*
	 * Retorna os campeonatos em que o time participa
	 * 
	 * @return uma representação textual (String) dos campeonatos em que o time
	 * participa
	 */
	public String campsParticipando() {

		if (campeonatos.size() != 0) {

			String saida = "Time: " + this.codigo + " | Campeonatos do " + this.nome;

			for (Campeonato c : campeonatos) {
				saida += " | " + c.toString();
			}

			return saida;

		}

		return "O TIME NAO ESTA EM NENHUM CAMPEONATO!";
	}

	public String getCodigo() {
		return this.codigo;
	}

	/*
	 * Representação textual do time
	 * 
	 * @return String que representa o timeno sistema
	 */
	@Override
	public String toString() {
		return "[" + codigo + "] " + nome + " / " + mascote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
