package xabumDescontos;

import java.util.HashMap;

import Cupom.Cupom;

import java.util.ArrayList;

public class XabumDescontos {

	private ArrayList<Cupom> cupoms;
	private HashMap<String, User> users;
	
	public XabumDescontos() {
		this.cupoms = new ArrayList();
		this.users = new HashMap<>();
	}
	
	public String criaCupomFreteGratis(double maxDesconto) {
		return null;
	}
	
	public String criaCupomFreteGratis() {
		return null;
	}
	
	public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto) {
		return null;
	}
	
	public String criaCupomDescontoProgressivo() {
		return null;
	}
	
	public String adicionaUsuario(String cpf,String nome) {
		return null;
	}
	
	public String addCupomUsuario(String cpf,int  indexCupom) {
		return null;
	}
	
	public String aplicarDescontoCompra(Compra minhaCompra, int indexCupomUsuario) {
		return null;
	}
	
	public String[] listarCuponsUsuario(String cpf) {
		return null;
	}
			
	public String[] listarUsuariosPorNome() {
		return null;
	}
			
	public String[] listarUsuariosPorCuponsTotais() {
		return null;
	}

}
