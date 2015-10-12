import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {

		int maxCreditosSemestre = 50 ;
		int maxCreditosReprobados = 100 ;

		Scanner user_input = new Scanner( System.in );
		serializador s = new serializador();
		texto t = new texto();
		
		
		System.out.println("Bienvenido! Eres un: \n(1) Alumno \n(2) Administrador ");
		String var1 = user_input.next();

		if (var1.equals("1")) {
			System.out.println("(1) Ingresar \n(2) Crear cuenta");
			String var2 = user_input.next();
			if (var2.equals("1")){
				System.out.println("Rut del usuario:");
				String rut= user_input.next();
				System.out.println("Contraseña:");
				String password = user_input.next();

				if (true){ //Usuario coincide con clave

					alumno alum = new alumno("Jonathan",22,true, "183949217", "Ingenieria");
								
					System.out.println("(1) Ver carga académica \n(2) Buscar curso \n(3) Crear nuevo semestre \n(4) Poner notas\n(5) Ver mi malla");
					String var3 = user_input.next();
					if (var3.equals("1")){ //Check
						alum.verCargaAcademica();					
					}

					else if (var3.equals("2")){ //Check
						alum.buscarCurso();
					}

					else if (var3.equals("3")){ //Check
						alum.carga.agregarCursos();

					}

					else if (var3.equals("4")){
					
					}
					
					else if (var3.equals("5")){ //Check
						t.leer(alum.carrera.toLowerCase()+".txt");
					}

					else{
						System.out.println("Error");
					}
				}
			}

			else if (var2.equals("2")){
				System.out.println("Nombre:");
				String Nombre= user_input.next();
				System.out.println("Edad:");
				int Edad= user_input.nextInt();
				System.out.println("Sexo:\n(1)Hombre\n(2)Mujer");
				String gender= user_input.next();
				boolean EsHombre = true;
				if (gender.equals("2")){
					EsHombre = false;
				}
				System.out.println("Rut:");
				String Rut= user_input.next();
				System.out.println("Carrera:");
				String Carrera= user_input.next();
				
				alumno nuevoAlumno = new alumno(Nombre, Edad, EsHombre, Rut, Carrera);
				try {
					s.guardarAlumno(nuevoAlumno);
					System.out.println("Usuario creado");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}

		else if (var1.equals("2")){
			System.out.println("(1) Ingresar (2) Crear cuenta");
			String var2 = user_input.next();

			if (var2.equals("1")){

				System.out.println("Rut:");
				String rut= user_input.next();
				System.out.println("Contraseña:");
				String password = user_input.next();

				if (true){ //rut coincide con clave

					//Deserializar el admin deseado.
					
					administrador admin = new administrador("Yadran",50,true,"183949547");

					System.out.println("(1) Crear un curso \n(2) Crear una malla \n(3) Cambiar máximo créditos por semestre \n(4) Cambiar máximo creditos reprobados");
					String var3 = user_input.next(); //Check
					if (var3.equals("1")){
						admin.agregarCurso();			
					}

					else if (var3.equals("2")){ //Check
						admin.crearMalla();
		
					}

					else if (var3.equals("3")){
						System.out.println("Cuanto es el nuevo máximo de creditos por semestre?");
						int max = user_input.nextInt();
						maxCreditosSemestre = max ;
					}

					else if (var3.equals("4")){
						System.out.println("Cuanto es el nuevo máximo de creditos reprobados?");
						int max = user_input.nextInt();
						maxCreditosReprobados = max ;
					}

					else{
						System.out.println("Error");
					}
				}
			}
		}

		else{
			System.out.println("ERROR");
		}


		//Revisar si coinciden las claves

		administrador admin = new administrador ("Nahum", 84, true, "777777");




	}

}
