package com.project.mazmorrita_project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestEliminaralfinalizarelproyecto extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TestEliminaralfinalizarelproyecto.class.getResource("TestImagen_EJEMPLO.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



/*
    public void initialize() {
        // Ruta de la imagen
        String imagePath = "src/main/resources/Images/Characters/barbaro.jpg";

        // Cargar la imagen desde la ruta
        Image image = new Image("file:" + imagePath);

        // Establecer la imagen en el ImageView
        imageView.setImage(image);
    }
*/






