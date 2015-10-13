import java.io.Serializable;
import java.util.Scanner;

//Cada carga académica pertence a un alumno, y es ahí donde se almacenan todos los cursos 
// Desde esta clase se realizan la mayoría de los métodos relacionados a los cursos.

public class cargaAcademica implements Serializable{

	java.util.ArrayList cursosTomados ;

	public cargaAcademica(){
		this.cursosTomados = new java.util.ArrayList();
	}

	public void agregarCursos(){

		Scanner user_input = new Scanner( System.in );
		texto t = new texto();

		String max = t.retornarTextoCorto(("maxCreditosSemestre.txt"));
		System.out.println("¿Cuantos cursos deseas tomar?:\nMáximo de créditos: "+max);	
		int cantidadRamos= user_input.nextInt();		
		max.replace(" ","");
		int MAX = Integer.parseInt(max);

		if (cantidadRamos*10<=MAX){

			for (int i = 0; i<cantidadRamos ; i++){
				System.out.println("Escriba el ID del curso (Ej: id001):");
				String id= user_input.next();
				String l = t.retornarLinea("cursos.txt", id);
				String[] parts = l.split("-");
				String sigla = parts[0]; 
				String nombre = parts[1]; 
				String profe = parts[2]; 
				String sala = parts[3]; 
				String año = parts[4]; 
				String semestre = parts[5]; 
				String seccion = parts[6]; 	
				String ID = parts[7]; 
				curso cursoNuevo = new curso(nombre, sigla, profe, sala, año, semestre, seccion, ID);
				this.cursosTomados.add(cursoNuevo) ;

			}
		}
		else{
			System.out.println("Excede el máximo de créditos");
		}
	}

	public void mostrarCargaAcademica(){
		System.out.println("Has tomado los siguientes cursos:");
		System.out.println("Sigla-Nombre-Nota");
		for (int i=0 ; i <this.cursosTomados.size(); i++){
			((curso) cursosTomados.get(i)).mostrarInfo();
		}
	}

	public curso obtenerCurso(String ID){
		curso cursoBuscado = null;
		boolean cursoEncontrado = false ;
		for (int n=0; n<this.cursosTomados.size(); n++){
			curso c = (curso)this.cursosTomados.get(n) ;
			if (ID.equals(c.id)){
				cursoBuscado = c;
				cursoEncontrado = true ;
				System.out.println("El ramo elegido es: \n"+c);
			}
		}
		if (!cursoEncontrado){
			System.out.println("El curso no está inscrito");
		}
		return cursoBuscado;
	}

	public void ponerNota(){
		Scanner user_input = new Scanner( System.in );
		System.out.println("Escriba el id del curso que quiere poner su nota final (Ej: id001):");
		String id= user_input.next();		
		curso c = this.obtenerCurso(id) ;
		System.out.println("Escriba la nota final:");
		float nota = user_input.nextFloat();
		if (nota>1.0 && nota<7.0){
			c.ponerNota(nota);
		}
		else{
			System.out.println("Nota inválida");
		}
	}
}
