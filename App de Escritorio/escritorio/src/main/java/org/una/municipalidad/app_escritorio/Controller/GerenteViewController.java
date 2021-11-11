package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
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
    private JFXButton BtnAutorizar;

    @FXML
    private BorderPane BorderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }


    public void OnActionBtnAutorizar(ActionEvent actionEvent) {
        loadUI("AutorizarView",BorderPane);
    }
}
