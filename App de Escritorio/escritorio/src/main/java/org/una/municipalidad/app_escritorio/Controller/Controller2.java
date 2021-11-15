package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.FlowController;

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
    private Button btnActualizar;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnContri;

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox vbxMenuIzq;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblRol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbxMenuIzq.setPrefWidth(20);
        lblUsuario.setText(String.valueOf(AppContext.getInstance().get("usuario")));
        lblRol.setText(String.valueOf(AppContext.getInstance().get("roles")));
    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnItems.getChildren().clear();
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
            pnItems.getChildren().clear();
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
            pnItems.getChildren().clear();
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
            pnItems.getChildren().clear();
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
            pnItems.getChildren().clear();
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

        if (actionEvent.getSource() == btnActualizar) {
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/Actualizar.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnContri) {
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            System.out.println("ober");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/ContribuyenteXImpuesto.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (actionEvent.getSource() ==   btnCerrarSesion) {
            pnItems.getChildren().clear();
            ((Stage) btnCerrarSesion.getScene().getWindow()).close();
            FlowController.getInstance().goViewInWindow("Loggin");
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
