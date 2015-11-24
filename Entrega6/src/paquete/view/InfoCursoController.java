package paquete.view;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import paquete.MainApp;

public class InfoCursoController {

    // Reference to the main application.
    private MainApp mainApp;

    public InfoCursoController() {
    }

    @FXML
    private void initialize(){
    }
    
    @FXML
    public TextField texto;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleVerProgramaAction(ActionEvent event) {
    	try {
    		MainApp.sigla_temp = texto.getText().toString().toLowerCase();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VerPrograma.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Programa Curso");
            stage.show();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    
    @FXML
    private void handleVerForoAction(ActionEvent event) {
    	try {
    		MainApp.sigla_temp = texto.getText().toString().toLowerCase();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VerForo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Foro Curso");
            stage.show();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    
    @FXML
    private void handleSubirApuntesAction(ActionEvent event) {
    	try {
    		MainApp.sigla_temp = texto.getText().toString().toLowerCase();
    		FileChooser chooser = new FileChooser();
    		chooser.setTitle("Elegir archivo a subir");
    		String path = chooser.showOpenDialog(null).getPath();
    		Path pathFrom = Paths.get(path);
    		Path pathTo = Paths.get(MainApp.sigla_temp + "/apuntes", pathFrom.getFileName().toString());
    		Files.copy(pathFrom, pathTo);
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    
    @FXML
    private void handleVerApuntesAction(ActionEvent event) {
    	try {
    		MainApp.sigla_temp = texto.getText().toString().toLowerCase();
    		FileChooser chooser = new FileChooser();
    		chooser.setTitle("Abrir apunte");
    		File file = new File(MainApp.sigla_temp + "/apuntes");
    		chooser.setInitialDirectory(file);
    		File path = chooser.showOpenDialog(null);
    		Desktop.getDesktop().open(path);
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}