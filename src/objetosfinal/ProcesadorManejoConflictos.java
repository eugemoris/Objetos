package objetosfinal;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class ProcesadorManejoConflictos extends ProcesadorEncuesta {

    private int[][] puntajes = new int[30][2];
    private int competencia;
    private int colaboracion;
    private int compromiso;
    private int evasion;
    private int acomodo;

    public ProcesadorManejoConflictos(File datos) throws IOException {
        this.competencia = 0;
        this.colaboracion = 0;
        this.compromiso = 0;
        this.evasion = 0;
        this.acomodo = 0;
        crearMatriz(datos);
        super.setNombre("conflictos");
    }

    @SuppressWarnings("deprecation")
    public void crearMatriz(File datos) throws IOException {
        //Se carga la matriz a partir de un archivo ya que esta siempre será igual
        DataInputStream ds = new DataInputStream(new FileInputStream(datos));
        String dato;
        for (int i = 0; i <= 29; i++) {
            for (int j = 0; j <= 1; j++) {
                dato = ds.readLine();
                puntajes[i][j] = Integer.parseInt(dato);
            }
        }
    }

    public JSONObject getResultado(JSONObject respuestas) {
        JSONObject resultado = new JSONObject();
        
        for (int i = 1; i < 31; i++) { //por cada pregunta
            String key = Integer.toString(i);//la preguntas estan numeradas del 1 al 31
            String valor = (String) respuestas.get("" + i + "");//obtengo repuestas
            int variable;
            int j = i - 1;
            if (valor.startsWith("a.")) { //los resultados pueden ser a o b
                variable = puntajes[j][0];
            } else {
                variable = puntajes[j][1];
            }
            //la matriz posee un integer que nos dice que atributo incrementamos
            switch (variable) {
                case 1:
                    competencia++;
                    break;
                case 2:
                    colaboracion++;
                    break;
                case 3:
                    compromiso++;
                    break;
                case 4:
                    evasion++;
                    break;
                case 5:
                    acomodo++;
                    break;
            }
        }

        //Se agrega al json los resultados
        resultado.put("competencia", competencia);
        resultado.put("colaboracion", colaboracion);
        resultado.put("compromiso", compromiso);
        resultado.put("evasion", evasion);
        resultado.put("acomodo", acomodo);
        competencia = 0;
        colaboracion = 0;
        compromiso = 0;
        evasion = 0;
        acomodo = 0;
        return resultado;
    }

}
