import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class administrador extends persona{


	public administrador (String Nombre, int Edad, boolean EsHombre, String Rut){
		super(Nombre,Edad, EsHombre, Rut);
	}

	public void agregarCurso (){
		texto t = new texto();
		Scanner user_input = new Scanner( System.in );
		
		System.out.println("Sigla:");
		String Sigla1 = user_input.nextLine();
		String Sigla = Sigla1.toUpperCase() ;
		System.out.println("Nombre:");
		String Nombre= user_input.nextLine();
		System.out.println("Profesor:");
		String Profesor= user_input.nextLine();
		System.out.println("Sala:");
		String Sala= user_input.nextLine();
		System.out.println("Año:");
		String Año= user_input.nextLine();
		System.out.println("Semestre:");
		String Semestre= user_input.nextLine();
		System.out.println("Seccion:");
		String Seccion= user_input.nextLine();	
		String nuevoRamo = Sigla+"-"+Nombre+"-"+Profesor+"-"+Sala+"-"+(Año)+"-"+(Semestre)+"-"+(Seccion);
		System.out.println(nuevoRamo);
		t.escribir("cursos.txt", nuevoRamo);
		
	}

	public void crearMalla(){

		texto t = new texto();
		Scanner user_input = new Scanner( System.in );
		System.out.println("De qué carrera es la nueva malla?");
		String carrera = user_input.next();

		while(true){
			
			System.out.println("Escriba la sigla del nuevo ramo:\n*presione 1 para terminar");
			String ramo = user_input.next();
			if (ramo.equals("1")){
				break;
			}
			t.escribir(carrera+".txt", ramo);			
		}

		System.out.println("Malla creada");
	}

	public void fijarMaximoCreditos(){
		Scanner user_input = new Scanner( System.in );
		texto t = new texto();
		System.out.println("Cuanto es el nuevo máximo de creditos por semestre?");
		String max = user_input.next();
		t.escribirDesdeCero("maxCreditosSemestre.txt", max);
	}

	public void fijarMaximoCreditosReprobados(){
		Scanner user_input = new Scanner( System.in );
		texto t = new texto();
		System.out.println("Cuanto es el nuevo máximo de creditos reprobados?");
		String max = user_input.next();
		t.escribirDesdeCero("maxCreditosReprobados.txt", max);

	}
}
