package paquete;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paquete.model.Administrador;
import paquete.model.Alumno;
import paquete.model.Curso;

public class MainApp extends Application {

    private Stage primaryStage;
    public static Serializador serializador = new Serializador();
    public static Alumno alumno;
    public static Verificador verificador = new Verificador();
    public static Texto texto = new Texto();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showInicio0();    
    }


    
    public void showInicio0() {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/SplashScreen.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("RENNAB");
            stage.show();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
    
    public static void accesoAlumno(String rut) throws FileNotFoundException, IOException{
    	alumno = serializador.obtenerAlumno(rut);
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}