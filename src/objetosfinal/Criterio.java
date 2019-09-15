/*
    clase abstracta de atributo
 */
package objetosfinal;

import java.util.ArrayList;
import java.util.Set;

public abstract class Criterio {

    public abstract ArrayList<Perfil> ordenar(ArrayList<Perfil> perfiles, String test);

    public void sumar(String test, Perfil perfil) {
        //suma los resultados de todos los atributos del perfil en un test dado
        //metodo usado por los hijos
        Set<String> claves = perfil.getClaves(test);//obtengo las claves del test
        int atributoOrdenamiento = 0;
        for (String s : claves) {
            atributoOrdenamiento += perfil.getAtributo(test, s);
        }
        perfil.setFactorOrdenamiento(atributoOrdenamiento);
    }
}
