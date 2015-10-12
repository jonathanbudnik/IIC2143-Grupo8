import java.io.Serializable;
import java.util.Scanner;

public class cargaAcademica implements Serializable{

	java.util.ArrayList cursosTomados ;

	public cargaAcademica(){
		this.cursosTomados = new java.util.ArrayList();
	}

	public void agregarCursos(){

		Scanner user_input = new Scanner( System.in );
		texto t = new texto();

		System.out.println("¿Cuantos cursos deseas tomar?:");	
		int cantidadRamos= user_input.nextInt();

		if (cantidadRamos*10<=50){

			for (int i = 0; i<cantidadRamos ; i++){
				System.out.println("ID:\n(Ej: id001)");
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

				System.out.println(this.cursosTomados.size());
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
		for (int n=0; n<this.cursosTomados.size(); n++){
			//if (this.cursosTomados.get(n).getId.equals(ID)){
			//cursoBuscado = this.cursosTomados.get(n):
		}
		return cursoBuscado;
	}

	public void ponerNota(String id, float x){
		this.obtenerCurso(id).ponerNota(x) ;

	}
}
