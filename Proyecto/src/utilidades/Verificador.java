package utilidades;
import backend.*;

public class Verificador {
	
	public boolean contraseñaCorrectaAlumno(Alumno x, String contraseña){		
		return contraseña.equals(x.contraseña);
	}
	
	public boolean contraseñaCorrectaAdmin(Administrador x, String contraseña){		
		return contraseña.equals(x.contraseña);
	}

}
