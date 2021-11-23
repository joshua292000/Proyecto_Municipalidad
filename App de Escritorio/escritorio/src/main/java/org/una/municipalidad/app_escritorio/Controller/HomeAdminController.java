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

public class HomeAdminController extends Controller implements Initializable {

    @FXML
    private Pane pnlOverview;

    @FXML
    private VBox vbxMenuIzq;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblRol;

    @FXML
    private Label lblNombePantalla;

    @FXML
    private VBox pnItems = null;

    @FXML
    private Button btnAutorzizar;

    @FXML
    private Button btnParametros;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnDesarrollo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblUsuario.setText(String.valueOf(AppContext.getInstance().get("usuario")));
        lblRol.setText(AppContext.getInstance().quitarRol(String.valueOf(AppContext.getInstance().get("roles"))));


    }

    @Override
    public void initialize() {
        if (Controller.getPantallas()==1){
            lblNombePantalla.setText("Pantalla Gestor");
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/Home.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (Controller.getPantallas()==2){
            lblNombePantalla.setText("Pantalla Gerente");
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/GerentesView.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (Controller.getPantallas()==3){
            lblNombePantalla.setText("Pantalla Auditor");
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/AuditorView.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void OnMouseEnteredIzq(MouseEvent mouseEvent) {

    }

    public void OnMouseExitedIzq(MouseEvent mouseEvent) {

    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnAutorzizar) {
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/AutorizarRoles.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnParametros) {
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/CrearParametros.fxml"));
                pnItems.getChildren().add(nodes[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (actionEvent.getSource() == btnDesarrollo) {
            pnItems.getChildren().clear();
            pnlOverview.setStyle("-fx-background-color : #02030A");
            Node[] nodes = new Node[1];
            try {
                nodes[0] =  FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/OpcionesDesarrollo.fxml"));
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
}
