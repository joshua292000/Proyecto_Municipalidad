package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.Contribuyentes_PropiedadesDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ContribuyenteXPropiedadController extends Controller implements Initializable {

    @FXML
    private Button btnGuardarP;

    @FXML
    private TextField txtPorcentajeP;

    @FXML
    private TextField txtCedulaP;

    @FXML
    private TextField txtId;

    private Long porcentaje= Long.valueOf(0);
    private String cedula;
    private String nombre;
    private Long idp = Long.valueOf(0);
    LocalDate bitacoraFecha = LocalDate.parse("2021-11-12");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionGuardarPropiedad(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(txtPorcentajeP.getLength()==0 || txtCedulaP.getLength()==0 || txtId.getLength()==0){
            JOptionPane.showMessageDialog(null, "Existen campos sin rellenar, porfavor llene todos los campos");
        }else{
            porcentaje = Long.valueOf(txtPorcentajeP.getText());
            cedula = txtCedulaP.getText();
            idp = Long.valueOf(txtId.getText());

            if(ConsultasGestorService.ObtenerIdPropiedad(idp)==null){
                JOptionPane.showMessageDialog(null, "Esa propiedad no se encuentra agregada");
            }if(ConsultasGestorService.ObtenerContribuyente(cedula)==null){
                JOptionPane.showMessageDialog(null, "Ese contribuyente no se encuentra agregado");
            }else{
                Contribuyentes_PropiedadesDTO conXImp = ConsultasGestorService.CrearPropiedadXContribuyente(porcentaje,ConsultasGestorService.ObtenerContribuyente(cedula),ConsultasGestorService.ObtenerIdPropiedad(idp));
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("contribuyentes_propiedades", "Guardar una propiedad con un contribuyente", AppContext.getInstance().get("usuario").toString(),bitacoraFecha, AutenticacionService.datos.get(0).getUsuarioDTO().getId());
                txtPorcentajeP.clear();
                txtCedulaP.clear();
                txtId.clear();
            }
        }
    }
}
