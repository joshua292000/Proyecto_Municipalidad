package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.IntegerStringConverter;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
public class ConsultasViewController extends Controller implements Initializable {

    @FXML
    private ComboBox<String> cbConsultas;

    @FXML
    private JFXTextField tfFechaInicio;

    @FXML
    private JFXTextField tfFechaFin;

    @FXML
    private JFXButton btnConsulta;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private DatePicker dpFechaFin;

    @FXML
    private DatePicker dpFechainicio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        tfFechaInicio.setVisible(false);
        tfFechaFin.setVisible(false);
        btnConsulta.setVisible(false);
        dpFechainicio.setVisible(false);
        dpFechaFin.setVisible(false);
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("Consulta por un cobro entre dos fechas",
                "Consulta por cedula las Propiedades que pertenecen a un contribuyente",
                "Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente",
                "Consulta por cedula los Locales de mercado que pertenecen a un contribuyente",
                "Consulta por todos los par??metros");

        cbConsultas.setItems(items);
    }

    @Override
    public void initialize() {

    }

    public void OnActionBtnConsulta(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(cbConsultas.getValue()!=null){
            if(cbConsultas.getValue().equals("Consulta por un cobro entre dos fechas")){
                System.out.print("Fecha1 "+dpFechainicio.getValue().toString());
                System.out.print("Fecha 2 "+dpFechaFin.getValue().toString());
                if(dpFechainicio.getValue()!=null && dpFechaFin.getValue()!=null ){

                    setParametro(dpFechainicio.getValue().toString());
                    setParametro2(dpFechainicio.getValue().toString());
                }else{
                    JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio");
                }
                setHola(5);
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Cobros", "Consulta un cobro por fechas", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            }
            if(cbConsultas.getValue().equals("Consulta por cedula las Propiedades que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty()){
                    setParametro(tfFechaInicio.getText());
                }else{
                    JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio");
                }
                setHola(6);
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Propiedades", "Consulta una propiedad por n??mero de cedula del contribuyente", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            }if(cbConsultas.getValue().equals("Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty() ){
                    setParametro(tfFechaInicio.getText());
                }else{
                    JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio");
                }
                setHola(7);
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Licencias comerciales", "Consulta una licencias comerciales por n??mero de cedula del contribuyente", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            }
            if(cbConsultas.getValue().equals("Consulta por cedula los Locales de mercado que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty() ){
                    setParametro(tfFechaInicio.getText());
                }else{
                    JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio");
                }
                setHola(8);
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Locales de mercado", "Consulta una locales de mercado por n??mero de cedula del contribuyente", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            }
            if(cbConsultas.getValue().equals("Consulta por todos los par??metros")){
                setHola(9);
                BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Par??metros", "Consulta a la tabla de par??metros", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
            }
        }
        System.out.print("parametros "+getParametro());
        System.out.print("parametros 2 "+getParametro2());
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionBtnReporte(ActionEvent actionEvent) {
    }

    public void OnActioncbConsultas(ActionEvent actionEvent)  {
        if(cbConsultas.getValue()!=null){
            if(cbConsultas.getValue().equals("Consulta por un cobro entre dos fechas")){
                JOptionPane.showMessageDialog(null,"Por favor ingresa las fechas por las cuales quieres hacer la consulta y luego presiona el bot??n de Realizar consultar");
                tfFechaInicio.setVisible(false);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
                dpFechainicio.setVisible(true);
                dpFechaFin.setVisible(true);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula las Propiedades que pertenecen a un contribuyente")){
                JOptionPane.showMessageDialog(null,"Por favor ingresa la cedula del contribuyente y luego presiona el bot??n de Realizar consultar");
                integerTextField(tfFechaInicio);
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
                dpFechainicio.setVisible(false);
                dpFechaFin.setVisible(false);
            }if(cbConsultas.getValue().equals("Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente")){
                JOptionPane.showMessageDialog(null,"Por favor ingresa la cedula del contribuyente y luego presiona el bot??n de Realizar consultar");
                integerTextField(tfFechaInicio);
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
                dpFechainicio.setVisible(false);
                dpFechaFin.setVisible(false);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula los Locales de mercado que pertenecen a un contribuyente")){
                JOptionPane.showMessageDialog(null,"Por favor ingresa la cedula del contribuyente y luego presiona el bot??n de Realizar consultar");
                integerTextField(tfFechaInicio);
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
                dpFechainicio.setVisible(false);
                dpFechaFin.setVisible(false);
            }
            if(cbConsultas.getValue().equals("Consulta por todos los par??metros")){
                JOptionPane.showMessageDialog(null,"Por favor presiona el bot??n de Realizar consultar");
                tfFechaInicio.setVisible(false);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
                dpFechainicio.setVisible(false);
                dpFechaFin.setVisible(false);
            }
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
