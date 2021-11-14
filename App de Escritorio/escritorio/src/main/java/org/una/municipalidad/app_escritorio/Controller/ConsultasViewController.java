package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultasViewController extends Controller implements Initializable {
    @FXML
    private Button btnReporte;

    @FXML
    private ComboBox<?> cbConsultas;

    @FXML
    private JFXTextField tfFechaInicio;

    @FXML
    private JFXTextField tfFechaFin;

    @FXML
    private Button btnConsulta;

    @FXML
    private BorderPane BorderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionBtnConsulta(ActionEvent actionEvent) {
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionBtnReporte(ActionEvent actionEvent) {
    }
}
