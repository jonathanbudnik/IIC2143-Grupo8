package paquete;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Texto {

	public String leer(String nombreArchivo){

		String texto = "";

		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;

			String linea = "";

			while(linea!=null){
				linea = buffer.readLine();
				if (linea==null){
					break;
				}
				texto+=linea;
				texto+="\n";
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return texto;
	}

	public String leerPrimeraLinea(String nombreArchivo){ //Agregar

		String linea = "";

		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;
			linea = buffer.readLine();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return linea;
	}
	
	public void escribirDesdeCero(String nombreArchivo, String textoNuevo){
		File f = new File (nombreArchivo);
		try{
			FileWriter w = new FileWriter (f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw) ;
			wr.write(textoNuevo) ;
			wr.close();
			bw.close();

		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void agregarTexto(String nombreArchivo, String textoNuevo){
		File f = new File (nombreArchivo);
		String textoViejo = this.leer(nombreArchivo) ;
		try{
			FileWriter w = new FileWriter (f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw) ;
			wr.append(textoViejo);
			wr.append(textoNuevo) ;
			wr.close();
			bw.close();
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}


	public void eliminarLinea(String nombreArchivo, String borrar){

		String linea = "";
		String retorno = "";

		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;

			while(linea!=null){
				linea = buffer.readLine();
				if (linea==null){
					break;
				}

				else if (linea.indexOf(borrar)==-1) {
					retorno+=linea;
					retorno += "\n";

				}
			}

			this.escribirDesdeCero(nombreArchivo, retorno);
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}






	public String retornarLinea(String nombreArchivo, String palabraBuscada){

		String linea = "";
		String retorno = "";

		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;

			while(linea!=null){
				linea = buffer.readLine();
				if (linea==null){
					break;
				}

				else if (linea.toLowerCase().contains(palabraBuscada.toLowerCase())){
					retorno += linea ;
					retorno += "\n";
				}
			}
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return retorno;
	}


	public ArrayList retornarLista(String nombreArchivo){
		ArrayList lista = new ArrayList();

		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;

			String linea = "";

			while(linea!=null){
				linea = buffer.readLine();
				if (linea==null){
					break;
				}

				else{
					lista.add(linea);

				}
			}
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}


		return lista;



	}
}
