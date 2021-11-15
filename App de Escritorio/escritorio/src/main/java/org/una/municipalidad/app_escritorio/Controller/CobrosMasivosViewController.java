package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CobrosMasivosViewController extends Controller implements Initializable {

    @FXML
    private BorderPane BorderPane;
    @FXML
    private JFXButton btnMensual;

    @FXML
    private JFXButton btnAnual;

    @FXML
    private JFXButton btnTrimestral;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionBtnMensual(ActionEvent actionEvent) throws IOException, InterruptedException {
        ConsultasServiceGerente.CrearCobrosMasivosxLocal();
        setHola(10);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionBtnAnual(ActionEvent actionEvent) throws IOException, InterruptedException {
        ConsultasServiceGerente.CrearCobrosMasivosxpropiedad();
        setHola(10);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionbtnTrimestral(ActionEvent actionEvent) throws IOException, InterruptedException {
        ConsultasServiceGerente.CrearCobrosMasivosxLicencias();
        setHola(10);
        loadUI("ListadoView",BorderPane);
    }
}
