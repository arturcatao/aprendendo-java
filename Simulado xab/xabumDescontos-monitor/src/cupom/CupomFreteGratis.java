package cupom;

import xabum.Compra;

public class CupomFreteGratis implements Cupom{
    private double maxDesconto;

    public CupomFreteGratis(double maxDesconto) {
        this.maxDesconto = maxDesconto;
    }

    @Override
    public void aplicaDesconto(Compra compra) {
        if (this.maxDesconto == 0){
            compra.setValorFrete(0);
        } else {
            compra.setValorFrete(compra.getValorFrete() - this.maxDesconto);
        }
    }

    /**
     * Insano essa representação mas eu não vou argumentar com o texto
     * @return a representação textual insana
     */
    @Override
    public String toString(){
        return "1. FreteGrátis \n2. Desconto de até" + this.maxDesconto + "no Frete";
    }
}
