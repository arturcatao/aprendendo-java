package simulado242prova2;

import java.util.ArrayList;
import java.util.HashMap;

public class AgendaFacil {

	private HashMap<String, Estudante> estudantes;
	private ArrayList<Evento> eventos;

	public AgendaFacil() {
		this.estudantes = new HashMap<>();
		this.eventos = new ArrayList<>();
	}

	public boolean cadastrarEstudante(String nome, String email) {

		verificaEmailCadastrado(email);

		Estudante estudante = new Estudante(nome, email);
		estudantes.put(email, estudante);

		return true;

	}

	public String exibirEstudante(String email) {

		validarEmailNaoCadastrado(email);

		return estudantes.get(email).toString();

	}

	public String[] listarEstudantes() {
		return null; // calme
	}

	public int cadastrarPalestra(String titulo, String descricao, String data, int maxParticipantes) {
		Evento palestra = new Palestra(titulo, descricao, data, maxParticipantes);

		eventos.add(palestra);

		return eventos.size() + 1;
	}

	public int cadastrarWorkshop(String titulo, String descricao, String data, int maxParticipantes, int duracao) {
		Evento workshop = new WorkShop(titulo, descricao, data, maxParticipantes, duracao);

		eventos.add(workshop);

		return eventos.size() + 1;
	}

	public int cadastrarOficinaAprendizagem(String titulo, String descricao, String data, int maxParticipantes,
			int duracao, boolean certificacao) {
		Evento Oficina = new OficinaAprendizagem(titulo, descricao, data, maxParticipantes, duracao, certificacao);

		eventos.add(Oficina);

		return eventos.size() + 1;
	}

	public boolean inscreverParticipanteEmEvento(String emailParticipante, int idEvento) {

		Evento evento = eventos.get(idEvento);
		Estudante estudante = estudantes.get(emailParticipante);

		if (evento.inscreverParticipante(estudante)) {
			estudante.addEvento(evento);
			return true;
		}

		return false;
	}

	public String exibirDetalhesEvento(int idEvento) {
		Evento evento = eventos.get(idEvento);

		return evento.toString();
	}

	private void verificaEmailCadastrado(String email) {
		if (estudantes.containsKey(email))
			throw new IllegalArgumentException("Email ja cadastrado");
	}

	private void validarEmailNaoCadastrado(String email) {
		if (estudantes.containsKey(email))
			throw new IllegalArgumentException("Email não cadastrado");
	}

}
