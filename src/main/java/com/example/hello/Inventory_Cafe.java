package com.example.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Inventory_Cafe extends Application {



    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(menu.class.getResource("startup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 445);
        stage.setTitle("Jhon's Internet Cafe");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {

        launch();
    }
}
