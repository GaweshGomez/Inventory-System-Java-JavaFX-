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

public class    RandomDealerDetails implements Initializable {
    public static List<List<Object>> dealerItem = RandomDealer2.dealerItem;

    @FXML
    private AnchorPane random_anc;

    @FXML
    private TableView<DealerItems> itemDetails;

    @FXML
    private TableColumn<DealerItems, String> itemName;

    @FXML
    private TableColumn<DealerItems, String> itemBrand;

    @FXML
    private TableColumn<DealerItems, String> itemPrice;

    @FXML
    private TableColumn<DealerItems, String> itemStock;




    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RandomDealer2.class.getResource("RANDOM_DEALER_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("CHECK DEALER");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) random_anc.getScene().getWindow();
        currentStage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemName.setCellValueFactory(new PropertyValueFactory<DealerItems, String>("dddname"));
        itemBrand.setCellValueFactory(new PropertyValueFactory<DealerItems, String>("dddbrand"));
        itemPrice.setCellValueFactory(new PropertyValueFactory<DealerItems, String>("dddprice"));
        itemStock.setCellValueFactory(new PropertyValueFactory<DealerItems, String>("dddquantity"));
        ObservableList<DealerItems> dItems = FXCollections.observableArrayList();
        for (List<Object> oneItem: dealerItem){
            DealerItems item = new DealerItems(
                    (String) oneItem.get(0),
                    (String) oneItem.get(1),
                    (String) oneItem.get(2),
                    (String) oneItem.get(3)
            );
            dItems.add(item);
        }
        itemDetails.setItems(dItems);
        dealerItem.clear();
    }
}
