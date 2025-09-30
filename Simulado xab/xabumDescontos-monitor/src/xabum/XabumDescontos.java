package xabum;

import cupom.Cupom;
import cupom.CupomDescontoFixo;
import cupom.CupomDescontoProgressivo;
import cupom.CupomFreteGratis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class XabumDescontos {
    private HashMap<String, Usuario> usuarios;
    private ArrayList<Cupom> cupons;

    public XabumDescontos() {
        this.usuarios = new HashMap<>();
        this.cupons = new ArrayList<>();
    }

    public String criaCupomFreteGratis(double maxDesconto){
        this.cupons.add(new CupomFreteGratis(maxDesconto));
        return "Literalmente qualquer mensagem positiva não especifica no texto\n FUNFOU!";
    }

    public String criaCupomFreteGratis(){
        this.cupons.add(new CupomFreteGratis(0));
        return "Literalmente qualquer mensagem positiva não especifica no texto\n FUNFOU!";
    }

    public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto){
        this.cupons.add(new CupomDescontoFixo(percentualDesconto, maxDesconto));
        return "Literalmente qualquer mensagem positiva não especifica no texto\n FUNFOU!";
    }

    public String criarCupomDescontoProgressivo() {
        this.cupons.add(new CupomDescontoProgressivo());
        return "Literalmente qualquer mensagem positiva não especifica no texto\n FUNFOU!";
    }

    public String adicionaUsuario(String cpf, String nome){
        if (cpf == null || cpf.isBlank() || nome == null || nome.isBlank()){
            throw new IllegalArgumentException("ENTRADA NULA");
        } else {
            this.usuarios.put(cpf, new Usuario(nome, cpf));
            return "Literalmente qualquer mensagem positiva não diz no texto\n FUNFOU!";
        }
    }

    public String addCupomUsuario(String cpf, int indexCupom){
        this.usuarios.get(cpf).adicionaCupom(this.cupons.get(indexCupom - 1));
        return "Literalmente qualquer mensagem positiva não diz no texto\n FUNFOU!";

    }
    // Não ta no texto mas no dia elas adicionaram o cpf se não me engano, que faz bastante sentido
    public String aplicarDescontoCompra(Compra compra, int indexCupomUsuario, String cpf){
        this.usuarios.get(cpf).aplicaCupom(compra, indexCupomUsuario);
        return "Literalmente qualquer mensagem positiva não diz no texto\n FUNFOU!";
    }

    public String[] listarCuponsUsuario(String cpf){
        return this.usuarios.get(cpf).listarCupons();
    }

    public String[] listarUsuariosPorNome(){
        ArrayList<String> usuarios = new ArrayList<>();
        for(Usuario u : this.usuarios.values()){
            usuarios.add(u.toString());
        }
        Collections.sort(usuarios);
        return usuarios.toArray(new String[0]); // Sim, sem esse array inútil de argumento ele não funciona, da pra converter manualmente com um for também
    }

    public String[] listarUsuariosPorCuponsTotais(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        for(Usuario u : this.usuarios.values()){
            usuarios.add(u);
        }
        Collections.sort(usuarios, new UsuarioComparator());
        String[] out = new String[usuarios.size()];

        for(int i = 0; i < usuarios.size(); i++){
            out[i] = usuarios.get(i).toString();
        }
        return out;
    }
}
