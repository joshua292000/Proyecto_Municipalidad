package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class AuditorController extends Controller implements Initializable {

    public BorderPane BorderPaneFondo;
    public VBox vboxFondo;
    public Label lblUsuario;
    public Label lblRol;
    public JFXButton btnCerrarSesion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblUsuario.setText(String.valueOf(AppContext.getInstance().get("usuario")));
        lblRol.setText(String.valueOf(AppContext.getInstance().get("roles")));
    }

    @Override
    public void initialize() {

    }

    public void OnActionbtnListaCobros(ActionEvent actionEvent) {
        setHola(10);
        loadUI("CobrosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnMovimientosRealizados(ActionEvent actionEvent) {
        setHola(11);
        loadUI("MovimientosRealizadosView",BorderPaneFondo);
    }

    public void OnActionbtnTodosLocalesMercado(ActionEvent actionEvent) {
        setHola(12);
        loadUI("LocalesMercadoView",BorderPaneFondo);
    }

    public void OnActionbtnTodasLicenciasComerciales(ActionEvent actionEvent) {
        setHola(13);
        loadUI("LicenciasComercialesView",BorderPaneFondo);
    }

    public void OnActionbtnTodasPropiedades(ActionEvent actionEvent) {
        setHola(14);
        loadUI("PropiedadesView",BorderPaneFondo);
    }

    public void OnActionbtnCerrarSesion(ActionEvent actionEvent) {
        ((Stage) btnCerrarSesion.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("Loggin");
    }
}
