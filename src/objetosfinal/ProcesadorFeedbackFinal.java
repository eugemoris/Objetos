/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosfinal;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;

/**
 *
 * @author eugem
 */
public class ProcesadorFeedbackFinal extends ProcesadorEncuesta{
    private AdministradorPerfil admPerfil;
        public ProcesadorFeedbackFinal(){
            admPerfil= new AdministradorPerfil();
        }
       
    	public JSONObject getResultado(JSONObject respuestas) {
                try {
                            setAtributosFeedback(respuestas, "./FeedbackFinal.txt");
                            setFeedback(respuestas, "./satisfaccion.txt", "satisfaccion");
                            setFeedback(respuestas, "./Efectividad.txt", "efectividad");
                        
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
        
        public void setAtributosFeedback(JSONObject respuestas, String path) throws IOException{
           JSONObject resultado = new JSONObject();
            DataInputStream dato = new DataInputStream(new FileInputStream(path));
            String tmp;
            while ((tmp = dato.readLine()) != null) {
                resultado.put(tmp, respuestas.get(tmp));
            }
            admPerfil.agregarEncuesta((String)respuestas.get("Tù Nombre")+ " " + (String)respuestas.get("Tù Apellido"), resultado, "feedbackFinal");
        }
        
        public Long promedio(ArrayList<Long> lista){
            Long cantidad = (long) lista.size();
            Long suma = (long) 0;
            for(Long i:lista){
                suma += i;
            }
            return suma/cantidad;
        }
        
        public void setFeedback(JSONObject respuestas, String path, String atributo) throws IOException{
            DataInputStream dato = new DataInputStream(new FileInputStream(path));
            String tmp;
            while ((tmp = dato.readLine()) != null) {
                String[] temporal = tmp.split(";");
                if((respuestas.get(temporal[0])!= "")&& (respuestas.get(temporal[0])!= "BLANK") && ((respuestas.get(temporal[0])!= null))){
                    String tp = (String) respuestas.get(temporal[0]);
                    String carpeta = admPerfil.getPath(tp.substring(3, tp.length()),(String) respuestas.get("Tù Nombre")+ " "+ (String) respuestas.get("Tù Apellido"));
                    // hacer metodo que se fija si existe la carpeta del tp de esa persona
                    if (carpeta != null){
                        JSONObject resultado=  admPerfil.getEncuestaGrupal(carpeta, "feedback");
                        if (resultado == null){
                            resultado = new JSONObject();
                            ArrayList<Long> lista = new ArrayList<Long>();
                            int valor=0;
                            lista.add(Long.parseLong(temporal[1]));
                            resultado.put("lista" + atributo, lista);
                            resultado.put(atributo, valor);
                        }
                        else { 
                            ArrayList<Long> aux = new ArrayList<Long>();
                            if (resultado.containsKey("lista" + atributo)){
                                aux = (ArrayList<Long>) resultado.get("lista" + atributo);
                            }
                            aux.add(Long.parseLong(temporal[1]));
                            resultado.put("lista"+ atributo, aux);
                            resultado.put(atributo, promedio(aux));
                        }
                        admPerfil.agregarEncuestaGrupal(carpeta, resultado, "feedback");
                        resultado.clear();
                    } 
                }
            }
        }
    
}
