import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializador {

	public void guardarAlumno(alumno a) throws IOException{
		ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(a.rut+".bin")) ;
		oos.writeObject(a);
	}

	public alumno obtenerAlumno(String rut) throws FileNotFoundException, IOException{
		alumno alumnoObtenido = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rut+".bin"));
		try {
			alumnoObtenido = (alumno) ois.readObject();
		} 
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return alumnoObtenido;

	}
}
