import java.io.Serializable;

public class curso implements Serializable{
	
	String nombre ;
	String sigla;
	String profesor ;
	String sala ;
	String año ;
	String semestre ;
	String seccion ;
	float nota ;
	String id;
		
	public curso(String Nombre, String Sigla, String Profesor, String Sala, String Año, String Semestre, String Seccion, String Id){
		this.nombre = Nombre ;
		this.sigla = Sigla;
		this.profesor = Profesor;
		this.sala = Sala ;
		this.año = Año;	
		this.semestre = Semestre;	
		this.seccion = Seccion;	
		this.id = Id;
		this.nota = 0 ; // Nota 0 = Curso no terminado aun
	}
	
	public String toString() {
		return this.nombre+"-"+this.sigla+"-"+this.nota;
		}
	
	public void ponerNota(float nuevaNota){
		this.nota = nuevaNota;
	}
	
	
	public String obtenerInfoCurso (String id){
		//A partir de un id, revisa el .txt y retorna toda la info de ese curso
		return "INFO CURSO";
	}

	public void mostrarInfo(){
		System.out.println(this.sigla+"-"+this.nombre+"-"+this.nota);
	}
	
}
