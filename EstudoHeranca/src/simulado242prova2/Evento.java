package simulado242prova2;

import java.util.HashMap;

public abstract class Evento {

	protected String titulo;
	protected String descricao;
	protected String data;
	protected int maxParticipantes;
	protected HashMap<String, Estudante> participantes;
	protected int pontos;

	public Evento(String titulo, String descricao, String data, int maxParticipantes) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.maxParticipantes = maxParticipantes;
		this.participantes = new HashMap<>();
	}

	@Override
	public abstract String toString();
	
	public int getPontos() {
		return pontos;
	}

	public boolean inscreverParticipante(Estudante e) {

		if (participantes.containsKey(e.getEmail()))
			return false;

		participantes.put(e.getEmail(), e);
		return true;

	}

}
