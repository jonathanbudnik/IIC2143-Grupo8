import java.io.Serializable;

public class persona implements Serializable{
	String nombre;
	int edad;
	boolean esHombre;
	String rut;
	
	public persona(String Nombre, int Edad, boolean EsHombre, String Rut){
		this.nombre = Nombre;
		this.edad = Edad;
		this.esHombre = EsHombre ;
		this.rut = Rut;
	}

}