package objetosfinal;

import java.util.ArrayList;

/*
   Posee una lista de criterios por los que va a ordenar la lista de Perfiles a devolver
 */
public class CriterioCompuesto extends Criterio{

    ArrayList<Criterio> criterios;
    
    public CriterioCompuesto(){}
    
    public CriterioCompuesto(ArrayList<Criterio>c){
    	this.criterios=c;
    }
    
    public ArrayList<Perfil> ordenar(ArrayList<Perfil> perfiles, String test) {
        /*Dado un conjunto de perfiles y criterios se ordenan a partir del metodo ordenar de los 
        criterios simples*/
        ArrayList<Perfil> resultado= perfiles;
        for(Criterio c: criterios){
            resultado = c.ordenar(resultado, test);
        }
        return resultado;
    }


}
