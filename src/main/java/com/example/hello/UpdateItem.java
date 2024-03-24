package com.example.hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class UpdateItem {


    @FXML
    public Button select;

    @FXML
    public Button back;

    @FXML
    public AnchorPane up_anc;

    @FXML
    public TextField upLable;


    public void onSelButtonClick() throws IOException {

        int code = Integer.parseInt(upLable.getText().trim());
        List<Object> selectedItem = updateItem(code);

        if( selectedItem != null){


            FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("UPDATE2.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
            stage.setTitle("UPDATE ITEMS");
            stage.setScene(scene);
            stage.show();

            UpdateItem2 controller = fxmlLoader.getController();
            controller.setSelectedItem(selectedItem);

            Stage currentStage = (Stage) up_anc.getScene().getWindow();
            currentStage.close();
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("item_del2_popup_msg.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();
        }
    }

    public List<Object> updateItem(int findCode){
        for (List<Object> item : AddItems.itemList) {

            int item_Code = (int) item.get(0);
            if (item_Code == findCode) {
                return item;
            }
        }
        return null;

    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) up_anc.getScene().getWindow();
        currentStage.close();
    }

}
