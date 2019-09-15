package objetosfinal;

import org.json.simple.*;

public abstract class ProcesadorEncuesta {

    protected String nombre;//Nombre de la encuesta que procesan 

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract JSONObject getResultado(JSONObject respuestas);//metodo abstracto mas importante

}
