package simulado191;

abstract class Dispositivo implements Comparable<Dispositivo>{

	protected String nome;
	protected String modelo;
	protected int anoDeFabricacao;
	protected int mah;
	protected String tipoTela;

	public Dispositivo(String nome, String modelo, int anoDeFabricacao, int mah, String tipoTela) {
		this.nome = nome;
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.mah = mah;
		this.tipoTela = tipoTela;
	}
	
	abstract double getPreco();
	
	@Override
	public int compareTo(Dispositivo outro) {
		return Integer.compare(outro.anoDeFabricacao, anoDeFabricacao);
	}
	
	@Override
	public String toString() {
		return anoDeFabricacao + "";
	}

}
