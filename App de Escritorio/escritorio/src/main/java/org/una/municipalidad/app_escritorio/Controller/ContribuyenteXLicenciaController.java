package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.una.municipalidad.app_escritorio.DTO.Contribuyentes_Licencias_ComercialesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContribuyenteXLicenciaController extends Controller implements Initializable {

    @FXML
    private TextField txtPorcentaje;

    @FXML
    private TextField txtContribuyente;

    @FXML
    private TextField txtLicencia;

    @FXML
    private Button btnGuardar;

    private ObservableList<Contribuyentes_Licencias_ComercialesDTO> listaLicencia = FXCollections.observableArrayList();
    private Long porcentaje= Long.valueOf(0);
    private String cedula;
    private String nombre;
    private Long idp = Long.valueOf(0);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionGuardarLicencia(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(txtPorcentaje.getLength()==0 || txtContribuyente.getLength()==0 || txtLicencia.getLength()==0){
            JOptionPane.showMessageDialog(null, "Existen campos sin rellenar, porfavor llene todos los campos");
        }else{
            porcentaje = Long.valueOf(txtPorcentaje.getText());
            cedula = txtContribuyente.getText();
            nombre = txtLicencia.getText();

            if(ConsultasGestorService.ObtenerLicenciaNombre(sacarNombre(nombre))==null){
                JOptionPane.showMessageDialog(null, "Esa licencia no se encuentra agregada");
            }if(ConsultasGestorService.ObtenerContribuyente(cedula)==null){
                JOptionPane.showMessageDialog(null, "Ese contribuyente no se encuentra agregado");
            }else{
                Contribuyentes_Licencias_ComercialesDTO conXImp = ConsultasGestorService.CrearLicenciaComercialXContribuyente(porcentaje,ConsultasGestorService.ObtenerContribuyente(cedula),ConsultasGestorService.ObtenerLicenciaNombre(sacarNombre(nombre)));
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
                txtPorcentaje.clear();
                txtContribuyente.clear();
                txtLicencia.clear();
            }
        }
    }

    public String sacarNombre(String nombre){
        String []n=nombre.split(" ");
        String j=" ";
        if(n.length>1){
            for(int x=0;x<n.length;x++){
                if(x==0){
                    j=n[x];
                }else{
                    j=j+"%20";
                    j=j+n[x];
                }
            }
        }else{
            j=nombre;
        }
        return j;
    }
}
