package paquete.view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class BuscadorDeCursosController {

    // Reference to the main application.
    private MainApp mainApp;

    public BuscadorDeCursosController() {
    }

    @FXML
    private void initialize() {
    	actualizarPantalla();
    }
    @FXML
    public ComboBox<String> comboBox;
    @FXML
    public TextField texto;
    @FXML
    public Label texto1;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleBuscarAction(ActionEvent event) {
    	try {
    		if (MainApp.alumno != null)
    			texto1.setText(MainApp.alumno.buscarCurso(texto.getText()));
    		else
    			texto1.setText(MainApp.admin.buscarCurso(texto.getText()));
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    @FXML
    public void actualizarPantalla(){
    	comboBox.getItems().addAll("Nombre Curso","Sigla Curso","Profesor","Departamento");
    }
}