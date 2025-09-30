package simulado191;

import java.util.Objects;

public class ChaveUnica {

	private String nome;
	private String modelo;

	public ChaveUnica(String nome, String modelo) {
		this.nome = nome;
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveUnica other = (ChaveUnica) obj;
		return Objects.equals(modelo, other.modelo) && Objects.equals(nome, other.nome);
	}

}
