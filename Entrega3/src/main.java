import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class main {

	public static void main(String[] args) throws IOException {

		Scanner user_input = new Scanner( System.in );
		serializador s = new serializador();
		texto t = new texto();
		
		//Variables booleanas que sirven para ordenar el flujo del programa
		boolean salir1 = false ;
		boolean salir2 = false ;
		boolean salir3 = false ;
		
		while(!salir1){
						
			System.out.println("Bienvenido! Eres un: \n(1) Alumno \n(2) Administrador \n(3) Salir");
			String var1 = user_input.next();

			if (var1.equals("1")) {

				System.out.println("(1) Ingresar \n(2) Crear cuenta");
				String var2 = user_input.next();
				
				if (var2.equals("1")){
					System.out.println("Rut del usuario:");
					String rut= user_input.next();
					System.out.println("Contraseña:");
					String password = user_input.next();
					alumno alum = null;
					try{
					alum = s.obtenerAlumno(rut); //Obtengo el alumno guardado en el archivo según el rut ingresado.
					}
					catch (IOException e){
						System.out.println("Rut no existente");
					}
					

					if (true){ //En vez del true debería ir una verificación de la contraseña, se implementará para la próxima entrega.
						
						System.out.println("Bienvenido "+alum.nombre+"!");
							
						while(!salir2){

							System.out.println("¿Que deseas hacer?\n(1) Ver carga académica \n(2) Buscar curso \n(3) Crear nuevo semestre \n(4) Poner notas\n(5) Ver mi malla\n(6) Salir");
							String var3 = user_input.next();
							if (var3.equals("1")){ 
								alum.verCargaAcademica();					
							}

							else if (var3.equals("2")){ 
								alum.buscarCurso();
							}

							else if (var3.equals("3")){ 
								alum.carga.agregarCursos();
							}

							else if (var3.equals("4")){
								alum.carga.ponerNota();
							}

							else if (var3.equals("5")){ 
								t.leer(alum.carrera.toLowerCase()+".txt");
							}

							else if(var3.equals("6")){
								salir2 = true;
							}

							else{
								System.out.println("Opción inválida");
							}
						}
						s.guardarAlumno(alum); //Se guarda la información del alumno luego de las modificaciones.
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

					alumno nuevoAlumno = new alumno(Nombre, Edad, EsHombre, Rut, Carrera); //Se crea un nuevo alumno
					try { //Se guarda en un archivo
						s.guardarAlumno(nuevoAlumno);
						System.out.println("Alumno creado con éxito");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}

			else if (var1.equals("2")){
				System.out.println("(1) Ingresar \n(2) Crear cuenta");
				String var2 = user_input.next();

				if (var2.equals("1")){

					System.out.println("Rut:");
					String rut= user_input.next();
					System.out.println("Contraseña:");
					String password = user_input.next();

					if (true){ //En vez del true debería ir una verificación de la contraseña, se implementará para la próxima entrega.

						administrador admin = new administrador("Nahum",50,true,"183949547"); //Se utiliza un administrador standar. Lo unico relevante es la verificación de la contraseña.

						while(!salir3){
							System.out.println("(1) Crear un curso \n(2) Crear una malla \n(3) Cambiar máximo créditos por semestre \n(4) Cambiar máximo creditos reprobados \n(5) Salir");
							String var3 = user_input.next(); 
							if (var3.equals("1")){
								admin.agregarCurso();			
							}

							else if (var3.equals("2")){ 
								admin.crearMalla();
							}

							else if (var3.equals("3")){
								admin.fijarMaximoCreditos();
							}

							else if (var3.equals("4")){
								admin.fijarMaximoCreditosReprobados();
							}

							else if (var3.equals("5")){
								salir3 = true ;
							}

							else{
								System.out.println("Opción inválida");
							}
						}
					}
				}
			}

			else if (var1.equals("3")){
				salir1 = true;
			}

			else{
				System.out.println("Opcion invalida");
			}
		}
	}
}
