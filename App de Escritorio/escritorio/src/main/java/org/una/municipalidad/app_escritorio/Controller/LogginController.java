package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.DTO.AuthenticationResponse;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogginController extends Controller implements Initializable {

    public JFXTextField txtCedula;
    public JFXPasswordField txtContrasenia;
    public JFXButton btnIngresar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionbtnIngresar(ActionEvent actionEvent) throws IOException, InterruptedException {
      AuthenticationResponse login = AutenticacionService.Autenticacion(txtCedula.getText().toString(), txtContrasenia.getText().toString());

        if(login != null){
            System.out.println("el rol es " + AppContext.getInstance().get("roles"));
            if(AppContext.getInstance().get("roles").equals("ROLE_GESTOR")){
                ((Stage) btnIngresar.getScene().getWindow()).close();
                txtCedula.clear();
                txtContrasenia.clear();
                FlowController.getInstance().goViewInWindow("Home");


            }else if(AppContext.getInstance().get("roles").equals("ROLE_GERENTE")){
                ((Stage) btnIngresar.getScene().getWindow()).close();
                txtCedula.clear();
                txtContrasenia.clear();
                FlowController.getInstance().goViewInWindow("GerentesView");

            }else if(AppContext.getInstance().get("roles").equals("ROLE_ADMINISTRADOR")){
                ((Stage) btnIngresar.getScene().getWindow()).close();
                txtCedula.clear();
                txtContrasenia.clear();
                Controller.setAdmin(1);
                FlowController.getInstance().goViewInWindow("HomeAdmin");

            }else if(AppContext.getInstance().get("roles").equals("ROLE_AUDITOR")){
                ((Stage) btnIngresar.getScene().getWindow()).close();
                txtCedula.clear();
                txtContrasenia.clear();
                FlowController.getInstance().goViewInWindow("AuditorView");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ese usuario no se encuentra ingresado");
            }
        }
    }
}
