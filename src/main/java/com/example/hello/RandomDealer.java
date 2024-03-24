package com.example.hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RandomDealer implements Initializable {

    @FXML
    private AnchorPane random_anc;

    @FXML
    private TableView<dealer> dealerTable;

    @FXML
    private TableColumn<dealer, String> dealerID;

    @FXML
    private TableColumn<dealer, String> dealerName;

    @FXML
    private TableColumn<dealer, String> contact;

    @FXML
    private TableColumn<dealer, String> location;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        List<dealer> selectedDealers = menu.randomDealers;

        ObservableList<dealer> dealerView = FXCollections.observableArrayList(selectedDealers);

        dealerID.setCellValueFactory(new PropertyValueFactory<dealer, String>("dealerID"));
        dealerName.setCellValueFactory(new PropertyValueFactory<dealer, String>("dealerName"));
        contact.setCellValueFactory(new PropertyValueFactory<dealer, String>("phone"));
        location.setCellValueFactory(new PropertyValueFactory<dealer, String>("location"));



        dealerTable.setItems(dealerView);
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(menu.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) random_anc.getScene().getWindow();
        currentStage.close();
    }
}
