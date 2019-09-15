package objetosfinal;

import java.util.ArrayList;

public abstract class Estrategia {
    //Clase abstracta la cual da distintas estrategias para agrupar a los perfiles en grupos
    public abstract ArrayList<ArrayList<Perfil>> generarGrupos(ArrayList<Perfil> perfiles, int cantidad);

}
