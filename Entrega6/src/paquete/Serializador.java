package paquete;
import paquete.model.Administrador;
import paquete.model.Alumno;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {

	public void guardarAlumno(Alumno x) throws IOException{
		ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(x.rut+".bin")) ;
		oos.writeObject(x);
	}
	public Alumno obtenerAlumno(String rut) throws FileNotFoundException, IOException{
		Alumno alumnoObtenido = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rut+".bin"));
		try {
			alumnoObtenido = (Alumno) ois.readObject();
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return alumnoObtenido;
	}
	public void guardarAdministrador(Administrador x) throws IOException{
		ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(x.rut+".bina")) ;
		oos.writeObject(x);
	}

	public Administrador obtenerAdministrador(String rut) throws FileNotFoundException, IOException{
		Administrador adminObtenido = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rut+".bina"));
		try {
			adminObtenido = (Administrador) ois.readObject();
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return adminObtenido;
	}
}