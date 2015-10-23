package paquete.view;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class CalificarSemestreController {

    // Reference to the main application.
    private MainApp mainApp;

    public CalificarSemestreController() {
    }

    @FXML
    private void initialize() {
    	actualizarPantalla();
    }
    @FXML
    public GridPane Panel;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    public ArrayList lista = new ArrayList();
    public ArrayList lista1 = new ArrayList();
    @FXML
    public void actualizarPantalla(){
    	int i = MainApp.alumno.cantidadCursosUltimoSemestre();
        int j = 0;
        while (j < i){
        	Label lab = new Label(MainApp.alumno.nombresUltimoSemestre().get(j).toString());
        	TextField tex = new TextField();
        	Panel.addRow(j, lab, tex);
        	j++;
        	lista.add(tex);
        }
        Button but = new Button("Enviar");
        but.setOnAction (new EventHandler<ActionEvent>(){
    		@Override public void handle(ActionEvent event) {
    	    	try {
    	    		int j=0;
    	    		for(j=0;j<i;j++){
    	    			lista1.add(Double.parseDouble(((TextField) lista.get(j)).getText()));
    	    		}
    	    		MainApp.alumno.cerrarSemestre(lista1);
    	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
    	            Parent root1 = (Parent) fxmlLoader.load();
    	            Stage stage = new Stage();
    	            stage.setScene(new Scene(root1));  
    	            stage.setTitle("Crear Semestre");
    	            stage.setX(850);
        			stage.setY(250);
    	            stage.show();
    	            
    	            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("BuscadorDeCursos.fxml"));
        			Parent root2 = (Parent) fxmlLoader1.load();
        			Stage stage1 = new Stage();
        			stage1.setScene(new Scene(root2));  
        			stage1.setTitle("Buscador de Cursos");
        			stage1.setX(100);
        			stage1.setY(250);
        			stage1.show();
        			((Node)(event.getSource())).getScene().getWindow().hide();
    	        } 
    	    	catch(Exception e) {
    	        e.printStackTrace();
    	    	}
    	    }
    	});
        Panel.setHalignment(but,HPos.RIGHT);
        Panel.addRow(i, but);
    }
}