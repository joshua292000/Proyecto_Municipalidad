package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class GerenteViewController extends Controller implements Initializable {

    @FXML
    private ImageView imgCobros;

    @FXML
    private ImageView imgAutorizar;

    @FXML
    private ImageView imgConsultas;

    @FXML
    private ImageView imgConsultas1;

    @FXML
    private JFXButton btnAutorizar;

    @FXML
    private JFXButton btnConsultas;

    @FXML
    private JFXButton btnCobros;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private VBox Vbox;

    @FXML
    private JFXButton btnCerrar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Vbox.setPrefWidth(20);
        btnAutorizar.setVisible(false);
        btnCobros.setVisible(false);
        btnConsultas.setVisible(false);
        btnCerrar.setVisible(false);
        imgCobros.setTranslateX(15);
        imgAutorizar.setTranslateX(15);
        imgConsultas.setTranslateX(15);
        imgConsultas1.setTranslateX(15);
        if(Controller.getAdmin()==1){
            String texto="Este boton se llama btnAutorizar";
            btnAutorizar.setTooltip(new Tooltip(texto));

            String texto2="Este boton se llama btnCerrar";
            btnCerrar.setTooltip(new Tooltip(texto2));

            String texto3="Este boton se llama btnCobros";
            btnCobros.setTooltip(new Tooltip(texto3));

            String texto4="Este boton se llama btnConsultas";
            btnConsultas.setTooltip(new Tooltip(texto4));

        }
    }

    @Override
    public void initialize() {

    }


    public void OnActionBtnAutorizar(ActionEvent actionEvent) {

        loadUI("AutorizarView",BorderPane);
    }

    public void OnMouseEnteredVbox(MouseEvent mouseEvent) {
        Vbox.setPrefWidth(132);
        btnAutorizar.setVisible(true);
        btnCobros.setVisible(true);
        btnConsultas.setVisible(true);
        btnCerrar.setVisible(true);
        imgCobros.setTranslateX(0);
        imgAutorizar.setTranslateX(0);
        imgConsultas.setTranslateX(0);
        imgConsultas1.setTranslateX(0);
    }

    public void OnMouseExitedVbox(MouseEvent mouseEvent) {
        Vbox.setPrefWidth(20);
        btnAutorizar.setVisible(false);
        btnCobros.setVisible(false);
        btnConsultas.setVisible(false);
        btnCerrar.setVisible(false);
        imgCobros.setTranslateX(15);
        imgAutorizar.setTranslateX(15);
        imgConsultas.setTranslateX(15);
        imgConsultas1.setTranslateX(15);
    }

    public void OnActionbtnConsultas(ActionEvent actionEvent) {
        loadUI("ConsultasView",BorderPane);
    }

    public void OnActionBtnCobros(ActionEvent actionEvent) {
        loadUI("CobrosMasivosview",BorderPane);
    }

    public void OnActionbtnCerrar(ActionEvent actionEvent) {
        ((Stage) btnCerrar.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("Loggin");
    }
}
