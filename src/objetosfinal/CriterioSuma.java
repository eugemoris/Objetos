/*
    Ordena en orden decreciente los Perfiles de acuerdo a la suma de sus caracteristicas
 */
package objetosfinal;

import java.util.ArrayList;
import java.util.Comparator;
import objetosfinal.ComparadorPerfil;
import java.util.Set;


public class CriterioSuma extends CriterioSimple {

    CriterioSuma(int factor, String atributo) {
        super(factor, atributo);
    }

    public CriterioSuma() {
    }

    @Override
    public ArrayList<Perfil> ordenar(ArrayList<Perfil> perfiles, String test) {
        
        ArrayList<Perfil> resultado = perfiles;
        
        for (Perfil p : resultado) {
            Set<String> claves = p.getClaves(test);
            Long atributoOrdenamiento = (long) 0;
            for (String s : claves) {
                if (s != "Test") {
                    atributoOrdenamiento += p.getAtributo(s, test);//Suma el valor de los atributos
                }
            }
            p.setFactorOrdenamiento(atributoOrdenamiento);
        }
        
        ComparadorPerfil com = new ComparadorPerfil();
        resultado.sort((Comparator<Perfil>) com);//ordena los perfiles
        return resultado;

    }
}
