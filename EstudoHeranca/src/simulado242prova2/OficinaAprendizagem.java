package simulado242prova2;

public class OficinaAprendizagem extends Evento {

	private int duracao;
	private boolean certificacao;

	public OficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes, int duracao,
			boolean certificacao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		this.certificacao = certificacao;
		super.pontos = duracao + (certificacao ? 10 : 0);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
