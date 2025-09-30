package br.edu.ufcg.computacao.p2lp2.coisa;

/**
 * Representação de uma disciplina, indentificada pelo nome.
 * 
 * @author arturcatao
 */
import java.util.Arrays;

public class Disciplina {
	
	/**
	 * Quantidade de horas de estudos determinada para a disciplina.
	 */
	private int horas;
	
	/**
	 * Nome da disciplina .
	 */
	private String nomeDisciplina;
	
	/**
	 * Notas do aluno na disciplina.
	 */
	private double[] notas;
	
	/**
	 * Constroi uma disciplina a partir do nome.
	 * 
	 * @param nomeDisciplina
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[4];
	}
	
	/**
	 * Cadastra a quantidade de horas referente a disciplina a partir de um inteiro horas.
	 * 
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 * Cadastra uma nota do aluno na disciplina a partir de qual nota e do valor da nota.
	 * Possibilita uma substituição de nota.
	 * 
	 * @param posicaoNota
	 * @param valorNota
	 */
	public void cadastraNota(int posicaoNota, double valorNota) {
		notas[posicaoNota - 1] = valorNota;
	}
	
	/**
	 * Calcula a media a partir das notas do aluno 
	 * para saber se ele foi aprovado ou nao.
	 * 
	 * @return double A media calculada
	 */
	private double media() {
		double soma = 0;
		for (int i = 0; i < notas.length; i ++) {
			soma += notas[i];
		}
		
		return soma / notas.length;
	}
	
	/**
	 * Calcula com base no metodo media() se o aluno foi aprovado ou nao
	 * e retorna um boolean
	 * 
	 * @return boolean Aprovação ou reprovação
	 */
	public boolean aprovado() {
		if (media() < 7) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * Retorna uma representação textual da disciplina no formato:
	 * "nomeDisciplina horas média [notas]".
	 *
	 * @return uma String representando a disciplina e seu estado atual.
	 */
	public String toString() {
		return nomeDisciplina + " " + horas + " " + media() + " " + Arrays.toString(notas); 
	}

}
