package xabumDescontos;

public class Compra {

	private int codigo;
	private String usuarioCpf;
	private double valorTotal;
	private double valorFrete;

	public Compra(int codigo, String usuarioCpf, double valorTotal, double valorFrete) {
		this.codigo = codigo;
		this.usuarioCpf = usuarioCpf;
		this.valorTotal = valorTotal;
		this.valorFrete = valorFrete;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete > 0 ? valorFrete : 0; // é maior que 0? se não vai ser 0, pra não ficar negativo.
	}

}
