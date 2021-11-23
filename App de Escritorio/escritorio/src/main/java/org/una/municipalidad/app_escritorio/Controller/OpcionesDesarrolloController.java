package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class OpcionesDesarrolloController extends Controller implements Initializable {

    @FXML
    private Button btnGerente;

    @FXML
    private Button btnGestor;

    @FXML
    private Button btnAuditor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionGestor(ActionEvent actionEvent) {
        Controller.setPantallas(1);
        ((Stage) btnGestor.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("HomeAdmin");
    }

    public void OnActionAuditor(ActionEvent actionEvent) {
        Controller.setPantallas(3);
        ((Stage) btnGestor.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("HomeAdmin");
    }

    public void OnActionGerente(ActionEvent actionEvent) {
        Controller.setPantallas(2);
        ((Stage) btnGestor.getScene().getWindow()).close();
        FlowController.getInstance().goViewInWindow("HomeAdmin");
    }
}
