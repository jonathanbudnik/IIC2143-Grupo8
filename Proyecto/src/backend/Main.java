package backend;
import java.util.ArrayList;

import utilidades.*;

public class Main {

	public static void main(String[] args) {
		
		Alumno a1 = new Alumno  ("Jonathan Budnik", 22, true, "183949217","Ingenieria", "123");
		Administrador admin = new Administrador("Alberto Nahum ", 49 , true, "200000000", "123");

		Curso c1 = new Curso("Ingenieria de Software", "IIC1104","Yadran Yadran", "A2", "2015", "2", "1", "541213");
		Curso c2 = new Curso("Matematicas Discretas", "MAT1610","Yadran Yadran", "A2", "2015", "2", "1", "147653");
		Curso c3 = new Curso("Organizacion en la Empresa", "IIC01231","Yadran Yadran", "A2", "2015", "2", "1", "421213");
		Curso c4 = new Curso("Estrategias TI", "IIC1103","Yadran Yadran", "A2", "2015", "2", "1", "721213");
		Curso c5 = new Curso("Bases de Datos", "IIC2143","Yadran Yadran", "A2", "2015", "2", "1", "901213");
		
		java.util.ArrayList cursos1 = new java.util.ArrayList();
		java.util.ArrayList cursos2 = new java.util.ArrayList();
	
		cursos1.add(c1);
		cursos1.add(c2);
		cursos1.add(c3);
		cursos2.add(c4);
		cursos2.add(c5);
		
		a1.crearSemestre(cursos1);
		a1.crearSemestre(cursos2);
		
		ArrayList notas = new ArrayList();
		notas.add(4.3);
		notas.add(2.3);
		a1.cerrarSemestre(notas);
		
	
		
		
		System.out.println(a1.obtenerSeguimientoCurricular());
		

		
		
	
	}

}