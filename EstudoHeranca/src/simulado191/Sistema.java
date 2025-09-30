package simulado191;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Sistema {

	private HashMap<ChaveUnica, Dispositivo> dispositivos;

	public Sistema() {
		this.dispositivos = new HashMap<>();
	}

	public void cadastrarCelular(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int memoriaGb,
			int versaoAndroid) {
		validaNome(nome);
		validaAno(ano);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		Celular c = new Celular(nome, modelo, ano, amperagem, tipoDeTela, memoriaGb, versaoAndroid);
		dispositivos.put(chave, c);

	}

	public void cadastrarJogo(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int numeroDeJogos,
			int numeroDeJoysticks) {
		validaNome(nome);
		validaAno(ano);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		JogoPortatil j = new JogoPortatil(nome, modelo, ano, amperagem, tipoDeTela, numeroDeJogos, numeroDeJogos);
		dispositivos.put(chave, j);

	}

	public void cadastrarCamera(String nome, String modelo, int ano, int amperagem, String tipoDeTela, int resolucaoMP,
			String tipoDeSensor) {
		validaNome(nome);
		validaAno(ano);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		Camera c = new Camera(nome, modelo, ano, amperagem, tipoDeTela, resolucaoMP, tipoDeSensor);
		dispositivos.put(chave, c);

	}

	public String exibirDispositivo(String nome, String modelo) {

		validaDispositivo(nome, modelo);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		return dispositivos.get(chave).toString();

	}

	public double calcularPreco(String nome, String modelo) {
		validaDispositivo(nome, modelo);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		return dispositivos.get(chave).getPreco();

	}

	public ArrayList<Dispositivo> mostrarDisp() {
		ArrayList<Dispositivo> listaDisp = new ArrayList<>();

		for (ChaveUnica chave : dispositivos.keySet()) {
			listaDisp.add(dispositivos.get(chave));
		}
		Collections.sort(listaDisp);

		return listaDisp;
	}
	
	private void validaNome(String nome) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Nome Invalido");
	}

	private void validaDispositivo(String nome, String modelo) {
		validaNome(nome);

		ChaveUnica chave = new ChaveUnica(nome, modelo);

		if (!dispositivos.containsKey(chave))
			throw new IllegalArgumentException("Modelo inexistente");

	}

	private void validaAno(int ano) {
		if (ano < 2000)
			throw new IllegalArgumentException("Ano Invalido");
	}

}
