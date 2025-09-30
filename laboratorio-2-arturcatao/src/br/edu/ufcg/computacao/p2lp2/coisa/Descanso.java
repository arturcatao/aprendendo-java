package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Representação de uma rotina de descanso orientada por semanas de um aluno.
 * 
 * @author Artur Catão
 */
public class Descanso {
	
	/**
	 * Tempo necessario de descanso do aluno.
	 */
	private int horasDescanso;
	
	/*
	 * Número de semanas da rotina de descanso do aluno.
	 */
	private int numeroSemanas;

	
	/**
	 * Constroi um Descanso do aluno.
	 * Todo aluno começa com numeroSemanas = 1.
	 * 
	 * @param horasDescanso as horas de descanso do aluno
	 */
	public Descanso() {
		this.numeroSemanas = 1;
	}
	
	/**
	 * Define as horas de descanso do aluno.
	 * 
	 * @param horasDescanso
	 */
	public void defineHorasDescanso(int horasDescanso) {
		this.horasDescanso = horasDescanso;
	}
	
	/**
	 * Define o numero de semanas da rotina de descanso.
	 * @param numeroSemanas
	 */
	public void defineNumeroSemanas(int numeroSemanas) {
		this.numeroSemanas = numeroSemanas;
	}
	
	/**
	 *Retorna o status do descanso do aluno em uma String.
	 *
	 * @return a representação em String do estado do descanso
	 */
	public String getStatusGeral() {
		
		double descanso = horasDescanso / numeroSemanas;
		
		if (descanso < 26) {
			return "cansado";
		}else {
			return "descansado";
		}
	}
}