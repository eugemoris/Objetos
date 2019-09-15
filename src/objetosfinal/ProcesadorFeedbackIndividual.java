/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosfinal;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import org.json.simple.JSONObject;

/**
 *
 * @author eugem
 */
public class ProcesadorFeedbackIndividual extends ProcesadorEncuesta{
   	private File archivoRoles;
	private Hashtable<String,String> roles ;
	private AdministradorPerfil admPerfil;
	private File preguntasSymlog;
	private ProcesadorSymlog procSymlog;
	private ArrayList<String> miembros;
	private File pregConform;
	
public ProcesadorFeedbackIndividual(){
	archivoRoles = new File ("./rolesFeedback.txt");
	roles = new Hashtable<String, String>();
	admPerfil = new AdministradorPerfil();
	preguntasSymlog= new File ("./symlogFeedback.txt");
	pregConform= new File("./conformidad.txt");
	super.nombre="feedback";
	try {
		cargarHash();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		procSymlog= new ProcesadorSymlog(new FileReader ("./symlog.txt"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	private void cargarHash() throws FileNotFoundException {
		// Se cargan las dos maneras de llamar al mismo rol, para poder hacer un match y reutilizar el procesador de Belbin
		DataInputStream dato = new DataInputStream(new FileInputStream(archivoRoles));
		String tmp;
		try{
			while ((tmp= dato.readLine()) != null){
				String[] temporal= tmp.split(",");
				roles.put(temporal[0], temporal[1]);
			}
		}
		catch(IOException exc){		
		}
}

	@Override
	public JSONObject getResultado(JSONObject respuestas) {
		try {
			setRoles(respuestas);
			setSymlog(respuestas);
			setConformidad(respuestas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void setConformidad (JSONObject respuestas) throws IOException{
		DataInputStream dato = new DataInputStream(new FileInputStream(pregConform));
		// se tiene en nombre del grupo conformado por el numero de grupo y de TP
		String grupo = (String) respuestas.get("Grupo Nro:") +" "+ (String) respuestas.get("Trabajo Práctico Nro:");
		String tmp;
		ArrayList<Pair> result = new ArrayList<Pair>(); 
		try{
			// Se genera una lista de pares donde se almacena la pregunta con su respuesta
			while ((tmp= dato.readLine()) != null){
				if (!tmp.equals("Evalúe su equipo")){
				String valor= cambiarValor((String)respuestas.get(tmp));
				result.add(new Pair(tmp, valor));
				}
				else 
					result.add(new Pair(tmp, respuestas.get(tmp)));
			}
		}
		catch(IOException exc){		
		}
		// se obtiene el archivo de conformidad del grupo
		JSONObject conformidad = admPerfil.getEncuestaGrupal(grupo, "conformidad");
		int index ;
		String valor="";
		//si no eviste se crea y se agregan los valores
		if (conformidad == null){
			ArrayList<Integer> resultados = new ArrayList<Integer>();
			JSONObject auxiliar = new JSONObject ();
			for(Pair p: result){
				index = ((String) p.getValor()).indexOf(".");
				valor = ((String) p.getValor()).substring(0, index);
				resultados.add(Integer.parseInt(valor));
				long suma = 0;
				int cantidad = resultados.size();
				long promedio = 0;
				for(int s: resultados){
					
					suma += s;
				}
				promedio = suma / cantidad;
				auxiliar.put("lista "+p.getNombre(), (ArrayList<Long>)resultados.clone());
				auxiliar.put(p.getNombre(), promedio);
				resultados.clear();
			}
		
			admPerfil.agregarEncuestaGrupal(grupo, auxiliar, "conformidad");
		}
		// Si ya existe se agregan los nuevos valores al archivo. Por cada pregunta, se agrega la respuesta a la lista y además se recalcula el promedio
		else{
			ArrayList<Long> resultados = new ArrayList<Long>();
			JSONObject auxiliar = new JSONObject ();
			for(Pair p: result){
				resultados =  (ArrayList<Long>) conformidad.get("lista "+p.getNombre());
				index = ((String) p.getValor()).indexOf(".");
				valor = ((String) p.getValor()).substring(0, index);
				resultados.add((long) Integer.parseInt(valor));
				long suma = 0;
				int cantidad = resultados.size();
				long promedio = 0;
				for(Long s: resultados){
					suma += (long) s;
				}
				promedio = suma / cantidad;
				auxiliar.put("lista "+p.getNombre(), (ArrayList<Long>)resultados.clone());
				auxiliar.put(p.getNombre(), promedio);
				resultados.clear();
			}
		
			admPerfil.agregarEncuestaGrupal(grupo, auxiliar, "conformidad");
		}
	}
	private String cambiarValor(String valor) {
		// Para poder tratar los valores con el mismo criterio, se invierten. Los valores mas altos representan ahora mayor grado de conformidad
		switch (valor){
		case "1.0": return "5.0";
		case "2.0": return "4.0"; 
		case "3.0": return "3.0";
		case "4.0": return "2.0";
		case "5.0": return "1.0";
		}
		return null;
	}

	public void setRoles(JSONObject respuestas) throws IOException{
		//Deberia abrir los feedback de cada persona y setear su valor y volver a guardarlo..
		Hashtable <String,String >integrantes = new Hashtable<String,String>();
		String grupo = (String) respuestas.get("Grupo Nro:") +" "+ (String) respuestas.get("Trabajo Práctico Nro:");
		JSONObject integ = new JSONObject();
		JSONObject miembros = admPerfil.getEncuestaGrupal(grupo, "integrantes");
	
		// obtengo los integrantes del grupo y los identifico como i1 por ejemplo
		integrantes.put("Tú",respuestas.get("Tù Nombre (0)")+" "+ respuestas.get("Tù Apellido (0)"));
		for (int i=1; i<7; i++){
			integrantes.put("i"+i, (String)respuestas.get("Nombre de tu compañero (i"+i+")") +" "+ (String)respuestas.get("Apellido de tu compañero (i"+i+")"));
		}	
		Set<String> claves = integrantes.keySet();

		ArrayList<String> listaIntegrantes= new ArrayList<String>();
		if(miembros == null){
			for(String key: claves){
				listaIntegrantes.add(integrantes.get(key));
			}
		
		integ.put("grupo", (String) respuestas.get("Grupo Nro:"));
		integ.put("tp", (String) respuestas.get("Trabajo Práctico Nro:"));
		integ.put("integrantes", listaIntegrantes);
		admPerfil.agregarEncuestaGrupal(grupo, integ, "integrantes");		
		}
		//Cargo los roles con las personas que se eligieron
		Hashtable<String,String> asignaciones = new Hashtable<String,String>();
		Set<String> nombreRoles=roles.keySet();
		for(String rol:nombreRoles){
			for(String key:claves){
				if(key.endsWith(rol+"]")){
					asignaciones.put(rol, (String) respuestas.get(key));
					break;
				}	
			}
		}
		claves= asignaciones.keySet();
		//Por cada rol, modifico el archivo feedback de roles de cada persona 
		JSONObject feedBack;
		for (String rol : claves){
			String integrante =integrantes.get(asignaciones.get(rol));
			feedBack=admPerfil.getEncuesta(integrante, "feedbackRoles");
			if (feedBack == null){
				feedBack = new JSONObject();
				for(String s:nombreRoles){
					String rolBelbin= roles.get(s);
					if (s.equals(rol))
						
						feedBack.put(rolBelbin,new Long (1));
					else
						feedBack.put(rolBelbin, new Long(0));
				}
				admPerfil.agregarEncuesta(integrante, feedBack, "feedbackRoles");		
			}
			else{
				for(String s: nombreRoles){
					String rolBelbin = roles.get(s);
					if (s.equals(rol)){
						Long valor= (Long) feedBack.get(rolBelbin);
						feedBack.put(rolBelbin, valor++);
					}
				}
				feedBack.put("implementer", new Long(0));
				admPerfil.agregarEncuesta(integrante, feedBack, "feedBackRoles");
			}
		}	
	
	}
	public void setSymlog(JSONObject respuestas) throws IOException{
	
		JSONObject symlog = new JSONObject();
		DataInputStream dato = new DataInputStream(new FileInputStream(preguntasSymlog));
		String tmp;
		try{
			// reemplazo los valores para poder reutilizar el procesador Symlog
			while ((tmp= dato.readLine()) != null){
				String[] temporal= tmp.split(";");
				String valor;
				if ((respuestas.get(temporal[0])).equals("2.0"))
					valor ="A VECES";
				else if ((respuestas.get(temporal[0])).equals("1.0"))
					valor ="NUNCA";
				else valor = "SIEMPRE";
					
				symlog.put(temporal[1], valor);
			}
		}
		catch(IOException exc){
			System.out.println("No se pudo leer el archivo de SymlogFeedback");
		}
		// Se realiza la misma metodologia que con el de conformidad. Se calcula un promedio de las respuestas.
		long suma= 0;
		long promedio=0;
		int cantidad=0;
		ArrayList<Long> results = new ArrayList<Long>();
		JSONObject resultado= procSymlog.getResultado(symlog);
		String grupo = (String) respuestas.get("Grupo Nro:") +" "+ (String) respuestas.get("Trabajo Práctico Nro:");
		JSONObject feedGrupo = admPerfil.getEncuestaGrupal(grupo, "feedBackSymlog");
		Set<String> keys= resultado.keySet();
		if (feedGrupo != null){
			for(String s: keys){
				if(feedGrupo.get(s) == null){
					results.add((long)resultado.get(s));
					feedGrupo.put("lista "+s, results.clone());
					feedGrupo.put(s, (long)resultado.get(s));
				}
				else{
					results= (ArrayList<Long>) feedGrupo.get("lista "+s);
					results.add((Long) resultado.get(s));
					for(long l: results){
						suma+=l;
					}
					cantidad = results.size();
					promedio= suma / cantidad;
					feedGrupo.put("lista "+s, results.clone());
					feedGrupo.put(s, promedio);
				}
			}
			results.clear();
		}
		else
		{
			feedGrupo= new JSONObject();
			for(String s: keys){
					results.add((long)resultado.get(s));
					feedGrupo.put("lista "+s, results.clone());
					results.clear();
			}
		}
		admPerfil.agregarEncuestaGrupal(grupo, feedGrupo, "feedBackSymlog");
	}
}
