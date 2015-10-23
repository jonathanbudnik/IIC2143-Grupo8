package paquete.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class CrearMallaController {

    // Reference to the main application.
    private MainApp mainApp;

    public CrearMallaController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField nombre;
    @FXML
    public TextField numero;
    @FXML
    public GridPane panel;
    @FXML
    public Button crear1;
    
    
    public ArrayList lista = new ArrayList();
    public ArrayList lista1 = new ArrayList();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleCrearMalla1Action(ActionEvent event) throws IOException {
    	int i = Integer.parseInt(numero.getText());
    	int j = 0;
        while (j < i){
        	Label label = new Label("Curso" + (j+1) + ":");
        	TextField tf = new TextField();
        	panel.addRow(j+3, label, tf);
        	j++;
        	lista.add(tf);
        }
        Button b = new Button("Enviar");
        b.setOnAction (new EventHandler<ActionEvent>(){
        	@Override public void handle(ActionEvent event) {
        	    try {
        	    	int j=0;
        	    	for(j=0;j<i;j++){
        	    		lista1.add(((TextField) lista.get(j)).getText());
        	    	}
        	    	MainApp.admin.crearMalla(nombre.getText(), lista1);
        	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAdmin.fxml"));
        	        Parent root1 = (Parent) fxmlLoader.load();
        	        Stage stage = new Stage();
        	        stage.setScene(new Scene(root1));  
        	        stage.setTitle("Menú Admin");
        	        stage.show();
        	        ((Node)(event.getSource())).getScene().getWindow().hide();
        	    } 
        	    catch(Exception e) {
        	    e.printStackTrace();
        	    }
        	}
        });
        panel.add(b, 1, i+3);
    }
}