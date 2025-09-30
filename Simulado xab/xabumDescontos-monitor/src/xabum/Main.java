package xabum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        XabumDescontos x = new XabumDescontos();
        x.adicionaUsuario("495.068.423-23", "Theo");
        x.adicionaUsuario("12", "Lheo");
        x.adicionaUsuario("oi", "Gheo");
        System.out.println(Arrays.toString(x.listarUsuariosPorNome()));

        x.criaCupomFreteGratis();
        x.criaCupomFreteGratis();
        x.criaCupomFreteGratis();
        x.criaCupomFreteGratis();

        x.addCupomUsuario("12", 1);
        x.addCupomUsuario("12", 2);
        x.addCupomUsuario("12", 3);
        x.addCupomUsuario("oi", 4);

        System.out.println(Arrays.toString(x.listarUsuariosPorCuponsTotais()));
    }
}
