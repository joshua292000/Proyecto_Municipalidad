package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AutorizarViewController extends Controller implements Initializable {
    @FXML
    private MenuItem MenuLicen;

    @FXML
    private MenuItem MenuContriPropiedad;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private MenuItem MenuLocales;

    @FXML
    private MenuItem MenuContriLocal;

    @FXML
    private MenuItem MenuContriLicencia;

    @FXML
    private MenuItem MenuPropiedades;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem MenuContri;

    @FXML
    private MenuItem MenuCobros;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionMenuLocales(ActionEvent actionEvent) {
        System.out.print("Hola Mundo");
        setHola(8);
        //((VBox) BorderPane.getCenter()).getChildren().clear();
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuCobros(ActionEvent actionEvent) {
        setHola(1);
        System.out.print("Hola Mundo");
        //((VBox) BorderPane.getCenter()).getChildren().clear();
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuLicen(ActionEvent actionEvent) {
        System.out.print("Hola Mundo");
        setHola(6);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuPropiedades(ActionEvent actionEvent) {
        System.out.print("Hola Mundo");
        setHola(7);
        loadUI("ListadoView",BorderPane);
    }
    public void OnActionMenuContri(ActionEvent actionEvent) {
        setHola(2);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuContriLocal(ActionEvent actionEvent) {
        setHola(3);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuContriPropiedad(ActionEvent actionEvent) {
        setHola(4);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuContriLicencia(ActionEvent actionEvent) {
        setHola(5);
        loadUI("ListadoView",BorderPane);
    }
}
