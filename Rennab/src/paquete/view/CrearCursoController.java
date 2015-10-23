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

public class CrearCursoController {

    // Reference to the main application.
    private MainApp mainApp;

    public CrearCursoController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField TextoNombre;
    @FXML
    public TextField TextoSigla;
    @FXML
    public TextField TextoId;
    @FXML
    public TextField TextoSala;
    @FXML
    public TextField TextoProfesor;
    @FXML
    public TextField TextoAño;
    @FXML
    public TextField TextoSemestre;
    @FXML
    public TextField TextoSeccion;
    @FXML
    public TextField TextoCreditos;
    @FXML
    public TextField TextoDepartamento;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleCrearAction(ActionEvent event) {
    	if (! TextoNombre.getText().trim().isEmpty() && ! TextoSigla.getText().trim().isEmpty() && ! TextoProfesor.getText().trim().isEmpty() && ! TextoSala.getText().trim().isEmpty() && ! TextoAño.getText().trim().isEmpty() && ! TextoSemestre.getText().trim().isEmpty() && ! TextoSeccion.getText().trim().isEmpty() && ! TextoCreditos.getText().trim().isEmpty() && ! TextoDepartamento.getText().trim().isEmpty() && ! TextoId.getText().trim().isEmpty()) {
    		try {
    			MainApp.admin.agregarCurso(TextoSigla.getText(), TextoNombre.getText(), TextoProfesor.getText(), TextoSala.getText(), TextoAño.getText(), TextoSemestre.getText(), TextoSeccion.getText(), TextoCreditos.getText(), TextoDepartamento.getText(), "id" +  TextoId.getText());
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAdmin.fxml"));
    			Parent root1 = (Parent) fxmlLoader.load();
    			Stage stage = new Stage();
    			stage.setScene(new Scene(root1));  
    			stage.setTitle("Menú Administrador");
    			stage.show();
    			((Node)(event.getSource())).getScene().getWindow().hide();
    		} 
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
}