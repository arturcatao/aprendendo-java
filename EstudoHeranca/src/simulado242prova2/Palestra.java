package simulado242prova2;

public class Palestra extends Evento {

	public Palestra(String titulo, String descricao, String data, int maxParticipantes) {
		super(titulo, descricao, data, maxParticipantes);
		super.pontos = 2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
