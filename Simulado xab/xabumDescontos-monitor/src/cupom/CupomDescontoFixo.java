package cupom;

import xabum.Compra;

import static java.lang.Math.max;

public class CupomDescontoFixo implements Cupom{
    private double maxDesconto;
    private double percentual;

    public CupomDescontoFixo(double maxDesconto, double percentual) {
        this.maxDesconto = maxDesconto;
        this.percentual = percentual;
    }

    @Override
    public void aplicaDesconto(Compra compra) {
        double valor = compra.getValorTotal();
        compra.setValorTotal(max(valor * this.percentual, valor - this.maxDesconto));
    }

    public String toString(){
        return "Desconto Fixo de " + this.percentual + "%, até no máximo R$" + this.maxDesconto;
    }
}
