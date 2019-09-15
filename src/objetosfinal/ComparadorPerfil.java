package objetosfinal;
import objetosfinal.Perfil;
import java.util.Comparator;

public class ComparadorPerfil implements Comparator<Perfil>{
//pertime comparar la clase Perfil
    public int compare(Perfil p1, Perfil p2) {
        if ((Long) p1.getFactorOrdenamiento() == (Long) p2.getFactorOrdenamiento()) {
            return 0;
        }
        if ((Long) p1.getFactorOrdenamiento() > (Long) p2.getFactorOrdenamiento()) {
            return -1;
        }
        return 1;

    }

}
