package objetosfinal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

/*
    Clase simple que hereda de Criterio, donde se minimiza un atributo multiplicando el valor de ese atributo por cierto 
    factor y luego se ordenan de mayor a menor los perfiles mediante la suma de todas sus caracteristicas
 */
public class CriterioMinimizar extends CriterioSimple {

    public CriterioMinimizar(int factor, String atributo) {
        super(factor, atributo);
    }

    public ArrayList<Perfil> ordenar(ArrayList<Perfil> perfiles, String test) {
       
        ArrayList<Perfil> resultado = perfiles;
        
        for (Perfil p : resultado) {
            Long valor = (long) (p.getAtributo(atributo, test) / Math.abs(super.factor));//divide el valor del atributo del test por el factor - disminuyendo su valor
            p.setAtributo(atributo, test, valor);//modifica el valor del atributo
            Set<String> claves = p.getClaves(test);
            Long atributoOrdenamiento = (long) 0;
            for (String s : claves) {
                if (s != "Test") {
                    atributoOrdenamiento += p.getAtributo(s, test);//suma los valores de atributos
                }
            }
            p.setFactorOrdenamiento(atributoOrdenamiento);
        }

        ComparadorPerfil c = new ComparadorPerfil();
        resultado.sort((Comparator<? super Perfil>) c);//ordena los perfiles 
        return resultado;
    }
}
