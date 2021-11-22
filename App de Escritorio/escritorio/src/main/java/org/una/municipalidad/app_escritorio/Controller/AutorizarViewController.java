package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AutorizarViewController extends Controller implements Initializable {
    @FXML
    private MenuItem MenuLicen;


    @FXML
    private BorderPane BorderPane;

    @FXML
    private MenuItem MenuLocales;


    @FXML
    private MenuItem MenuPropiedades;

    @FXML
    private MenuBar MenuBar;


    @FXML
    private MenuItem MenuCobros;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JOptionPane.showMessageDialog(null,"Por favor escoge alguna de las opciones que se muestran en el siguiente menú");
    }

    @Override
    public void initialize() {

    }

    public void OnActionMenuLocales(ActionEvent actionEvent) {
        setHola(4);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuCobros(ActionEvent actionEvent) {
        setHola(1);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuLicen(ActionEvent actionEvent) {
        setHola(2);
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionMenuPropiedades(ActionEvent actionEvent) {
        setHola(3);
        loadUI("ListadoView",BorderPane);
    }

}
