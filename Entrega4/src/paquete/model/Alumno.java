package paquete.model;
import java.io.*; 
import java.util.*;

import paquete.MainApp;
import paquete.Texto;

public class Alumno extends Persona implements Serializable{

	String carrera;
	CargaAcademica cargaAcademica;
	Malla malla;

	public Alumno (String Nombre, int Edad, boolean EsHombre, String Rut, String Carrera, String Contraseña){
		super(Nombre,Edad, EsHombre, Rut, Contraseña);
		this.carrera = Carrera;
		this.cargaAcademica = new CargaAcademica();
		this.malla = new Malla(Carrera);
		
	}
	
	public String buscarCurso(String x){
		return MainApp.texto.retornarLinea("CatalogoCursos.txt",x);	
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
	
	public int cantidadCursosUltimoSemestre(){ //Agregar
		int tamaño = this.cargaAcademica.semestres.size();
		Semestre s = (Semestre) this.cargaAcademica.obtenerSemestre(tamaño-1);
		int c = s.cursos.size();
		return c;
	}
	
	public ArrayList nombresUltimoSemestre(){
		ArrayList siglas = new ArrayList();
		int tamaño = this.cargaAcademica.semestres.size();
		Semestre s = (Semestre) this.cargaAcademica.obtenerSemestre(tamaño-1);
		for (int i=0; i<s.cursos.size(); i++){
			Curso curso = (Curso) s.cursos.get(i);
			String sigla = curso.sigla;
			siglas.add(sigla);
		}
		return siglas;
	}
	
	
public String obtenerSeguimientoCurricular(){
		
		String s = "";
		
		ArrayList malla = this.malla.siglas;
		ArrayList carga = this.cursosAprobados();	
		ArrayList match = new ArrayList() ;
		ArrayList faltan = new ArrayList();
		
		System.out.println(malla);
		System.out.println(carga);
		
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
		
		int cantidadSemestres = this.cargaAcademica.obtenerSemestres().size();
		System.out.println("llevo "+cantidadSemestres+" semestre");
		
		for (int i = 0 ; i<cantidadSemestres ; i++){
			
			Semestre s = (Semestre)this.cargaAcademica.obtenerSemestres().get(i);
			int cantidadCursos=s.obtenerCursos().size();
			System.out.println("este semestre tiene "+cantidadCursos+" cursos");
			
			for (int j = 0 ; j<cantidadCursos ; j++){
			
				Curso c = (Curso) s.obtenerCursos().get(j);
				System.out.println(c.id);

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
	
	public String obtenerHistorialAcademico(){
		
		Strint t = "";
		
		
		
		
		
		
		
	}
	

	public Semestre obtenerSemestre(int x){ //Le entrego el numero de semestre y me devuelve el semestre
		Semestre s = (Semestre) this.cargaAcademica.obtenerSemestre(x-1);
		return s;
	}

}
