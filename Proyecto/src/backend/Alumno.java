package backend;

import java.io.*; 
import java.util.*;
import utilidades.*;

public class Alumno extends Persona implements Serializable{

	String carrera;
	CargaAcademica cargaAcademica;
	static Texto t = new Texto();
	Malla malla;

	public Alumno (String Nombre, int Edad, boolean EsHombre, String Rut, String Carrera, String Contraseña){
		super(Nombre,Edad, EsHombre, Rut, Contraseña);
		this.carrera = Carrera;
		this.cargaAcademica = new CargaAcademica();
		this.malla = new Malla(Carrera);
		
	}
	
	public String buscarCurso(String x){
		return this.t.retornarLinea("CatalogoCursos.txt",x);	
	}
	
	public void elegirMalla(Malla m){
		this.malla = m;
	}
	
	public String obtenerMalla(){		
		return this.malla.obtenerMalla();
	}

	public CargaAcademica obtenerCargaAcademica(){
		return this.cargaAcademica;
	}

	public void crearSemestre(ArrayList cursos){ 
		Semestre s = new Semestre(cursos); 
		this.cargaAcademica.agregarSemestre(s);	
	}
	
	
public String obtenerSeguimientoCurricular(){
		
		String s = "";
		
		ArrayList malla = this.malla.siglas;
		ArrayList carga = this.cursosAprobados();	
		ArrayList match = new ArrayList() ;
		ArrayList faltan = new ArrayList();
		
		for (int i=0 ; i<malla.size() ; i++){
			for (int j=0 ; j<carga.size() ; j++){
				String sigla1 = (String) malla.get(i);
				String sigla2 = (String) carga.get(j);
				if (sigla1.equals(sigla2)){
					match.add(sigla1);
				}
				else if (faltan.indexOf(sigla1)==-1){
					faltan.add(sigla1);
				}	
			}
		}	
		s += "Ramos Aprobados:\n";
		for (int n=0 ; n<match.size() ; n++){
			s+=match.get(n);
			s+="\n";
		}
		s += "Ramos Pendientes:\n";
		for (int m=0 ; m<faltan.size() ; m++){
			s+=faltan.get(m);
			s+="\n";
		}	
		return s;
	}
	

	
	public ArrayList cursosAprobados(){ //Muestra los cursos que fueron aprobados
		
		ArrayList Aprobados = new ArrayList();
		
		for (int i = 0 ; i<this.cargaAcademica.obtenerSemestres().size() ; i++){
			
			Semestre s = (Semestre)this.cargaAcademica.obtenerSemestres().get(i);
			
			for (int j = 0 ; j<s.obtenerCursos().size() ; j++){
				Curso c = (Curso) s.obtenerCursos().get(j);
				String x = " - ";

				if (c.estaAprobado()){
					Aprobados.add(c.sigla);
				}
			}
		}
		return Aprobados;
	}
	
	
	public void cerrarSemestre(ArrayList notas){ //Pone notas al ultimo semestre ingresado
		
		int cantidadSemestres = this.cargaAcademica.obtenerSemestres().size();
		Semestre ultimoSemestre =  (Semestre) this.cargaAcademica.obtenerSemestre(cantidadSemestres-1);
		for (int i = 0; i<ultimoSemestre.obtenerCursos().size() ; i++){
			Curso curso = (Curso) ultimoSemestre.obtenerCursos().get(i);
			double nota = (double) notas.get(i);
			curso.setNota(nota);
		}
	}
	
	public String obtenerHistorialAcademico(){ //Muestra los reprobados, aprobados, y en curso
		String retorno = "";
		
		String Aprobados = "Aprobados:";
		String Reprobados = "Reprobados:";
		String Pendientes = "En curso:";
		
		for (int i = 0 ; i<this.cargaAcademica.obtenerSemestres().size() ; i++){
			
			Semestre s = (Semestre)this.cargaAcademica.obtenerSemestres().get(i);
			
			for (int j = 0 ; j<s.obtenerCursos().size() ; j++){
				Curso c = (Curso) s.obtenerCursos().get(j);
				String x = " - ";
				if (c.estaPendiente()){
					Pendientes+="\n";
					Pendientes+=c.sigla+=x+=c.nombre+=x+=c.año+=x+=c.semestre;
					}
				else if (c.estaAprobado()){
					Aprobados+="\n";
					Aprobados+=c.sigla+=x+=c.nombre+=x+=c.año+=x+=c.semestre+=x+=c.nota;
				}
				else if (c.estaAprobado()==false){
					Reprobados+="\n";
					Reprobados+=c.sigla+=x+=c.nombre+=x+=c.año+=x+=c.semestre+=x+=c.nota;
				}	
			}
		}
		
		retorno = Aprobados +"\n" +Reprobados +"\n" +Pendientes;
		return retorno;
	}
	

	public Semestre obtenerSemestre(int x){ //Le entrego el numero de semestre y me devuelve el semestre
		Semestre s = (Semestre) this.cargaAcademica.obtenerSemestre(x-1);
		return s;
	}

}

