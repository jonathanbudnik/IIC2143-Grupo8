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
	
	public int maximoCreditosReprobados(){//Agregar
		String a = MainApp.texto.leerPrimeraLinea("maxCreditosReprobados.txt");
		int b = Integer.parseInt(a);
		return b;
	}
	public Curso retornarCursoSegunId(String ID){ //Agregar
		String buscar = "id"+ID;
		String info = MainApp.texto.retornarLinea("CatalogoCursos.txt", ID);
		String[] a = info.split("-");
		String sigla= a[0];
		String nombre = a[1];
		String profesor = a[2];
		String sala = a[3];
		String año = a[4];
		String semestre = a[5];
		String seccion = a[6];
		String creditos= a[7];
		String departamento= a[8];
		String id_malo =  a[9];
		String id = id_malo.substring(0, id_malo.length()-1); 
		Curso c = new Curso (a[1],sigla,a[2],a[3],a[4],a[5],a[6],a[7],a[8],id);
		return c;
	}
	
	public ArrayList convertirIdsCursos(ArrayList Ids){ //Agregar
		
		ArrayList cursos = new ArrayList();
		
		for (int i=0 ; i<Ids.size(); i++){
			String id1 = (String) Ids.get(i);
			Curso c1 = retornarCursoSegunId(id1);
			cursos.add(c1);
		}
		return cursos;
	}
}
