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

    @FXML
    private VBox vbxMenuIzq;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbxMenuIzq.setPrefWidth(20);
        /*btnOverview.setVisible(false);
        btnCustomers.setVisible(false);
        btnMenus.setVisible(false);
        btnPackages.setVisible(false);
        btnSettings.setVisible(false);
        btnSignout.setVisible(false);*/
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
        if (actionEvent.getSource() == btnPackages) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/IngresarLicencia.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        if (actionEvent.getSource() == btnSettings) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/IngresarLocalMercado.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnMenus) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/IngresarPropiedad.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize() {

    }


    public void OnMouseEnteredIzq(MouseEvent mouseEvent) {
        vbxMenuIzq.setPrefWidth(256);

    }

    public void OnMouseExitedIzq(MouseEvent mouseEvent) {
        vbxMenuIzq.setPrefWidth(20);
    }
}
