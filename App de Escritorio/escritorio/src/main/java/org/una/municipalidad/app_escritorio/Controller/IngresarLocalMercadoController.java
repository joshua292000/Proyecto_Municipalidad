package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.una.municipalidad.app_escritorio.DTO.LicenciasComercialesDTO;
import org.una.municipalidad.app_escritorio.DTO.LocalesMercadoDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class IngresarLocalMercadoController extends Controller implements Initializable {
    @FXML
    private TextField txtNombre;

    @FXML
    private Pane Panefondo;

    @FXML
    private Button btnInsertar;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtMonto;

    @FXML
    private TextField txtDistrito;

    @FXML
    private HBox itemC;

    @FXML
    private TextField txtCorreo;

    private ObservableList<LocalesMercadoDTO> options = FXCollections.observableArrayList();


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
        Long Monto = Long.valueOf(txtMonto.getText());
        boolean estado = true;
       // options.add(new LocalesMercadoDTO(idd,txtNombre.getText(),txtDistrito.getText(),txtCorreo.getText(),telefono,Monto,fecha,fecha,estado));
        for(int x=0;x<options.size();x++){
            //LocalesMercadoDTO licencia = ConsultasGestorService.CrearLocalMercado(options.get(x).getNombreLocal(),options.get(x).getUbicacionLocal(),options.get(x).getCorreoLocal(),options.get(x).getTelefonoLocal(),options.get(x).getMonto_Alquiler_Local(),fechaRegistro,fechaRegistro,estado);
        }
        JOptionPane.showMessageDialog(null,"Archivo guardado correctamente");
    }
}
