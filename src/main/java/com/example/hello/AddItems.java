package com.example.hello;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class    AddItems {

    @FXML
    public Button bk;

    @FXML
    public AnchorPane add_anc;

    @FXML
    public TextField itemCode;

    @FXML
    public TextField itemName;

    @FXML
    public TextField itemBrand;

    @FXML
    public TextField itemQuantity;

    @FXML
    public TextField itemCategory;

    @FXML
    public TextField date;

    @FXML
    public TextField itemPrice;
    public static List<List<Object>> itemList = new ArrayList<>();


    public void addButtonClick() throws IOException {

        if (!isAllFieldsFilled()) {
            errorMsg("Please fill all fields.");
            return;
        }

        List<Object> item = new ArrayList<>();

        try {
            int item_code = Integer.parseInt(itemCode.getText().trim());
            String item_name = itemName.getText();
            Object item_brand = itemBrand.getText();
            double item_price = Double.parseDouble(itemPrice.getText());
            int item_quantity = Integer.parseInt(itemQuantity.getText().trim());
            Object item_category = itemCategory.getText();
            Object item_p_date = date.getText();

            if (isValidInput(item_code, item_price, item_quantity)) {
                item.add(item_code);
                item.add(item_name);
                item.add(item_brand);
                item.add(item_price);
                item.add(item_quantity);
                item.add(item_category);
                item.add(item_p_date);


                for (List<Object> itemm : itemList) {
                    int existingItemCode = (int) itemm.get(0);
                    if (existingItemCode == item_code) {
                        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("error_add.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                        stage.setScene(scene);
                        stage.show();

                        return;

                    }
                }

                itemList.add(item);

                FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("item_add_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

                textClearFields();
            } else {
                errorMsg("Please enter correct numeric values for Item code,Price and Quantity.");
            }
        } catch (NumberFormatException e) {
            errorMsg("Please enter correct numeric values for Item code,Price and Quantity.");
            e.printStackTrace();
        }
    }

    private boolean isAllFieldsFilled() {
        return !itemCode.getText().trim().isEmpty()
                && !itemName.getText().isEmpty()
                && !itemBrand.getText().isEmpty()
                && !itemPrice.getText().isEmpty()
                && !itemQuantity.getText().isEmpty()
                && !itemCategory.getText().isEmpty()
                && !date.getText().isEmpty();
    }




    private boolean isValidInput(int code,double price, int quantity) {

        return price > 0 && quantity > 0 && code > 0;
    }



    private void textClearFields() {
        itemCode.clear();
        itemBrand.clear();
        itemName.clear();
        itemQuantity.clear();
        itemCategory.clear();
        itemPrice.clear();
        date.clear();

    }



    public  void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(menu.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) add_anc.getScene().getWindow();
        currentStage.close();
    }

    public void errorMsg(String erroMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(erroMessage);

        alert.showAndWait();
        alert.close();
    }
}


