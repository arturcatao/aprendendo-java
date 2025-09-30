package simulado242prova2;

import java.util.HashSet;

public class Estudante implements Comparable<Estudante> {

	private String nome;
	private String email;
	private HashSet<Evento> eventos;
	private int pontos;

	public Estudante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontos = 0;
	}
	
	   @Override
	    public int compareTo(Estudante outro) {
	        return Integer.compare(outro.pontos, this.pontos); // Decrescente
	        // return Integer.compare(this.pontos, outro.pontos); // Crescente
	    }
	
	@Override
	public String toString() {
		return nome + email + pontos;
	}
	
	public void addEvento(Evento e) {
		eventos.add(e);
		atualizaPontos(e);
	}
	
	private void atualizaPontos(Evento e) {
		pontos += e.getPontos();
	}
	
	public String getEmail() {
		return email;
	}

}
