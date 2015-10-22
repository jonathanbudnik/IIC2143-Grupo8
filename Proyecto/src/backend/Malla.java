package backend;

import utilidades.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



public class Malla implements Serializable{
	
	java.util.ArrayList siglas ;
	String nombre;
	static Texto t = new Texto();
	
	public Malla(String Nombre){
		this.nombre = Nombre;
		this.siglas = t.retornarLista(Nombre.toLowerCase()+".txt");		
	}
	
	public String obtenerMalla(){
		String s = "";
		
		for (int i=0 ; i < this.siglas.size() ; i++){
			s+=this.siglas.get(i);
			s+="\n";
		}
		
		return s;		
	}
}
