package paquete.model;
import java.util.ArrayList;
import paquete.Texto;

public class Administrador extends Persona{
	
	static Texto t = new Texto();
	
	public Administrador (String Nombre, int Edad, boolean EsHombre, String Rut, String Contraseña){
		super(Nombre,Edad, EsHombre, Rut, Contraseña);
	}
	
	public void agregarCurso(String Sigla,String Nombre,String Profesor,String Sala, String Año, String Semestre, String Seccion, String Id){
		String nuevoCurso = Sigla+"-"+Nombre+"-"+Profesor+"-"+Sala+"-"+(Año)+"-"+(Semestre)+"-"+(Seccion)+"-"+(Id);
		t.agregarTexto("CatalogoCursos.txt", nuevoCurso);
	}
	
	public void eliminarCurso(String id){
		t.eliminarLinea("CatalogoCursos.txt", id);
			
	}
	
	public void crearMalla(String nombre, ArrayList siglas){
		
		String malla = "";
		for (int i=0; i<siglas.size(); i++){
			String sigla = (String) siglas.get(i);
			malla+=sigla;
			malla+="\n";
		}
		String nombreArchivo = nombre+".txt";
		t.escribirDesdeCero(nombreArchivo, malla);

	}
	
	public void agregarRamoMalla(String nombreMalla, String sigla){
		String nombreArchivo = nombreMalla+".txt";
		t.agregarTexto(nombreArchivo,sigla);
	}
	
	public void eliminarRamoMalla(String nombreMalla, String sigla){
		String nombreArchivo = nombreMalla+".txt";
		t.eliminarLinea(nombreArchivo, sigla);
		
	}
	
	public void fijarMaximoCreditos(String max){
		t.escribirDesdeCero("maxCreditosSemestre.txt", max);

	}

	public void fijarMaximoCreditosReprobados(String max){
		t.escribirDesdeCero("maxCreditosReprobados.txt", max);
	}
}