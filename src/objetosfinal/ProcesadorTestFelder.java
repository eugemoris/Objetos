package objetosfinal;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import org.json.simple.JSONObject;

public class ProcesadorTestFelder extends ProcesadorEncuesta {

    private int[] dimensiones = new int[4];
    private HashMap<String, Pair> puntuacion = new HashMap<String, Pair>();

    private void leerArchivoDatos() throws FileNotFoundException, IOException {
        //Se carga la hash a partir de un archivo ya que siempre va a se igual
        DataInputStream dato = new DataInputStream(new FileInputStream("./datosFelder.txt"));
        String tmp;
        while ((tmp = dato.readLine()) != null) {
            String[] temporal = tmp.split(";");//carga todos los elementos de la linea separados por ; en el arreglo
            Pair par = new Pair(temporal[1], temporal[2]);
            puntuacion.put(temporal[0], par); //como clave el primer elemento del arreglo
        }
    }

    public ProcesadorTestFelder() throws FileNotFoundException, IOException {
        for (int i = 0; i < 4; i++) {
            dimensiones[i] = 0;
        }
        leerArchivoDatos();
        super.nombre = "felder";
    }

    public JSONObject getResultado(JSONObject respuesta) {
        for (int i = 0; i < 4; i++) {
            dimensiones[i] = 0;
        }
        JSONObject obj = new JSONObject();
        Set<String> claves = respuesta.keySet();//obtego las preguntas o claves del test
        Set<String> claveP = puntuacion.keySet();//obtengo las claver del hash cargado por archivo
        for (String s : claves) {
            Object res = respuesta.get(s);//obtengo respuesta 
            Pair par = puntuacion.get(res);//obtengo el pair a partir de la rspuesta obtenida
            if (par != null) {
                Integer numero = Integer.parseInt(par.getNombre().toString().trim());// chequear que reseteo las dimensiones en cada json
                dimensiones[(numero % 4)] = dimensiones[(numero % 4)] + Integer.parseInt(par.getValor().toString().trim());
            }//sumo a la dimencion correspondiente el valor que corresponde
        }
        for (int i = 0; i < 4; i++) {
            obj.put(getAtributo(i), Math.abs(dimensiones[i]));//cargo resultados en un json
        }
        return obj;

    }

    private String getAtributo(int i) {
        //obtengo el numero de atrubuto que corresponde a cada dimension
        if (i == 0) {
            if (dimensiones[i] < 0) {
                return "global";
            } else {
                return "secuencial";
            }
        } else if (i == 1) {
            if (dimensiones[i] < 0) {
                return "reflexivo";
            } else {
                return "activo";
            }
        } else if (i == 2) {
            if (dimensiones[i] < 0) {
                return "intuitivo";
            } else {
                return "sensorial";
            }
        } else if (dimensiones[i] < 0) {
            return "verbal";
        } else {
            return "visual";
        }
    }

}
