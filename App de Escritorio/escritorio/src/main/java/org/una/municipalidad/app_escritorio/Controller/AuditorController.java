package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AuditorController extends Controller implements Initializable {

    public BorderPane BorderPaneFondo;
    public VBox vboxFondo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionbtnListaCobros(ActionEvent actionEvent) {
        loadUI("CobrosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnMovimientosRealizados(ActionEvent actionEvent) {
        loadUI("MovimientosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnTodasDeclaraciones(ActionEvent actionEvent) {
    }

    public void OnActionbtnTodasLicenciasComerciales(ActionEvent actionEvent) {
    }

    public void OnActionbtnTodasPropiedades(ActionEvent actionEvent) {
    }

    public void OnActionbtnTodosRoles(ActionEvent actionEvent) {
    }
}
