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
	
public int cursosReprobados(){
		
		int n = 0;
		for (int i = 0 ; i<this.cargaAcademica.semestres.size() ; i++){
			Semestre s = (Semestre)this.cargaAcademica.semestres.get(i);
			for (int j=0; j< s.cursos.size(); j++){
				Curso c = (Curso) s.cursos.get(j);
				if (!c.estaAprobado() && !c.estaPendiente()){
					System.out.println(c.sigla);
					n+=1;
				}
			}
		}
		return n;
	}
	
	public String situacionCurricular(){
		int max = MainApp.verificador.maximoCreditosReprobados();
		int actual = cursosReprobados()*10;	
		String retorno;
				
		if (actual<=max){
			retorno =  "         Alumno Regular\n";
		}
		
		else{
			retorno =  "          Expulsado\n";
		}
		retorno += "Cantidad creditos reprobados: ";
		retorno += Integer.toString(actual);
		return retorno;
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
		
		if (carga.size()==0){
			faltan=malla;
		}
		for (int i=0 ; i<malla.size() ; i++){
			for (int j=0 ; j<carga.size() ; j++){
				String sigla2 = (String) carga.get(j);
				String sigla1 = (String) malla.get(i);
				if (sigla1.equals(sigla2)){
					match.add(sigla1);
				}
				else if (faltan.indexOf(sigla1)==-1){
					faltan.add(sigla1);
				}	
			}
		}	
		for (int i=0; i<match.size(); i++){
			for (int j=0; j<faltan.size(); j++){
				if ((String) match.get(i)==(String) faltan.get(j)){
					faltan.remove(j);
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

				if (c.estaAprobado()){
					Aprobados.add(c.getSigla());
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
					Pendientes+=c.sigla+x+c.nombre+x+c.año+x+c.semestre;
					}
				else if (c.estaAprobado()){
					Aprobados+="\n";
					Aprobados+=c.sigla+x+c.nombre+x+c.año+x+c.semestre+x+c.nota;
				}
				else if (c.estaAprobado()==false){
					Reprobados+="\n";
					Reprobados+=c.sigla+x+c.nombre+x+c.año+x+c.semestre+x+c.nota;
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
	
	public String buscarCursoPeriodo(String x, String y){ //NUEVO
		return MainApp.texto.retornarLinea2Palabras("CatalogoCursos.txt",x,y);	
	}
	
	public String obtenerPrograma(String sigla){ //NUEVO
		String programa = MainApp.texto.leer(sigla+"/programa.txt");	
		return programa;
	}
	
	public String obtenerForo(String sigla){
		String foro = MainApp.texto.leer(sigla+"/foro.txt");	
		return foro;
	}
	
	public String obtenerNoticia(){	
		return MainApp.texto.leer("noticias.txt");
	}
	
	public void escribirForo(String mensaje, String sigla){
		MainApp.texto.agregarTexto(sigla+"/foro.txt", this.nombre + ": "+mensaje + "\n");
	}

}
