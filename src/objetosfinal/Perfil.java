/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosfinal;

import java.util.ArrayList;
import java.util.Set;
import org.json.simple.JSONObject;

/**
 *
 * @author eugem
 */
public class Perfil {

    private String nombre;
    private ArrayList<JSONObject> tests;
    private long factorOrdenamiento;
    private AdministradorPerfil ap;
    private boolean poseeTodos;

    public Perfil(String nombre) {
        this.nombre = nombre;
        tests = new ArrayList<JSONObject>();
        factorOrdenamiento = 0;
        ap = new AdministradorPerfil();
    }

    public Perfil(String nombre, ArrayList<String> tests) {
        this.nombre = nombre;
        this.tests = new ArrayList<JSONObject>();
        factorOrdenamiento = 0;
        ap = new AdministradorPerfil();
        cargarTest(tests);
    }

    public void cargarTest(ArrayList<String> test) {
        //carga una lista de test en el perfil
        for (String t : test) {
            tests.add(ap.getEncuesta(nombre, t));
        }

    }

    public Set<String> getClaves(String test) {
        //Se obtienen las claves del Json de los test
        for (JSONObject jo : tests) {
            if (jo.get("Test").equals(test)) {
                return jo.keySet();
            }
        }
        return null;
    }

    public Long getAtributo(String atributo, String test) {
       //Devuelve el valor de un atributo en especifico
        if(!atributo.equals("Test")){
            Long valor = (long) 0;
            for (JSONObject jo : tests) {
                if (jo.get("Test").equals(test)) {
                    if (jo.containsKey(atributo)) {
                        valor = (Long) jo.get(atributo);
                    }
                }
            }
            return valor;
        }
        return (long) 0;
    }

    public JSONObject getTest(String test) {
        //Devuelve el test seleccionado
        for (JSONObject jo : tests) {
            if (jo.get("Test").equals(test)) {
                return jo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        //permite imprimir la clase Perfil
        return "Perfil [nombre=" + nombre + "]";
    }

    public void setAtributo(String atributo, String test, Long valor) {
        //Modifica el valor de un atributo especifico
        for (JSONObject jo : tests) {
            if (jo.get("Test").equals(test)) {
                jo.put(atributo, (long) valor);
            }
        }
    }

    public String getNombre() {
        //devuelve el nombre
        return nombre;
    }

    public void setNombre(String nombre) {
        //modifica el nombre
        this.nombre = nombre;
    }

    public ArrayList<JSONObject> getTests() {
        //devuelve la lista de test del perfil
        return tests;
    }

    public void setTests(ArrayList<JSONObject> tests) {
        this.tests = tests;
    }

    public long getFactorOrdenamiento() {
        //devuelve el factor de ordenamiento
        return factorOrdenamiento;
    }

    public void setFactorOrdenamiento(long factorOrdenamiento) {
        //Modifica el factor de ordenamiento
        this.factorOrdenamiento = factorOrdenamiento;
    }
    
    public void addTest(String test) {
        //Agrega un test a la carpeta del perfil
	this.tests.add(ap.getEncuesta(nombre, test));
	
    }
    
}
