package backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Semestre implements Serializable{

	public static int idInicial = 1;
	int id;
	java.util.ArrayList cursos ;

	public Semestre(ArrayList listaCursos){
		this.cursos = new java.util.ArrayList(listaCursos);
		this.id = Semestre.idInicial++;
	}
	
	public String toString() {
		String s = "";
		for (int i = 0 ; i<this.cursos.size() ; i++){
			s+=this.cursos.get(i);
			s+="\n";
		}
		return s;
	}

	public void agregarCurso(Curso x){
		this.cursos.add(x);
	}
	
	public ArrayList obtenerCursos(){
		return this.cursos;
	}
	
	public String obtenerSiglas1(){
		String s = "";
		for (int i=0 ; i < this.cursos.size() ; i++){
			Curso C = (Curso) this.cursos.get(i) ;
			s+= C.sigla;
			s+= "\n";
		}
		
		return s;
	}
	
	public ArrayList obtenerSiglas2(){
		ArrayList a = new ArrayList();
		for (int i=0 ; i < this.cursos.size() ; i++){
			Curso C = (Curso) this.cursos.get(i) ;
			a.add(C.sigla);
		}
		
		return a;
	}
}
