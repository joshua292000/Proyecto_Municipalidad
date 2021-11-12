package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 extends Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;


    @FXML
    private Pane pnlOverview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       // }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/IngresarContribuyente.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (actionEvent.getSource() == btnMenus) {
           // pnlMenus.setStyle("-fx-background-color : #53639F");
            //pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/Item.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==btnOrders)
        {
         //   pnlOrders.setStyle("-fx-background-color : #464F67");
           // pnlOrders.toFront();
        }
    }

    @Override
    public void initialize() {

    }
}
