package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.una.municipalidad.app_escritorio.DTO.ContribuyentesDTO;
import org.una.municipalidad.app_escritorio.DTO.LicenciasComercialesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;

public class IngresarLicenciaController extends Controller implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private Pane Panefondo;

    @FXML
    private Button btnInsertar;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDistrito;

    @FXML
    private HBox itemC;

    @FXML
    private TextField txtCorreo;
    private ObservableList<LicenciasComercialesDTO> options = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void OnActionInsertar(ActionEvent actionEvent) throws IOException, InterruptedException {
        long idd=8;
        LocalDate fechaRegistro = LocalDate.parse("2021-11-12");
        Date fecha = new Date();
        Long telefono = Long.valueOf(txtTelefono.getText());
        boolean estado = true;
        //options.add(new LicenciasComercialesDTO(idd,txtNombre.getText(),telefono,txtCorreo.getText(),txtDistrito.getText(),fecha,fecha,txtCodigo.getText(),estado));
        System.out.println("tiene " + options);
        for(int x=0;x<options.size();x++){
            LicenciasComercialesDTO licencia = ConsultasGestorService.CrearLicenciaComercial(options.get(x).getNombreComercio(),options.get(x).getTelefonoComercio(),options.get(x).getCorreoComercio(),options.get(x).getDistritoComercio(),fechaRegistro,fechaRegistro,options.get(x).getCodigoComercio(),estado);

        }
        JOptionPane.showMessageDialog(null,"Archivo guardado correctamente");
    }
}
