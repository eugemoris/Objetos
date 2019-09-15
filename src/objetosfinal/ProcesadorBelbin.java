package objetosfinal;

import org.json.simple.JSONObject;

import java.util.*;
import objetosfinal.ComparadorPair;
import objetosfinal.Pair;
import objetosfinal.ProcesadorEncuesta;

public class ProcesadorBelbin extends ProcesadorEncuesta {
//Procesa los test de Belbin
    private Pair implementer;
    private Pair coordinator;
    private Pair shaper;
    private Pair plant;
    private Pair resourceInvestigator;
    private Pair monitor;
    private Pair teamWorker;
    private Pair completer;

    public ProcesadorBelbin() {
        //guarda en Pair el atributo con unas costante cero
        this.implementer = new Pair("implementer", 0);
        this.coordinator = new Pair("coordinator", 0);
        this.shaper = new Pair("shaper", 0);
        this.plant = new Pair("plant", 0);
        this.resourceInvestigator = new Pair("resourceInvestigator", 0);
        this.monitor = new Pair("monitor", 0);
        this.teamWorker = new Pair("teamWorker", 0);
        this.completer = new Pair("completer", 0);
        super.setNombre("belbin");

    }

    public JSONObject getResultado(JSONObject respuestas) {
        //metodo que extiende de su clase abstracta
        JSONObject resultado = new JSONObject();
        //Las claves son reemplazadas con el numero de la pregunta, por ejemplo "3d"
        JSONObject auxiliar = new JSONObject();
        Set<String> set = respuestas.keySet();//obtengo todas las preguntas
        for (String s : set) {//por cada pregunta
            int pos = s.indexOf('[');
            if (pos != -1) {
                String key = s.substring(pos + 1, pos + 3);//ya que la clave que buscamos ej 3d se encuentra entre []
                String valor = (String) respuestas.get(s);
                int punto = valor.indexOf('.');
                valor = valor.substring(0, punto); //el valor es lo que se encuentra antes del punto
                Integer.parseInt(valor);
                auxiliar.put(key, valor);
            }
        }
        // El resultado de cada caracteristica es la suma del valor elegido en ciertas preguntas
        //Se utiliza lo realizado anteriormente para acceder al valor que selecciono en el test
        implementer.setValor(Integer.parseInt((String) auxiliar.get("1g")) + Integer.parseInt((String) auxiliar.get("2a")) + Integer.parseInt((String) auxiliar.get("3h")) + Integer.parseInt((String) auxiliar.get("4d")) + Integer.parseInt((String) auxiliar.get("5b")) + Integer.parseInt((String) auxiliar.get("6f")) + Integer.parseInt((String) auxiliar.get("7e")));
        coordinator.setValor(Integer.parseInt((String) auxiliar.get("1d")) + Integer.parseInt((String) auxiliar.get("2b")) + Integer.parseInt((String) auxiliar.get("3a")) + Integer.parseInt((String) auxiliar.get("4h")) + Integer.parseInt((String) auxiliar.get("5f")) + Integer.parseInt((String) auxiliar.get("6c")) + Integer.parseInt((String) auxiliar.get("7g")));
        shaper.setValor(Integer.parseInt((String) auxiliar.get("1f")) + Integer.parseInt((String) auxiliar.get("2e")) + Integer.parseInt((String) auxiliar.get("3c")) + Integer.parseInt((String) auxiliar.get("4b")) + Integer.parseInt((String) auxiliar.get("5d")) + Integer.parseInt((String) auxiliar.get("6g")) + Integer.parseInt((String) auxiliar.get("7a")));
        plant.setValor(Integer.parseInt((String) auxiliar.get("1c")) + Integer.parseInt((String) auxiliar.get("2g")) + Integer.parseInt((String) auxiliar.get("3d")) + Integer.parseInt((String) auxiliar.get("4e")) + Integer.parseInt((String) auxiliar.get("5h")) + Integer.parseInt((String) auxiliar.get("6a")) + Integer.parseInt((String) auxiliar.get("7f")));
        resourceInvestigator.setValor(Integer.parseInt((String) auxiliar.get("1a")) + Integer.parseInt((String) auxiliar.get("2c")) + Integer.parseInt((String) auxiliar.get("3f")) + Integer.parseInt((String) auxiliar.get("4g")) + Integer.parseInt((String) auxiliar.get("5e")) + Integer.parseInt((String) auxiliar.get("6h")) + Integer.parseInt((String) auxiliar.get("7d")));
        monitor.setValor(Integer.parseInt((String) auxiliar.get("1h")) + Integer.parseInt((String) auxiliar.get("2d")) + Integer.parseInt((String) auxiliar.get("3g")) + Integer.parseInt((String) auxiliar.get("4c")) + Integer.parseInt((String) auxiliar.get("5a")) + Integer.parseInt((String) auxiliar.get("6e")) + Integer.parseInt((String) auxiliar.get("7b")));
        teamWorker.setValor(Integer.parseInt((String) auxiliar.get("1b")) + Integer.parseInt((String) auxiliar.get("2f")) + Integer.parseInt((String) auxiliar.get("3e")) + Integer.parseInt((String) auxiliar.get("4a")) + Integer.parseInt((String) auxiliar.get("5c")) + Integer.parseInt((String) auxiliar.get("6b")) + Integer.parseInt((String) auxiliar.get("7h")));
        completer.setValor(Integer.parseInt((String) auxiliar.get("1e")) + Integer.parseInt((String) auxiliar.get("2h")) + Integer.parseInt((String) auxiliar.get("3b")) + Integer.parseInt((String) auxiliar.get("4f")) + Integer.parseInt((String) auxiliar.get("5g")) + Integer.parseInt((String) auxiliar.get("6d")) + Integer.parseInt((String) auxiliar.get("7c")));

        //Se agregan los resultado a un Json
        resultado.put("implementer", implementer.getValor());
        resultado.put("coordinator", coordinator.getValor());
        resultado.put("shaper", shaper.getValor());
        resultado.put("plant", plant.getValor());
        resultado.put("resourceInvestigator", resourceInvestigator.getValor());
        resultado.put("monitor", monitor.getValor());
        resultado.put("teamWorker", teamWorker.getValor());
        resultado.put("completer", completer.getValor());
        return resultado;
    }
}
