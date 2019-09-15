/*
    Clase simple que hereda de Criterio, donde se maximiza un atributo multiplicando el valor de ese atributo por cierto 
    factor y luego se ordenan de mayor a menor los perfiles mediante la suma de todas sus caracteristicas
 */
package objetosfinal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class CriterioMaximizar extends CriterioSimple {

    public CriterioMaximizar() {
    }

    public CriterioMaximizar(int factor, String atributo) {

        super(factor, atributo);
        
    }

    @Override
    public ArrayList<Perfil> ordenar(ArrayList<Perfil> perfiles, String test) {
        
        ArrayList<Perfil> resultado = perfiles;
        
        for (Perfil p : resultado) {
            Long valor = (Long) (p.getAtributo(atributo, test) * Math.abs(super.factor));//Se multiplica el resultado del atributo seleccionado por el factor indicado- aumentando su valos
            p.setAtributo(atributo, test, valor);//se modifica el valor atributo
            Set<String> claves = p.getClaves(test);
            Long atributoOrdenamiento = (long) 0;
            for (String s : claves) {
                if (s != "Test") {
                    atributoOrdenamiento += p.getAtributo(s, test);//se suman los resultados del test del perfil
                }
            }
            p.setFactorOrdenamiento(atributoOrdenamiento);
        }
        
        ComparadorPerfil c = new ComparadorPerfil();
        resultado.sort((Comparator<? super Perfil>) c);//ordena los perfiles segun el criterio del comparador
        return resultado;
    }
}
