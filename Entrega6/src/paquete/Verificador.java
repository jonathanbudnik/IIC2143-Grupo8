package paquete;

import java.util.ArrayList;

import paquete.model.Administrador;
import paquete.model.Alumno;
import paquete.model.Curso;

public class Verificador {
	
	public boolean contraseñaCorrectaAlumno(Alumno x, String contraseña){		
		return contraseña.equals(x.contraseña);
	}
	
	public boolean contraseñaCorrectaAdmin(Administrador x, String contraseña){		
		return contraseña.equals(x.contraseña);
	}
	public int maximoCreditosSemestre(){ //Agregar
		String a = MainApp.texto.leerPrimeraLinea("maxCreditosSemestre.txt");
		int b = Integer.parseInt(a);
		return b;
	}
	
	public float notaExcelencia(){ //Agregar
		String a = MainApp.texto.leerPrimeraLinea("notaExcelencia.txt");
		float b = Float.parseFloat(a);
		return b;
	}
	
	public Curso retornarCursoSegunSigla(String Sigla){ //CAMBIAR
		String info = MainApp.texto.retornarLinea("CatalogoCursos.txt", Sigla);

		String[] a = info.split("-");
		String sigla= a[0];
		String nombre = a[1];
		String profesor = a[2];
		String sala = a[3];
		String añoSemestre = a[4];
		String [] b = añoSemestre.split(",");
		String año = b[0];
		String semestre = b[1];
		String seccion = a[5];
		String creditos= a[6];
		String departamento= a[7];
		String prerequisito= a[8];
		String horario= a[9];
		String id_malo =  a[10];
		String id = id_malo.substring(0, id_malo.length()-1); 
		
		Curso c = new Curso (nombre,sigla,profesor,sala, año,semestre,seccion,creditos,departamento,prerequisito,horario,id);
		return c;
	}
	
	public int maximoCreditosReprobados(){//Agregar
		String a = MainApp.texto.leerPrimeraLinea("maxCreditosReprobados.txt");
		int b = Integer.parseInt(a);
		return b;
	}
	public Curso retornarCursoSegunId(String ID){ //CAMBIAR
		String buscar = "id"+ID;
		String info = MainApp.texto.retornarLinea("CatalogoCursos.txt", ID);

		String[] a = info.split("-");
		String sigla= a[0];
		String nombre = a[1];
		String profesor = a[2];
		String sala = a[3];
		String añoSemestre = a[4];
		String [] b = añoSemestre.split(",");
		String año = b[0];
		String semestre = b[1];
		String seccion = a[5];
		String creditos= a[6];
		String departamento= a[7];
		String prerequisito= a[8];
		String horario= a[9];
		String id_malo =  a[10];
		String id = id_malo.substring(0, id_malo.length()-1); 


		Curso c = new Curso (nombre,sigla,profesor,sala, año,semestre,seccion,creditos,departamento,prerequisito,horario,id);
		return c;
	}
	
	public ArrayList convertirIdsCursos(ArrayList Ids){
		
		ArrayList cursos = new ArrayList();
		
		for (int i=0 ; i<Ids.size(); i++){
			String id1 = (String) Ids.get(i);
			Curso c1 = retornarCursoSegunId(id1);
			cursos.add(c1);
		}
		return cursos;
	}
	
	public ArrayList verificarTopeHorario(ArrayList cursos){

		ArrayList topeHorario = new ArrayList();
		int cont = 0;

		for (int i =0 ; i<cursos.size(); i++){
			for (int j=0 ; j<cursos.size(); j++){

				if (i!=j){
					Curso c1 = (Curso) cursos.get(i);
					Curso c2 = (Curso) cursos.get(j);
					ArrayList tope = this.compararHorario(c1,c2);
					for (int n=0; n<tope.size();n++){
						String t = (String) tope.get(n);
						if (!topeHorario.contains(t)){
							topeHorario.add(t);		
						}
					}				
				}
			}
		}
		return topeHorario;
	}
	
	public ArrayList compararHorario(Curso curso1, Curso curso2){
		String tope = "";
		ArrayList topeHorario = new ArrayList();
		String[] horarios1 = curso1.horario.split(",");
		String[] horarios2 = curso2.horario.split(",");
		for (int i =0 ; i<horarios1.length; i++){
			for (int j=0 ; j<horarios2.length; j++){

				if (horarios1[i].equals(horarios2[j]) && !tope.contains(horarios1[i])) {
					topeHorario.add(horarios1[i]);
				}
			}
		}
		return topeHorario;
	}
	
	public boolean hayTope(ArrayList cursos){
		if (cursos.size()==0){
			return false;
		}
		
		return true;
	}
}
