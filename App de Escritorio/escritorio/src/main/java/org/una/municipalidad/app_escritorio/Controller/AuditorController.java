package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.una.municipalidad.app_escritorio.DTO.AuthenticationResponse;
import org.una.municipalidad.app_escritorio.DTO.RolesDTO;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.FlowController;

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
