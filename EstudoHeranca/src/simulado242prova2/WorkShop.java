package simulado242prova2;

public class WorkShop extends Evento {
	
	private int duracao;

	public WorkShop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		super(titulo, descricao, data, maxParticipantes);
		this.duracao = duracao;
		super.pontos = duracao;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
