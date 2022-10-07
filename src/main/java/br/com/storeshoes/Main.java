package br.com.storeshoes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FxmlCadastroProduto.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Sistema de cadastro de produtos!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
}
