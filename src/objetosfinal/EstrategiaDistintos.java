package objetosfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import org.json.simple.JSONObject;

/*Esta estrategia es compartida con los test de Belbin y los de conflictos (Kilman). Su manera de agrupar es igual.
 * En el constructor se declara que test es por parametro.*/
public class EstrategiaDistintos extends EstrategiaSimple {

    private String test;

    public EstrategiaDistintos(Criterio c, String test,ArrayList<String> list) {
        super();
        super.criterio = c;
        super.atributos= list;
        this.test = test;
    }

    @Override
    public ArrayList<ArrayList<Perfil>> generarGrupos(ArrayList<Perfil> seleccionados, int cantidad) {
        
        ArrayList<Perfil> perfiles = super.criterio.ordenar(seleccionados, test);
        ArrayList<ArrayList<Perfil>> grupos = new ArrayList<ArrayList<Perfil>>();
        ArrayList<Pair> atributos;
        int index;
        
        int cantGrupos = perfiles.size() / cantidad;//obtengo la cantidad de grupos que se obtendran
        for (int i = 0; i < cantGrupos; i++) {//Creo la cantidad de lista por grupos necesito
            grupos.add(i, new ArrayList<Perfil>());
        }
        
        boolean caractUsadas[][] = new boolean[cantGrupos][(super.atributos).size()];//marcará los atributos que ya fueron usados en cada grupo
        for (int fila = 0; fila < cantGrupos; fila++) {
            for (int col = 0; col < (super.atributos).size(); col++) {
                caractUsadas[fila][col] = false;
            }
        }
        
        while (perfiles.size() > 0) {
            for (int perfil = 0; perfil < cantGrupos; perfil++) {
                index = 0;
                if (perfiles.size() > 0) {
                    atributos = createList(perfiles.get(0));//lista ordenadamente los atributos del perfil
                    String caract = getAtributo(atributos, index);//obtiene el primer atributo
                    while ((index < super.atributos.size()) && (caractUsadas[perfil][super.atributos.indexOf(caract)] == true) && (index < (perfiles.get(0).getClaves(test).size())-1)) {
                        caract = getAtributo(atributos, index);
                        index++;
                        //cambia de atributo del perfin mientras no se que sin atributos o no se encuentre ese atributo en el grupo
                    }
                    caractUsadas[perfil][super.atributos.indexOf(caract)] = true;
                    grupos.get(perfil).add(perfiles.get(0));
                    perfiles.remove(0);
                    atributos.clear();
                }
            }
            int grupo = 0;
            int aux = perfiles.size() - 1;
            for (int perfil = perfiles.size() - 1; (perfil >= 0 && perfil > aux - cantGrupos); perfil--) {
                index = 0;
                atributos = createList(perfiles.get(perfiles.size() - 1));
                String caract;
                if (perfiles.size() > 0) {
                    caract = getAtributo(atributos, index);
                    while ((index < super.atributos.size()) && (caractUsadas[grupo][super.atributos.indexOf(caract)] == true) && (index < (perfiles.get(0).getClaves(test).size())-1)) {
                        caract = getAtributo(atributos, index);
                        index++;
                    }
                    caractUsadas[grupo][super.atributos.indexOf(caract)] = true;
                    grupos.get(grupo).add(perfiles.get(perfiles.size() - 1));
                    perfiles.remove(perfiles.size() - 1);
                    atributos.clear();
                }
                grupo++;
            }
        }
        return grupos;

    }
    //Este metodo arma una lista ordenada de los roles. Ya que la estructura de JSON no permite su almacenamiento ordenado
    public ArrayList<Pair> createList(Perfil p) {
        JSONObject test = p.getTest(this.test);
        Set<String> keys = test.keySet();
        ArrayList<Pair> list = new ArrayList<Pair>();
        for (String s : keys) {
            if (! s.equals("Test")) {
                Long valor = (Long) test.get(s);

                list.add(new Pair((String) s, valor));
            }
        }
        ComparadorPair cp = new ComparadorPair();
        list.sort(cp);
        return list;
    }

    public String getAtributo(ArrayList<Pair> list, int index) {
        return (String) list.get(index).getNombre();
    }

}
