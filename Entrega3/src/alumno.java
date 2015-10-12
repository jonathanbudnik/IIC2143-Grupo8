import java.io.Serializable;
import java.util.Scanner;
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
		//Recorro el .txt y muestro toda la info del curso encontrado.
	}
	
	public void crearSemestre(java.util.ArrayList listaCursos){
		
		Scanner user_input = new Scanner( System.in );
		System.out.println("¿Cuántos ramos deseas agregar?");
		int numCursos = user_input.nextInt();
		
		
		//curso nuevoCurso = new curso (Nombre, Sigla, Profesor,Sala,Año, Semestre,Seccion); 
		
		
		for (int i = 1 ; i<= numCursos ; i++){
			System.out.println("ID del curso "+ i+ ": ");
			int nuevaID = user_input.nextInt();
			// A partir del ID obtener la info del curso
		}
			
		System.out.println("Id");
		String sigla = user_input.next();
		
		//Revisar restricción de créditos
		System.out.println("Se creo un semestre");
		//Crea nuevo semestre
		//Se asigna a cargaAcademica
	}
	
	public void cerrarSemestre(int nota1, int nota2){		
		System.out.println("Se cerró un semestre");
		//Si el ultimo semestre esta cerrado tira error
		// Si el ultima semestre esta abierto.
		
		//Muestra uno por uno los ramos y me pide la nota
	}
	
	public void verCargaAcademica(){
		System.out.println("Mostrando carga académica de "+this.nombre);
	}
	
	//Crear nuevo usuario
	
	//Usuario coincide con clave

}
