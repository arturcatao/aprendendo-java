package simulado191;

public class JogoPortatil extends Dispositivo {

	private int numeroDeJogos;
	private int numeroDeJoysticks;

	public JogoPortatil(String nome, String modelo, int anoDeFabricacao, int mah, String tipoTela, int numeroDeJogos,
			int numeroDeJoysticks) {
		super(nome, modelo, anoDeFabricacao, mah, tipoTela);
		this.numeroDeJogos = numeroDeJogos;
		this.numeroDeJoysticks = numeroDeJoysticks;
	}

	public double getPreco() {
		return 10 * (anoDeFabricacao - 2000) * mah/1000 + (100 * (numeroDeJogos));
	}

}
