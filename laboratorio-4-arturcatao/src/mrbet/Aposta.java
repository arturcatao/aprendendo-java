package mrbet;

/**
 * Representação de uma Aposta para o MrBet
 * 
 * @author Artur Catão
 */

public class Aposta {
	
	/*
	 * Time apostado
	 */
	private Time t;
	
	/*
	 * Campeonato em que a aposta foi feita
	 */
	private Campeonato c;
	
	/*
	 * Colocação apostada
	 */
	private int colocacao;
	
	/*
	 * Valor apostado
	 */
	private double valor;
	
	/*
	 * Construtor da classe
	 */
	public Aposta(Time t, Campeonato c, int colocacao, double valor) {
		this.t = t;
		this.c = c;
		this.colocacao = colocacao;
		this.valor = valor;
	}

	/*
	 * Retorna uma representação textual da Aposta ao sistema.
	 * 
	 * @return String que representa a Aposta
	 */
	public String toString() {
		return t.toString() + " | " + c.getNome() + " - " + this.colocacao + "/" + c.getMaxParticipantes() + " | R$" + valor;
	}

}
