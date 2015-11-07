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
	public Curso retornarCursoSegunId(String ID){ //CAMBIAR
		String buscar = "id"+ID;
		String info = MainApp.texto.retornarLinea("CatalogoCursos.txt", ID);
		
		System.out.println(info);
		String[] a = info.split("-");
		String sigla= a[0];
		String nombre = a[1];
		String profesor = a[2];
		String sala = a[3];
		String añoSemestre = a[4];
		String [] b = añoSemestre.split(",");
		String año = b[0];
		String semestre = b[1];
		
		System.out.println(año);
		System.out.println(semestre);
		String seccion = a[5];
		String creditos= a[6];
		String departamento= a[7];
		String id_malo =  a[8];
		String id = id_malo.substring(0, id_malo.length()-1); 
		Curso c = new Curso (nombre,sigla,profesor,sala, año,semestre,seccion,creditos,departamento,id);
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
