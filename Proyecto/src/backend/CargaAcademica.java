package backend;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Scanner;

public class CargaAcademica implements Serializable{

	java.util.ArrayList semestres ;

	public CargaAcademica(){
		this.semestres = new java.util.ArrayList();
	}
	
	public String toString() {
		
		String s = "ID - Nombre - Sigla - Profesor - Sala - Año - Semestre - Seccion - Nota\n\n";
		for (int i = 0 ; i<this.semestres.size() ; i++){
			s+=this.semestres.get(i);
			s+="\n";
		}
		return s;
	}

	public void agregarSemestre(Semestre x){
		this.semestres.add(x);
	}

	public Semestre obtenerSemestre(int x){
		Semestre s = (Semestre) this.semestres.get(x);
		return s;
	}
	
	public ArrayList obtenerSemestres(){
		return this.semestres;
	}
	
	public String obtenerSiglas1(){//No se usa por ahora
		String s = "";
		for (int i = 0; i<this.semestres.size();i++){
			Semestre S = (Semestre) this.semestres.get(i);
			s+=S.obtenerSiglas1();
		}
		return s;
	}
	
	public ArrayList obtenerSiglas2(){
		ArrayList list = new ArrayList();
		for (int i = 0; i<this.semestres.size();i++){
			Semestre S = (Semestre) this.semestres.get(i);
			list.add(S.obtenerSiglas2());
		}
		ArrayList lista = new ArrayList();
		
		for (int j=0; j<list.size();j++){
			ArrayList x = (ArrayList) list.get(j);
			lista.addAll(x);
		}
		
		return lista;
	}
	
	
		
}
