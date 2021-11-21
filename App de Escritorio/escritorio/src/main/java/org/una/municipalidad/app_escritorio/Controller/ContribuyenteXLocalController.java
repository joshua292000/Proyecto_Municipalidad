package org.una.municipalidad.app_escritorio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.una.municipalidad.app_escritorio.DTO.Contribuyentes_Locales_MercadoDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContribuyenteXLocalController extends Controller implements Initializable {

    @FXML
    private TextField txtContribuyenteL;

    @FXML
    private Button btnGuardarL;

    @FXML
    private TextField txtNombreL;

    @FXML
    private TextField txtPorcentajeL;
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

    public void OnActionGuardarLocal(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(txtPorcentajeL.getLength()==0 || txtContribuyenteL.getLength()==0 || txtNombreL.getLength()==0){
            JOptionPane.showMessageDialog(null, "Existen campos sin rellenar, porfavor llene todos los campos");
        }else{
            porcentaje = Long.valueOf(txtPorcentajeL.getText());
            cedula = txtContribuyenteL.getText();
            nombre = txtNombreL.getText();

            if(ConsultasGestorService.ObtenerNombreLocal(sacarNombre(nombre))==null){
                JOptionPane.showMessageDialog(null, "Ese local no se encuentra agregada");
            }if(ConsultasGestorService.ObtenerContribuyente(cedula)==null){
                JOptionPane.showMessageDialog(null, "Ese contribuyente no se encuentra agregado");
            }else{
                Contribuyentes_Locales_MercadoDTO conXImp = ConsultasGestorService.CrearLocalXContribuyente(porcentaje,ConsultasGestorService.ObtenerContribuyente(cedula),ConsultasGestorService.ObtenerNombreLocal(sacarNombre(nombre)));
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
                txtPorcentajeL.clear();
                txtContribuyenteL.clear();
                txtNombreL.clear();
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
