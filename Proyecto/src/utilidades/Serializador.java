package utilidades;
import backend.*;

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
}
