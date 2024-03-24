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

public class DeleteItem {

    @FXML
    public Button back_bb;

    @FXML
    public AnchorPane del_anc;

    @FXML
    public TextField deleteField;


    public void onDeleteButtonClick() throws IOException{

        int code = Integer.parseInt(deleteField.getText().trim());
        if(AddItems.itemList != null){
            deleteItem(code);
        }
        else {

            FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("error_del.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();

        }
    }

    public void deleteItem(int code) throws IOException {
        for (List<Object> item : AddItems.itemList){
            int itemCode = (int) item.get(0);
            if (itemCode == code){
                AddItems.itemList.remove(item);

                FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("item_del_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

                deleteField.clear();
            }

            else {
                FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("item_del2_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

                deleteField.clear();

            }
        }
    }

    public  void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) del_anc.getScene().getWindow();
        currentStage.close();
    }
}
