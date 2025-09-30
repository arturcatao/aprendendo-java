package xabum;

import java.util.Comparator;

public class UsuarioComparator implements Comparator<Usuario> {
    @Override
    public int compare(Usuario o1, Usuario o2) {
        return Integer.compare(o2.getCuponsNoTotal(), o1.getCuponsNoTotal());
        // A ordem normal é crescente, então é so inverter e fica decrescente
    }
}
