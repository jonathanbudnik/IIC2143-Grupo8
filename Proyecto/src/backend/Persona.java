package backend;

import java.io.Serializable;

public class Persona implements Serializable{
	
	String nombre;
	int edad;
	boolean esHombre;
	public String rut;
	public String contraseña;
	
	public Persona(String Nombre, int Edad, boolean EsHombre, String Rut, String Contraseña){
		this.nombre = Nombre;
		this.edad = Edad;
		this.esHombre = EsHombre ;
		this.rut = Rut;
		this.contraseña = Contraseña ;
	}
	
}
