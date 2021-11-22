package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.LicenciasComercialesDTO;
import org.una.municipalidad.app_escritorio.DTO.LocalesMercadoDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Util.AppContext;
import org.una.municipalidad.app_escritorio.Util.FlowController;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

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
        integerTextField(txtTelefono);
        integerTextField(txtMonto);
    }

    @Override
    public void initialize() {

    }

    public void OnActionInsertar(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(txtDistrito.getLength()==0 || txtMonto.getLength()==0 || txtCorreo.getLength()==0 || txtNombre.getLength()==0 || txtTelefono.getLength()==0){
            JOptionPane.showMessageDialog(null,"Existen campos vacios, porfavor ingrese todos todos los datos");
        }else {
            long idd = 8;
            LocalDate fechaRegistro = LocalDate.parse("2021-11-12");
            Date fecha = new Date();
            Long telefono = Long.valueOf(txtTelefono.getText());
            Long Monto = Long.valueOf(txtMonto.getText());
            String estado = "Activo";
            options.add(new LocalesMercadoDTO(idd, txtNombre.getText(), txtDistrito.getText(), txtCorreo.getText(), telefono, Monto, fecha, fecha, estado));
            for (int x = 0; x < options.size(); x++) {
                LocalesMercadoDTO licencia = ConsultasGestorService.CrearLocalMercado(options.get(x).getNombreLocal(), options.get(x).getUbicacionLocal(), options.get(x).getCorreoLocal(), options.get(x).getTelefonoLocal(), options.get(x).getMonto_Alquiler_Local(), fechaRegistro, fechaRegistro, estado);
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("locales_mercado", "Guardar un local de mercado", AppContext.getInstance().get("usuario").toString(),fechaRegistro, AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            Controller.setImpuesto(2);
            ((Stage) btnInsertar.getScene().getWindow()).close();
            FlowController.getInstance().goViewInWindow("Home");
        }
    }

    public static void integerTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();

            if (newText.matches("-?([0-9]*)?")) {

                return change;
            }

            return null;
        };
        textField.setTextFormatter(
                new TextFormatter<Integer>(
                        new IntegerStringConverter(), 0, integerFilter));
    }
}
