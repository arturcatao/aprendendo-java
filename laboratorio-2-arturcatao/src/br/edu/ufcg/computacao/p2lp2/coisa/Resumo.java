package br.edu.ufcg.computacao.p2lp2.coisa;

public class Resumo {
	
	/**
	 * Nome do resumo.
	 */
	private String nome;
	
	/*
	 * Conteudo do resumo.
	 */
	private String conteudo;
	
	/**
	 * Constroi um resumo a partir do nome e do conteudo.
	 * 
	 * @param nome
	 * @param conteudo
	 */
	public Resumo(String nome, String conteudo) {
		this.nome = nome;
		this.conteudo = conteudo;
	}
	/**
	 * Retorna o nome do resumoem String.
	 * 
	 * @return String O nome do resumo
	 */
	public String getName() {
		return nome;
	}
	
	/**
	 * Retorna o conteudo do resumo em String.
	 * 
	 * @return String O conteudo do resumo
	 */
	public String getContent() {
		return conteudo;
	}
	
	/**
	 * Retorna uma representação textual do resumo no formato:
	 * "nome: conteúdo".
	 *
	 * @return uma String no formato "nome: conteúdo".
	 */
	public String toString() {
		return getName() + ": " + getContent();
	}
}
