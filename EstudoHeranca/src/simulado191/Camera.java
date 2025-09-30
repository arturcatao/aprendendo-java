package simulado191;

public class Camera extends Dispositivo {

	private int resolucaoMP;
	private String tipoDeSensor;

	public Camera(String nome, String modelo, int anoDeFabricacao, int mah, String tipoTela, int resolucaoMP,
			String tipoDeSensor) {
		super(nome, modelo, anoDeFabricacao, mah, tipoTela);
		this.resolucaoMP = resolucaoMP;
		this.tipoDeSensor = tipoDeSensor;
	}
	
	public double getPreco() {
		
		if (tipoDeSensor.equals("CCD")) {
			return 10 * (anoDeFabricacao - 2000) * resolucaoMP;
		}
		
		else {
			return 10 * (anoDeFabricacao- 2000) * resolucaoMP/2;
		}
	}

}
