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
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;


public class EstrategiaGrupal extends EstrategiaSimple{
    	private String atributoSelec;
	private AdministradorPerfil ap;
	private  File pregConform;
        
	public EstrategiaGrupal(String seleccion){
		atributoSelec= seleccion;
		pregConform= new File("./conformidad.txt");
		ap= new AdministradorPerfil();

	}
	
	@Override
	public ArrayList<ArrayList<Perfil>> generarGrupos(ArrayList<Perfil> perfiles, int cantidad) {
		ArrayList<Pair> puntajes = getPuntajeGrupos(atributoSelec);
		int cantGrupos = perfiles.size() / cantidad;

		ComparadorPair cp= new ComparadorPair();
		// Se ordenan los grupos segun el puntaje
		puntajes.sort(cp);
		ArrayList<ArrayList<Perfil>> grupos= new ArrayList<ArrayList<Perfil>>();
		ArrayList<Perfil> integrantes = new ArrayList<Perfil>();
		ArrayList<String> miembros = new ArrayList<String>();
		JSONObject jsonMiembros = new JSONObject();
		// por cada grupo, se agregan a un grupo aquellas personas que esten dentro de la lista seleccionada
		for(Pair par: puntajes){
			jsonMiembros = ap.getEncuestaGrupal((String)par.getNombre(), "integrantes");
			miembros= (ArrayList<String>) jsonMiembros.get("integrantes");
			for(String member : miembros){
				Perfil perfil = getPerfil(perfiles,member);
				if (perfil!=null && (integrantes.size() < cantidad)){
					integrantes.add(perfil);
					perfiles.remove(perfil);
				}
			}
			// Si la cantidad de integrantes del grupo no supera el 50% de la cantidad, se desarma
			if (integrantes.size() >= cantidad/2){
				grupos.add((ArrayList<Perfil>) integrantes.clone());
				integrantes.clear();
			}
			else{
				for(Perfil p: integrantes){
					perfiles.add(p);
				}
			}
		}
		
		boolean todosLlenos = false;
		int gruposRestantes =cantGrupos - grupos.size();
		// Se agregan grupos faltantes
		for (int i = 1 ; i <= gruposRestantes; i++)
			grupos.add(0, new ArrayList<Perfil>());
		// Todos los integrantes que queden libres se agregan a los grupos que todavia no esten completos
		while (!perfiles.isEmpty()){
			for (ArrayList<Perfil> list : grupos){
				if ((perfiles.size()>0) && (list.size()< cantidad)){
				list.add(perfiles.get(0));
				perfiles.remove(0);
				}
			}
			int grupoLleno=0;
			for (ArrayList<Perfil> list : grupos){
				if (list.size() == cantidad){
					grupoLleno++;
				}
			}
			// si todos los grupos estan llenos y quedan personas sin asignarse, se agregan a los grupos en orden
			if (grupoLleno == cantGrupos)
				todosLlenos=true;
			if (todosLlenos){
				for (ArrayList<Perfil> list : grupos){
					if ((perfiles.size()>0)){
					list.add(perfiles.get(0));
					perfiles.remove(0);
					}
			}
			}
		}
                
		return grupos;
	}
	

	private Perfil getPerfil(ArrayList<Perfil> perfiles, String member) {
		for (Perfil p : perfiles){
			if (p.getNombre().equals(member)){
				return p;
			}
		}
		return null;
	}
	
	private long getValorGrupal(JSONObject encuesta) throws FileNotFoundException {
		long suma = 0;
		DataInputStream dato = new DataInputStream(new FileInputStream(pregConform));
		String tmp;
		try{
			while ((tmp= dato.readLine()) != null){
				suma+= (long)encuesta.get(tmp);
			}
		}
		catch(IOException exc){		
		}
		return suma;
	}
        
        private ArrayList<Pair> getPuntajeGrupos(String atributo) {
		ArrayList<Pair> puntajes = new ArrayList<Pair>();
			// para calcular el puntaje grupal, se suman todos los valores de las preguntas pertenecientes a CONFORMIDAD. Ya que un puntaje mas alto representa mayor grado de conformidad
				String directorio = "./PerfilesGrupales";
				File directory = new File(directorio);
				long valor ;
				for (File grupo: directory.listFiles()){
					valor = 0;
					JSONObject encuesta = new JSONObject();
                                        if (atributoSelec.equals("conformidad")){
                                            encuesta = ap.getEncuestaGrupal( grupo.getName(), atributoSelec);
                                            if (encuesta != null){
                                                try {
                                                        // realiza la suma propiamente dicha
                                                            valor = getValorGrupal(encuesta);
                                                }
                                                catch (FileNotFoundException e) {
                                                            e.printStackTrace();
                                                }
                                            }
                                        }
                                        else{
                                            encuesta = ap.getEncuestaGrupal(grupo.getName(), "feedback");
                                            if (encuesta != null){
                                                valor = (long) encuesta.get(atributoSelec);
                                            }
                                        }
					puntajes.add(new Pair(grupo.getName(),valor));	
				
				}
		
		return puntajes;
	}
}
