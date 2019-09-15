package objetosfinal;

import java.util.ArrayList;

public class EstrategiaCompuesta extends Estrategia{
     private Estrategia estrategia1;
     private Estrategia estrategia2;
    
    public EstrategiaCompuesta(Estrategia estrategia1, Estrategia estrategia2){
        this.estrategia1 = estrategia1;
        this.estrategia2 = estrategia2;
    }
    
   private ArrayList<Perfil> similares(ArrayList<Perfil> lista1, ArrayList<Perfil> lista2){
       /*Dado los resultados obtenidos con las dos estrategias se agregan a los grupos 
       aquellas agrupaciones que coincidieron para ambas estrategias*/
       ArrayList<Perfil> resultado = new ArrayList<Perfil>();
       for(int i =0; i< lista1.size(); i++){
           if (lista2.contains(lista1.get(i))){
               resultado.add(lista1.get(i));
           }
       } 
       if (resultado.size() <=1 ){
           resultado = null;
       }
       return resultado;
   }
    
    public ArrayList<ArrayList<Perfil>> generarGrupos(ArrayList<Perfil> perfiles, int cantidad) {
       /*Generacion de grupos a partir del resultado de dos estrategias */
        ArrayList<Perfil> porUsar = new ArrayList<Perfil>();
        ArrayList<Perfil> aux = new ArrayList<Perfil>(); 
        ArrayList<Perfil> aux2= new ArrayList<Perfil>();
        ArrayList<ArrayList<Perfil>> resultado = new ArrayList<ArrayList<Perfil>>();
        porUsar = (ArrayList<Perfil>)perfiles.clone();
        aux2= (ArrayList<Perfil>) perfiles.clone();
        
        int cantGrupos= perfiles.size() / cantidad;//obtengo la cantidad de grupos que se obtendran
        for (int i=0; i<cantGrupos;i++){ //Creo la cantidad de lista por grupos necesito
            resultado.add(i, new ArrayList<Perfil>());
        }
        
        ArrayList<ArrayList<Perfil>> resultadoEstrategia1 = estrategia2.generarGrupos(perfiles, cantidad);//obtengo grupos segun 1 estrategia
        ArrayList<ArrayList<Perfil>> resultadoEstrategia2 = estrategia1.generarGrupos(aux2, cantidad);//pbtengo grupos segun la otra estrategia
        
        for (int i=0 ; i< resultadoEstrategia1.size(); i++){
            for (int j = 0; j< resultadoEstrategia2.size(); j++ ){
                aux = similares(resultadoEstrategia1.get(i), resultadoEstrategia2.get(j)); // se buscan los perfiles que se repiten en un mismo grupo segun distinas estrategias
                if (aux != null){
                    for(Perfil p : aux){// se eliminan los que ya fueron asignados a algun grupo
                        porUsar.remove(p);
                    }
                    int l=0;
                    while (l < cantGrupos){
                    	if ((resultado.get(l).size() == 0 )|| ((resultado.get(l).size() + aux.size())< cantidad)){
                            resultado.get(l).addAll(aux);
                            l = cantGrupos;
                            aux.clear();
                        }
                        else{
                            l++;
                        }
                    }
                }
            }
        }
        while (porUsar.size()> 0){
            int l=0;
            while (l < resultado.size()){  //se agregan los perfiles no coincidentes de forma random  
                if ((resultado.get(l) == null)|| ((resultado.get(l).size() +1)<= cantidad)){ 
                    resultado.get(l).add(porUsar.get(0));
                    porUsar.remove(porUsar.get(0));
                }
                else{
                    l++;
                }
            } 
            if (porUsar.size() ==1){ //por si sobra un perfil y todos los grupos ya tienen asignadas
                resultado.get(0).add(porUsar.get(0));//la cantidad de personas establecidas, en vez de que te queden 4 grupos de 4
                porUsar.remove(porUsar.get(0));   // y uno de uno solo te quedan 3 grupos de 4 y uno de 5
            }
        }
        return resultado;
    }
}
