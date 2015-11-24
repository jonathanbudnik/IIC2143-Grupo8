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
    public ComboBox<String> comboBox1;
    @FXML
    public ComboBox<String> comboBox2;
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
    		if (comboBox2.getValue() != null)
    			if (MainApp.alumno != null)
    				texto1.setText(MainApp.alumno.buscarCursoPeriodo(texto.getText(),comboBox2.getValue().replace("-", ",")));
    			else
    				texto1.setText(MainApp.admin.buscarCursoPeriodo(texto.getText(),comboBox2.getValue().replace("-", ",")));
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    @FXML
    public void actualizarPantalla(){
    	comboBox1.getItems().addAll("Nombre Curso","Sigla Curso","Profesor","Departamento");
    	comboBox2.getItems().addAll("2015-2","2016-1","2016-2");
    }
}