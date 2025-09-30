package mrbet;

/**
 * Sistema responsavel por exercer a função de controller no MrBet
 * 
 * @author Artur Catão
 */

import java.security.cert.CertPathValidatorResult;
import java.util.*;

public class MrBetSistema {

	/*
	 * HashMap para guardar os times no sistema a partir de seu codigo
	 */
	private HashMap<String, Time> times;

	/*
	 * HashMap que guarda os campeonatos no sistema a partir de seu nome
	 */
	private HashMap<String, Campeonato> campeonatos;

	/*
	 * ArrayList que guarda as apostas feitas mantendo a ordem de criação
	 */
	private ArrayList<Aposta> apostas;

	/*
	 * Construtor da classe
	 */
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}

	/*
	 * Metodo que a partir do nome e da qtd de participantes cria e armazena o
	 * campeonato no sistema
	 * 
	 * @return uma representação textual do status da operação
	 */
	public String incluirCampeonato(String nome, int participantes) {

		validaEntrada(nome);

		if (campeonatos.containsKey(nome.toLowerCase())) {
			return "CAMPEONATO JA EXISTE!";
		}

		Campeonato c = new Campeonato(nome, participantes);
		campeonatos.put(nome.toLowerCase(), c);

		return "CAMPEONATO ADICIONADO!";
	}

	/*
	 * Metodo que a partir docodigo, nome e da qtd do mascote cria e armazena um
	 * time no sistema
	 * 
	 * @return uma representação textual do status da operação
	 */
	public String incluirTime(String codigo, String nome, String mascote) {

		validaEntrada(codigo);
		validaEntrada(nome);
		validaEntrada(mascote);

		if (times.containsKey(codigo)) {
			return "TIME JA EXISTE!";
		}

		Time time = new Time(codigo, nome, mascote);
		times.put(codigo, time);

		return "INCLUSAO REALIZADA!";
	}

	/*
	 * Metodo que a partir do codigo, resgata a representação textual de um time no
	 * sistema
	 * 
	 * @return uma String que pode ou representar o time ou um possivel erro
	 */
	public String recuperarTime(String codigo) {

		validaEntrada(codigo);

		if (!times.containsKey(codigo)) {
			return "TIME NAO EXISTE!";
		}

		return times.get(codigo).toString();
	}

	/*
	 * Metodo que a partir do codigo do time e do nome do campeonato adiciona o time
	 * em um campeonato
	 * 
	 * @return Uma string que representa o status da operação
	 */
	public String incluirTimeCampeonato(String codTime, String nomeCamp) {

		validaEntrada(codTime);
		validaEntrada(nomeCamp);

		Time t = getTime(codTime);
		Campeonato c = getCamp(nomeCamp.toLowerCase());

		t.addCampeonato(c);
		return c.incluirTime(t);
	}

	/*
	 * Metodo que verifica se um time esta em um campeonato a partir do codigo do
	 * time e do nome do campeoato
	 * 
	 * @return uma String que diz se o time faz ou nao parte do campeonato ou
	 * possiveis erros
	 */
	public String verificaTimeCampeonato(String codTime, String nomeCamp) {

		validaEntrada(codTime);
		validaEntrada(nomeCamp);

		Time t = getTime(codTime);
		Campeonato c = getCamp(nomeCamp);

		return c.verificarTime(t);

	}

	/*
	 * Metodo que busca os campeonatos que um time participa a partir de seu codigo
	 * no sistema
	 * 
	 * @return os campeonatos que o time participa e possiveis erros
	 */
	public String campsParticipando(String codigo) {

		validaEntrada(codigo);

		return getTime(codigo).campsParticipando();

	}

	/*
	 * Metodo que realiza a aposta no sistema a partir do codigo do time, nome do
	 * campeonato, colocação apostada e valor
	 * 
	 * @return se a aposta foi ou nao registrada e possiveis erros
	 */
	public String tentarSorte(String codTime, String nomeCamp, int colocacao, double valor) {

		validaEntrada(codTime);
		validaEntrada(nomeCamp);

		if (colocacao > getCamp(nomeCamp).getMaxParticipantes() || colocacao < 1) {
			return "APOSTA NAO REGISTRADA!";
		}

		else if (getCamp(nomeCamp).verificarTime(getTime(codTime)).equals("O TIME NAO ESTA NO CAMPEONATO!")) {
			return getCamp(nomeCamp).verificarTime(getTime(codTime));
		}

		Time t = getTime(codTime);
		Campeonato c = getCamp(nomeCamp);

		Aposta a = new Aposta(t, c, colocacao, valor);

		apostas.add(a);

		return "APOSTA REGISTRADA!";

	}

	/*
	 * Metodo que busca as apostas do sistema
	 * 
	 * @return a representação textual (String) das apostas na ordem de criação
	 */
	public String statusAposta() {

		if (apostas.size() == 0) {
			return "NAO TEM APOSTAS REGISTRADAS!";
		}

		String saida = "Apostas:";

		for (int i = 0; i < apostas.size(); i++) {
			saida += " | " + (i + 1) + ". " + apostas.get(i).toString();
		}

		return saida;
	}

	/*
	 * Metodo valida a entrada dada pelo main
	 */
	private void validaEntrada(String codigo) {
		if (codigo == null || codigo.trim().equals(""))
			throw new IllegalArgumentException("Nao pode adicionar o vazio");

	}

	/*
	 * Metodo busca e retorna um time a partir de seu codigo
	 * 
	 * @return Time se o time existir
	 */
	private Time getTime(String cod) {
		if (!times.containsKey(cod)) {
			throw new IllegalArgumentException("O TIME NAO EXISTE!");
		}

		return times.get(cod);
	}

	/*
	 * Metodo busca e retorna um campeonato a partir de seu nome
	 * 
	 * @return Campeonato se o campeonato existir
	 */
	private Campeonato getCamp(String nome) {
		if (!campeonatos.containsKey(nome.toLowerCase())) {
			throw new IllegalArgumentException("CAMPEONATO NAO EXISTE!");
		}

		return campeonatos.get(nome.toLowerCase());
	}

}
