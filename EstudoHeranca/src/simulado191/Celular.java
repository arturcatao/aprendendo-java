package simulado191;

public class Celular extends Dispositivo {

	private int memoriaGb;
	private int versaoAndroid;
	
	public Celular(String nome, String modelo, int anoDeFabricacao, int mah, String tipoTela, int memoriaGb, int versaoAndroid) {
		super(nome, modelo, anoDeFabricacao, mah, tipoTela);
		this.memoriaGb = memoriaGb;
		this.versaoAndroid = versaoAndroid;
	}
	
	public double getPreco() {
		return 10 * (anoDeFabricacao - 2000) * memoriaGb / 3 * versaoAndroid;
	}

}
