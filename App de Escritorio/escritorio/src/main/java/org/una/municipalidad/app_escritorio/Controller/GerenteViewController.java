package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenteViewController extends Controller implements Initializable {

    @FXML
    private ImageView imgCobros;

    @FXML
    private ImageView imgAutorizar;

    @FXML
    private ImageView imgConsultas;

    @FXML
    private JFXButton btnAutorizar;

    @FXML
    private JFXButton btnConsultas;

    @FXML
    private JFXButton btnCobros;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private VBox Vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Vbox.setPrefWidth(20);
        btnAutorizar.setVisible(false);
        btnCobros.setVisible(false);
        btnConsultas.setVisible(false);
        imgCobros.setTranslateX(15);
        imgAutorizar.setTranslateX(15);
        imgConsultas.setTranslateX(15);
    }

    @Override
    public void initialize() {

    }


    public void OnActionBtnAutorizar(ActionEvent actionEvent) {
        loadUI("AutorizarView",BorderPane);
    }

    public void OnMouseEnteredVbox(MouseEvent mouseEvent) {
        Vbox.setPrefWidth(132);
        btnAutorizar.setVisible(true);
        btnCobros.setVisible(true);
        btnConsultas.setVisible(true);
        imgCobros.setTranslateX(0);
        imgAutorizar.setTranslateX(0);
        imgConsultas.setTranslateX(0);
    }

    public void OnMouseExitedVbox(MouseEvent mouseEvent) {
        Vbox.setPrefWidth(20);
        btnAutorizar.setVisible(false);
        btnCobros.setVisible(false);
        btnConsultas.setVisible(false);
        imgCobros.setTranslateX(15);
        imgAutorizar.setTranslateX(15);
        imgConsultas.setTranslateX(15);
    }

    public void OnActionbtnConsultas(ActionEvent actionEvent) {
        loadUI("ConsultasView",BorderPane);
        //loadUI("hola",BorderPane);
    }

    public void OnActionbtnCobros(ActionEvent actionEvent) {
    }
}
