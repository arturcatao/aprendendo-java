package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Representação do registro do tempo online de um aluno dedicado a uma disciplina.
 * 
 * @author Artur Catão
 */
public class RegistroTempoOnline {
	
	/*
	 * Nome da disciplina.
	 */
	private String nomeDisciplina;
	
	/*
	 * Tempo online esperado a ser dedicado a disciplina.
	 */
	private int tempoOnlineEsperado;
	
	/*
	 * Tempo online dedicado a disciplina.
	 */
	private int tempoOnline;
	
	/**
	 * Constroi um registro de tempo online de um aluno dedicado a uma disciplina 
	 * a partir do nome da desciplina e do tempo online esperado.
	 * 
	 * @param nomeDisciplina
	 * @param tempoOnlineEsperado
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}
	/**
	 * Constroi um registro de tempo online de um aluno dedicado a uma disciplina 
	 * a partir do nome da desciplina com o tempo esperado padrão (120 horas).
	 *  
	 * @param nomeDisciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this(nomeDisciplina, 120);
	}
	
	/**
	 * Adiciona tempo online ao ja existente do aluno
	 * 
	 * @param tempo
	 */
	public void adicionaTempoOnline(int tempo) {
		tempoOnline += tempo;
	}
	
	/**
	 * Retorna um boolean representando se o estudante atingiu a
	 * meta de tempo online para a disciplina.
	 * 
	 * @return boolean Se o tempo foi atingido ou nao
	 */
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnline >= tempoOnlineEsperado) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna uma String que representa o tempo 
	 * 
	 * @return String "nomeDisciplina tempoOnline/tempoOnlineEsperado"
	 */
	public String toString() {
		return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
	}
	
	
}
