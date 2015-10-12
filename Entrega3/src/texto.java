import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class texto {
	
	public void leer(String nombreArchivo){
		try{
			FileReader r = new FileReader(nombreArchivo);
			BufferedReader buffer = new BufferedReader(r) ;
			
			String linea = "";
			
			while(linea!=null){
				linea = buffer.readLine();
				if (linea==null){
					break;
				}
				System.out.println(linea);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String retornarTexto(String nombreArchivo){
		
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
				//System.out.println(linea);
				texto+="\n" ;
				texto+=linea;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return texto ;
		
	}
	
	public void escribir(String nombreArchivo, String textoNuevo){
		File f = new File (nombreArchivo);
		String textoViejo = this.retornarTexto(nombreArchivo) ;
		try{
			FileWriter w = new FileWriter (f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw) ;
			wr.append(textoViejo);
			wr.append("\n"+textoNuevo) ;
			wr.close();
			bw.close();
			
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
					retorno = linea ; 
				}
			}
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			return retorno;
		}
}
