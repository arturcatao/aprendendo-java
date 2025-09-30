package xabum;

import cupom.Cupom;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario implements Comparable{
    private String nome;
    private String cpf;
    private ArrayList<Cupom> cupons;
    private int cuponsNoTotal; // Quantos já teve

    public Usuario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.cupons = new ArrayList<>();
        this.cuponsNoTotal = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cpf, usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.cpf;
    }

    public void adicionaCupom(Cupom cupom) {
        this.cupons.add(cupom);
        this.cuponsNoTotal++; // Assumindo que ela quer quantos já passaram pelo usuário, não a maior quantidade que já ele teve ao mesmo tempo
    }

    public void aplicaCupom(Compra compra, int index){
        this.cupons.get(index - 1).aplicaDesconto(compra); // aplicando por efeito colateral, mas um retorno de uma nova compra faz sentido também
    }

    public String[] listarCupons() {
        String[] out = new String[this.cupons.size()];
        for (int i = 0; i < this.cupons.size(); i++){
            out[i++] = this.cupons.get(i).toString();
        }
        return out;
    }

    @Override
    public int compareTo(Object o) {
        Usuario u = (Usuario) o;
        return this.nome.compareTo(u.getNome());
    }

    public String getNome() {
        return nome;
    }

    public int getCuponsNoTotal() {
        return cuponsNoTotal;
    }
}
