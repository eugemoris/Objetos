package objetosfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AdministradorPerfil {

    public boolean existePerfil(String nombre) {
        //Nos dice si el perfil existe
        File perfil = new File("./Perfiles/" + nombre);
        if (perfil.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarEncuesta(String nombre, JSONObject resultado, String encuesta) throws IOException {
        //Daso un resultado resultado y un nombre de perfil se almacena el resultado en la carpeta correspondiente
        //al perfil. en caso de no existir se crea
        String dCarpeta = "./Perfiles/" + nombre;
        String dArchivo = "/" + encuesta + ".json";
        File file = new File(dCarpeta + dArchivo);
        File usuario = new File(dCarpeta);
        if (!file.exists()) {
            usuario.mkdirs();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(resultado.toJSONString());
            fw.flush();
            fw.close();
        } else {
            FileWriter fw = new FileWriter(file);
            fw.write(resultado.toJSONString());
            fw.flush();
            fw.close();
        }
    }

    public JSONObject getEncuesta(String nombre, String encuesta) {
        //Obtiene el resultado de una encuesta dada de un perfil especificado 
        JSONObject resultado = new JSONObject();
        String direccion = "./Perfiles/" + nombre + "/" + encuesta + ".json";
        File file = new File(direccion);
        if (file.exists()) {
            JSONParser parser = new JSONParser();
            Object json;
            try {
                json = parser.parse(new FileReader(file));
                resultado = (JSONObject) json;
                resultado.put("Test", encuesta);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return resultado;
        } else {
            return null;
        }
    }

    public static JSONObject getEncuestaGrupal(String nombre, String encuesta) {
        //Obtiene la encuesta que se almacena en la carpeta de PerfilesGrupales dado un nombre y encuesta
        JSONObject resultado = new JSONObject();
        String direccion = "./PerfilesGrupales/" + nombre + "/" + encuesta + ".json";
        File file = new File(direccion);
        if (file.exists()) {
            JSONParser parser = new JSONParser();
            Object json;
            try {
                json = parser.parse(new FileReader(file));
                resultado = (JSONObject) json;
                resultado.put("Test", encuesta);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return resultado;
        } else {
            return null;
        }
    }

    public void agregarEncuestaGrupal(String nombre, JSONObject resultado, String encuesta) throws IOException {
       //Agrega los resultados de la encuesta grupal a su respectiva carpeta,
       //en caso de no existir la carpeta correespondiente la crea
        String dCarpeta = "./PerfilesGrupales/" + nombre;
        String dArchivo = "/" + encuesta + ".json";
        File file = new File(dCarpeta + dArchivo);
        File usuario = new File(dCarpeta);
        if (!file.exists()) {
            usuario.mkdirs();
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(resultado.toJSONString());
            fw.flush();
            fw.close();
        } else {
            FileWriter fw = new FileWriter(file);
            fw.write(resultado.toJSONString());
            fw.flush();
            fw.close();
        }
    }
    
    public static String getPath(String trabajoPractico, String nombre) {
        String direccion = "./PerfilesGrupales";
        File directory = new File(direccion);
        for(File grupo: directory.listFiles()){ //por cada grupo
            JSONObject integ = getEncuestaGrupal(grupo.getName(), "integrantes");
            if (integ != null){
                ArrayList<String> aux = (ArrayList<String>) integ.get("integrantes");
                trabajoPractico= trabajoPractico.concat(".0");
                if ((aux.contains(nombre))&& (integ.get("tp").equals(trabajoPractico))){
                    return grupo.getName();
                }
            }
        }
        return null;
    } 

}
