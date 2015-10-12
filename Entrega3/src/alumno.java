import java.io.*; 
import java.util.*;

public class alumno extends persona implements Serializable{
	
	String carrera;
	cargaAcademica carga;
	
	public alumno (String Nombre, int Edad, boolean EsHombre, String Rut, String Carrera){
		super(Nombre,Edad, EsHombre, Rut);
		this.carrera = Carrera;
		this.carga = new cargaAcademica();
	}
	
	public void buscarCurso(){
		texto t = new texto();
		Scanner user_input = new Scanner( System.in );
		System.out.println("Cuál es la sigla del curso que desea buscar?");
		String sigla = user_input.next();
		System.out.println(t.retornarLinea("cursos.txt", sigla));
	}
	
	
	public void verCargaAcademica(){
		System.out.println("He inscrito "+this.carga.cursosTomados.size()+" ramos");
		for (int m = 0 ; m<this.carga.cursosTomados.size(); m++){
			System.out.println(this.carga.cursosTomados.get(m));
		}
	}
	
}
