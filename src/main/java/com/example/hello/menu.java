package com.example.hello;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;

import static com.example.hello.AddItems.itemList;


public class menu {

    public static List<dealer> randomDealers;
    @FXML
    public AnchorPane add_anc;

    @FXML
    public AnchorPane startup_anc;


    @FXML
    public AnchorPane menuanc;

    @FXML
    public Button view_bb;






    public void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) startup_anc.getScene().getWindow();
        currentStage.close();
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("startup.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("ONE-NET CAFE");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    public void onAddButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("ADD_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("ADD ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    public void onDelButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("DELETE_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("DELETE ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    public void onUpButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("UPDATE_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("UPDATE ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    public void onViewButtonClick() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("VIEW_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 750, 510);
        stage.setTitle("VIEW ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();

    }

    public void onSaveButtonClick() {
        try {
            String fileName = "item_details.txt";
            //BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            FileOutputStream fiLeOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fiLeOut);

            for (List<Object> item : itemList) {
                objectOut.writeObject(item);
            }

            objectOut.close();

            FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("item_save_popup_msg.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public String formatItemString(List<Object> item) {
        StringBuilder sb = new StringBuilder();
        for (Object value : item) {
            sb.append(value).append(" || ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }



    public void onSelectButtonclick() throws IOException {


        List<dealer> allDealers = DealerReader.readDealersFromFile();
        randomDealers = SelectDealer.getRandomDealers(allDealers, 4);

        System.out.println("Selected and Sorted Dealers:");
        for (com.example.hello.dealer dealer : randomDealers) {
            System.out.println("Dealer ID: " + dealer.getDealerID());
            System.out.println("Dealer Name: " + dealer.getDealerName());
            System.out.println("Phone: " + dealer.getPhone());
            System.out.println("Location: " + dealer.getLocation());
            System.out.println("------------------------------------");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("selectedMsg.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 450, 150);
        stage.setTitle("SELECTED");
        stage.setScene(scene);
        stage.show();



    }



    public void onDis1ButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(menu.class.getResource("RANDOM_DEALERS.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("RANDOMLY SELECTED DEALERS DETAILS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }


    public void onDis2ButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inventory_Cafe.class.getResource("RANDOM_DEALER_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("RANDOMLY SELECTED DEALERS ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }




    public void onExitButtonClick(ActionEvent event) {

        Platform.exit();
        System.out.println("Thankyou for using John's Inventory Cafe!!!");
    }


    public List<dealer> getRandomDealers(int i) {

        return null;
    }
}

