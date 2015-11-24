package paquete.view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import paquete.MainApp;

public class EditarRamoController {

    // Reference to the main application.
    private MainApp mainApp;

    public EditarRamoController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField texto;
    @FXML
    public TextField texto1;
    @FXML
    public TextField texto2;
    @FXML
    public TextField texto3;
    @FXML
    public TextField texto4;
    @FXML
    public TextField texto5;
    @FXML
    public TextField texto6;
    @FXML
    public TextField texto7;
    @FXML
    public TextField texto8;
    @FXML
    public TextField texto9;
    @FXML
    public TextField texto10;
    @FXML
    public TextField texto11;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleEditarAction(ActionEvent event) {
    	try {
    		String cursos = MainApp.admin.buscarCurso(texto.getText().toString().toLowerCase());
    		String[] atributos = cursos.split("-");
    		texto1.setText(atributos[0]);
    		texto2.setText(atributos[1]);
    		texto3.setText(atributos[2]);
    		texto4.setText(atributos[3]);
    		texto5.setText(atributos[4]);
    		texto6.setText(atributos[5]);
    		texto7.setText(atributos[6]);
    		texto8.setText(atributos[7]);
    		texto9.setText(atributos[8]);
    		texto10.setText(atributos[9]);
    		texto11.setText(atributos[10]);
    		texto.setEditable(false);
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    @FXML
    private void handleEditarProgramaAction(ActionEvent event) {
    	try {
    		File file = new File(MainApp.verificador.retornarCursoSegunId(texto.getText().toString()).getSigla().toLowerCase() + "/programa.txt");
    		Desktop.getDesktop().open(file);
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    @FXML
    private void handleEditarRamoAction(ActionEvent event) {
    	try {
    		MainApp.admin.eliminarCurso(texto.getText().toString().toLowerCase());
    		MainApp.admin.agregarCurso(texto1.getText(), texto2.getText(), texto3.getText(), texto4.getText(), texto5.getText().split(",")[0], texto5.getText().split(",")[1], texto6.getText(), texto7.getText(), texto8.getText(), texto9.getText(), texto10.getText(), texto11.getText());
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