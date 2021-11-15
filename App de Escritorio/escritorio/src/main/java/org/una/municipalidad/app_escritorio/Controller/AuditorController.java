package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.net.URL;
import java.util.ResourceBundle;

public class AuditorController extends Controller implements Initializable {

    public BorderPane BorderPaneFondo;
    public VBox vboxFondo;
    public Label lblUsuario;
    public Label lblRol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblUsuario.setText(String.valueOf(AppContext.getInstance().get("usuario")));
        lblRol.setText(String.valueOf(AppContext.getInstance().get("roles")));
    }

    @Override
    public void initialize() {

    }

    public void OnActionbtnListaCobros(ActionEvent actionEvent) {
        loadUI("CobrosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnMovimientosRealizados(ActionEvent actionEvent) {
        System.out.println("Holi");
        loadUI("MovimientosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnTodasDeclaraciones(ActionEvent actionEvent) {
        loadUI("DeclaracionesView",BorderPaneFondo);
    }

    public void OnActionbtnTodasLicenciasComerciales(ActionEvent actionEvent) {
        loadUI("LicenciasComercialesView",BorderPaneFondo);
    }

    public void OnActionbtnTodasPropiedades(ActionEvent actionEvent) {
        loadUI("PropiedadesView",BorderPaneFondo);
    }

}
