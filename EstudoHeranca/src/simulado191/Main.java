package simulado191;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // Cadastrando dispositivos
        sistema.cadastrarCelular("Samsung", "Galaxy S21", 2021, 4000, "AMOLED", 128, 11);
        sistema.cadastrarCamera("Canon", "EOS R5", 2020, 2000, "LCD", 45, "CMOS");
        sistema.cadastrarJogo("Nintendo", "Switch", 2022, 3000, "LCD", 100, 2);

        // Mostrando dispositivos do mais novo para o mais antigo
        ArrayList<Dispositivo> lista = sistema.mostrarDisp();

        System.out.println("Dispositivos do mais novo para o mais antigo:");
        for (Dispositivo d : lista) {
            System.out.println(d);
        }
    }
}
