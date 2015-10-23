package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.Serializador;
import paquete.model.Alumno;

public class CrearAlumnoController {

    // Reference to the main application.
    private MainApp mainApp;

    public CrearAlumnoController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField TextoNombre;
    @FXML
    public TextField TextoEdad;
    @FXML
    public TextField TextoSexo;
    @FXML
    public TextField TextoRut;
    @FXML
    public TextField TextoCarrera;
    @FXML
    public TextField TextoContraseña;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleRegistrarAction(ActionEvent event) {
    	if (! TextoNombre.getText().trim().isEmpty() && ! TextoEdad.getText().trim().isEmpty() && ! TextoSexo.getText().trim().isEmpty() && ! TextoRut.getText().trim().isEmpty() && ! TextoCarrera.getText().trim().isEmpty() && ! TextoContraseña.getText().trim().isEmpty()) {
    		try {
    			Alumno a = new Alumno(TextoNombre.getText(),Integer.parseInt(TextoEdad.getText()),true,TextoRut.getText(),TextoCarrera.getText(),TextoContraseña.getText());
    			MainApp.serializador.guardarAlumno(a);
    			MainApp.accesoAlumno(a.rut);
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
    			Parent root1 = (Parent) fxmlLoader.load();
    			Stage stage = new Stage();
    			stage.setScene(new Scene(root1));  
    			stage.setTitle("Crear Nuevo Semestre");
    			stage.setX(700);
    			stage.setY(250);
    			stage.show();
    			
    			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("BuscadorDeCursos.fxml"));
    			Parent root2 = (Parent) fxmlLoader1.load();
    			Stage stage1 = new Stage();
    			stage1.setScene(new Scene(root2));  
    			stage1.setTitle("Buscador de Cursos");
    			stage1.setX(250);
    			stage1.setY(250);
    			stage1.show();
    			((Node)(event.getSource())).getScene().getWindow().hide();
    		} 
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
}