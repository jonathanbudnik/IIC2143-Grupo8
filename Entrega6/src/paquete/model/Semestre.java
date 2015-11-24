package paquete.model;

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
	
	public void botarRamo(String sigla){
		for (int i=0 ; i<this.cursos.size() ; i++){
			Curso c1 = (Curso) this.cursos.get(i);
			if (c1.sigla.trim().equals(sigla) && c1.nota==0){
				this.cursos.remove(i);
			}
		}
	}

	public Curso retonarCurso(String id){
		Curso c = (Curso) this.cursos.get(0);
		for (int i=0 ; i<this.cursos.size() ; i++){
			Curso c1 = (Curso) this.cursos.get(i) ;
			if (c1.id.equals(id)){
				c = c1; 
			}
		}
		return c ;
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