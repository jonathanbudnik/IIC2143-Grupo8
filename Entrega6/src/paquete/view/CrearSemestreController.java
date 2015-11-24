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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.model.Curso;

public class CrearSemestreController {

    // Reference to the main application.
    private MainApp mainApp;

    public CrearSemestreController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField CursosATomar;
    @FXML
    public GridPane PanelPrincipal;
    @FXML
    public Button Boton;
    @FXML
    public Label Label;
    
    
    public ArrayList lista = new ArrayList();
    public ArrayList lista1 = new ArrayList();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleCursosATomarAction(ActionEvent event) throws IOException {
    	PanelPrincipal.getChildren().clear();
    	PanelPrincipal.addRow(0, Label, CursosATomar);
    	PanelPrincipal.add(Boton, 1, 0);
    	int i = Integer.parseInt(CursosATomar.getText());
    	if (i*10<=MainApp.verificador.maximoCreditosSemestre() | (i*10<=MainApp.verificador.maximoCreditosSemestre()+10 & MainApp.alumno.calcularPromedio()>=MainApp.verificador.notaExcelencia())){
    		int j = 0;
        	while (j < i){
        		Label label = new Label("Curso" + (j+1) + ":");
        		TextField tf = new TextField();
        		PanelPrincipal.addRow(j+1, label, tf);
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
        	    		ArrayList cursos = MainApp.verificador.convertirIdsCursos(lista1);
        	    		for(int h = 0;h<cursos.size();h++){
        	    			if (!MainApp.alumno.puedeTomarElRamo(((Curso) (cursos.get(h))).getSigla())){
        	    				Alert alert = new Alert(AlertType.WARNING);
            	    			alert.setTitle("Alerta");
            	    			alert.setHeaderText(null);
            	    			alert.setContentText("No cumple con el/los requisitos del curso: " + ((Curso) (cursos.get(h))).getSigla());
            	    			alert.showAndWait();
            	    			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
            	                Parent root2 = (Parent) fxmlLoader1.load();
            	                Stage stage1 = new Stage();
            	                stage1.setScene(new Scene(root2));  
            	                stage1.setTitle("Crar Nuevo Semestre");
            	                stage1.setX(850);
            	    			stage1.setY(250);
            	                stage1.show();
            	                ((Node)(event.getSource())).getScene().getWindow().hide();
            	    			return;
        	    			}
        	    		}
        	    		if (!MainApp.verificador.hayTope(MainApp.verificador.verificarTopeHorario(cursos))){
        	    			MainApp.alumno.crearSemestre(cursos);
            	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAlumno.fxml"));
            	            Parent root1 = (Parent) fxmlLoader.load();
            	            Stage stage = new Stage();
            	            stage.setScene(new Scene(root1));  
            	            stage.setTitle("Menú Alumno");
            	            stage.show();
            	            ((Node)(event.getSource())).getScene().getWindow().hide();
        	    		}
        	    		else{
        	    			Alert alert = new Alert(AlertType.WARNING);
        	    			alert.setTitle("Alerta");
        	    			alert.setHeaderText(null);
        	    			alert.setContentText("Tope de horario en: "+MainApp.verificador.verificarTopeHorario(cursos));
        	    			alert.showAndWait();
        	    			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
        	                Parent root2 = (Parent) fxmlLoader1.load();
        	                Stage stage1 = new Stage();
        	                stage1.setScene(new Scene(root2));  
        	                stage1.setTitle("Crar Nuevo Semestre");
        	                stage1.setX(850);
        	    			stage1.setY(250);
        	                stage1.show();
        	                ((Node)(event.getSource())).getScene().getWindow().hide();
        	    		}
        	        } 
        	    	catch(Exception e) {
        	        e.printStackTrace();
        	    	}
        	    }
        	});
        	PanelPrincipal.add(b, 1, i+1);
    	}
    	else {
    		if (MainApp.alumno.calcularPromedio()<MainApp.verificador.notaExcelencia()){
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Alerta");
    			alert.setHeaderText(null);
    			alert.setContentText("Ha supereado el máximo de créditos a inscribir ("+MainApp.verificador.maximoCreditosSemestre()+")");
    			alert.showAndWait();
    		}
    		else{
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Alerta");
    			alert.setHeaderText(null);
    			alert.setContentText("Ha supereado el máximo de créditos a inscribir ("+(MainApp.verificador.maximoCreditosSemestre()+10)+")");
    			alert.showAndWait();
    		}
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
            Parent root2 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root2));  
            stage1.setTitle("Crar Nuevo Semestre");
            stage1.setX(850);
			stage1.setY(250);
            stage1.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
		}
    }
}