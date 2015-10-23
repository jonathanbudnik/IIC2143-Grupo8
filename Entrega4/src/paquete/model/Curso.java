package paquete.model;

import java.io.Serializable;

public class Curso implements Serializable{

	String id;
	String nombre ;
	String sigla;
	String profesor ;
	String sala ;
	String año ;
	String semestre ;
	String seccion ;
	String creditos;
	String departamento;
	double nota ;

	public Curso (String Nombre, String Sigla, String Profesor, String Sala, String Año, String Semestre, String Seccion, String Creditos, String Departamento, String Id){
		this.nombre = Nombre ;
		this.sigla = Sigla;
		this.profesor = Profesor;
		this.sala = Sala ;
		this.año = Año;	
		this.semestre = Semestre;	
		this.seccion = Seccion;	
		this.id = Id;
		this.nota = 0 ; 
		this.creditos = Creditos;
		this.departamento = Departamento;
	}

	public String toString() {
		return (this.id+" - "+this.nombre+" - "+this.sigla+" - "+this.profesor+" - "+this.sala+" - "+this.año+" - "+this.semestre+" - "+this.seccion+" - "+this.nota);
	}

	public String getSigla(){
		return this.sigla;
	}

	public void setNota(double x){
		this.nota = x;
	}	
	
	public boolean estaPendiente(){
		
		if (this.nota==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean estaAprobado(){
		if (this.nota>=3.95 && this.nota<=7){
			return true;
		}
		else{
			return false;
		}
	}

	public String getInformacion() {
		return (this.id+" - "+this.nombre+" - "+this.sigla+" - "+this.profesor+" - "+this.sala+" - "+this.año+" - "+this.semestre+" - "+this.seccion+" - "+this.nota);
	}

}