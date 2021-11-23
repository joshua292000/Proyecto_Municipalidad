package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
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
    public JFXButton btnListaCobros;
    public JFXButton btnMovimientosRealizados;
    public JFXButton btnTodosLocalesMercado;
    public JFXButton btnTodasLicenciasComerciales;
    public JFXButton btnTodasPropiedades;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblUsuario.setText(String.valueOf(AppContext.getInstance().get("usuario")));
        lblRol.setText(String.valueOf(AppContext.getInstance().quitarRol(String.valueOf(AppContext.getInstance().get("roles")))));
        if(Controller.getAdmin()==1){
            String texto="Este boton se llama btnCerrarSesion";
            btnCerrarSesion.setTooltip(new Tooltip(texto));

            String texto2="Este boton se llama btnListaCobros";
            btnListaCobros.setTooltip(new Tooltip(texto2));

            String texto3="Este boton se llama btnMovimientosRealizados";
            btnMovimientosRealizados.setTooltip(new Tooltip(texto3));

            String texto4="Este boton se llama btnTodosLocalesMercado";
            btnTodosLocalesMercado.setTooltip(new Tooltip(texto4));

            String texto5="Este boton se llama btnTodasLicenciasComerciales";
            btnTodasLicenciasComerciales.setTooltip(new Tooltip(texto5));

            String texto6="Este boton se llama btnTodasPropiedades";
            btnTodasPropiedades.setTooltip(new Tooltip(texto6));

        }
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
