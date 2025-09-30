package cupom;

import xabum.Compra;

public class CupomDescontoProgressivo implements Cupom{

    @Override
    public void aplicaDesconto(Compra compra) {
        double valor = compra.getValorTotal();
        if (valor <= 100){
            compra.setValorFrete(valor * 0.99);
        } else if (valor <= 500){
            compra.setValorFrete(valor * 0.95);
        } else {
            compra.setValorFrete(valor * 0.9);
        }
    }

    public String toString(){
        return "Desconto Progressivo, 1%, 5% ou 10%";
    }
}
