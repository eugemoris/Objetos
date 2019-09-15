package objetosfinal;

import java.util.ArrayList;
import java.util.Arrays;

public class EstrategiaParecidos extends EstrategiaSimple {

    public EstrategiaParecidos(Criterio c, ArrayList<String> list) {
        super(c, list);
    }

    private void extremo(Perfil p) {
        String[] complementarios = {"reflexivo", "verbal", "intuitivo", "global"};
        for (String s : complementarios) {
            if (p.getAtributo(s, "felder") != 0) {
                p.setAtributo(s, "felder", p.getAtributo(s, "felder") * (-1));
            }
        }
    }

    public ArrayList<ArrayList<Perfil>> generarGrupos(ArrayList<Perfil> perfiles, int cantidad) {
       //Agrupo a los Perfiles por tener atributos similares
        ArrayList<ArrayList<Perfil>> grupos = new ArrayList<ArrayList<Perfil>>();
        int cantGrupos = perfiles.size() / cantidad;//obtengo la cantidad de grupos que se obtendran
        for (int i = 0; i < cantGrupos; i++) {
            grupos.add(i, new ArrayList<Perfil>());
        }
        for (Perfil p : perfiles) {
            extremo(p);
        }
        ArrayList<Perfil> ordenada = criterio.ordenar(perfiles, "felder");//ordeno los perfiles segun el criterio
        while (ordenada.size() > 0) {
            for (int i = 0; i < cantGrupos; i++) {
                for (int j = 0; j < cantidad; j++) {
                    if (ordenada.size() > 0) {
                        grupos.get(i).add(ordenada.get(0));//agrego a cada grupo
                        ordenada.remove(perfiles.get(0));
                    }
                }
            }
        }
        return grupos;
    }
}
