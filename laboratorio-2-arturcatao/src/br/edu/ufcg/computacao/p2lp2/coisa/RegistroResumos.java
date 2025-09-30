package br.edu.ufcg.computacao.p2lp2.coisa;
/**
 * Representação do registro dos resumos.
 * 
 * @author Artur Catão
 */
public class RegistroResumos {
	
	/*
	 * Quantidade de resumos maximo a ser registrado.
	 */
	private int numeroDeResumos;
	
	/*
	 * Contador de quantos resumos foram registrados.
	 */
	private int contador;
	
	/*
	 * Resumos registrados.
	 */
	private Resumo[] resumos;
	
	/**
	 * Constroi um registro de resumos a partir do 
	 * numero de resumos que se deseja registrar.
	 * 
	 * @param numeroDeResumos
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.numeroDeResumos = numeroDeResumos;
		this.resumos = new Resumo[numeroDeResumos];
		this.contador = 0;
	}
	
	/**
	 * Cria um resumo a partir do tema e conteudo,
	 * o armazena no registro e incrementa o contador.
	 * 
	 * @param tema
	 * @param conteudo
	 */
	public void adiciona(String tema, String conteudo) {
		if (!temResumo(tema)) {
			Resumo r = new Resumo(tema, conteudo);
			resumos[contador % numeroDeResumos] = r;
			contador++;
		}
	}
	
	/**
	 * Retorna um array dos resumos registrados, representados
	 * como String "nome + conteudo".
	 * 
	 * @return String[] Um array de resumos
	 */
	public String[] pegaResumos() {
		String[] saida = new String[conta()];
		
		for (int i = 0; i < conta(); i++) {
			saida[i] = resumos[i].toString();
		}
		
		return saida;
	}
	
	/**
	 * Retorna uma representação em String dos resumos representados como:
	 *" Resumos:
	 *	(quantidade de resumos) resumo(s) cadastrado(s)
	 *	(nomes dos resumos)
	 
	 * 
	 * @return String A representação de todos os resumos
	 */
	public String imprimeResumos() {
		
		String saida = "";
		
		for(int i = 0; i < conta(); i++) {
			if (!(saida.equals(""))) {
				saida += " | " + resumos[i].getName();
			}else {
				saida += resumos[i].getName();
			}
		}
		
		return "- " + conta() + " resumo(s) cadastrado(s)\n"
				+ "- " +  saida; 
	}
	
	/**
	 * Retorna a quantidade de resumos ja registrados.
	 * 
	 * @return int Quantidade de resumos registrados
	 */
	public int conta() {
		if (contador < numeroDeResumos) {
			return contador;
		}
		return numeroDeResumos;
	}
	
	/**
	 * Retorna um boolean a partir do nome de um resumo, que diz se 
	 * ele ja foi registrado ou nao.
	 * 
	 * @param nome
	 * @return boolean referente a se ja existe um resumo igual no registro
	 */
	public boolean temResumo(String nome) {
		for (int i = 0; i < conta(); i++) {
			if (nome.equals(resumos[i].getName())) {
				return true;
			}
		}
		
		return false;
	}
}
