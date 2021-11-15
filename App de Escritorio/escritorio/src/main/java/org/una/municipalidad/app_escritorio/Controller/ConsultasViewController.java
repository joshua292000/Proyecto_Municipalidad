package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultasViewController extends Controller implements Initializable {
    @FXML
    private Button btnReporte;

    @FXML
    private ComboBox<String> cbConsultas;

    @FXML
    private JFXTextField tfFechaInicio;

    @FXML
    private JFXTextField tfFechaFin;

    @FXML
    private Button btnConsulta;

    @FXML
    private BorderPane BorderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfFechaInicio.setVisible(false);
        tfFechaFin.setVisible(false);
        btnConsulta.setVisible(false);
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("Consulta por un cobro entre dos fechas",
                "Consulta por cedula las Propiedades que pertenecen a un contribuyente",
                "Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente",
                "Consulta por cedula los Locales de mercado que pertenecen a un contribuyente",
                "Consulta por todos los parámetros");

        cbConsultas.setItems(items);
    }

    @Override
    public void initialize() {

    }

    public void OnActionBtnConsulta(ActionEvent actionEvent) {
        if(cbConsultas.getValue()!=null){
            if(cbConsultas.getValue().equals("Consulta por un cobro entre dos fechas")){
                if(!tfFechaInicio.getText().isEmpty() && !tfFechaFin.getText().isEmpty() ){
                    setParametro(tfFechaInicio.getText());
                    setParametro2(tfFechaFin.getText());
                }
                setHola(5);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula las Propiedades que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty()){
                    setParametro(tfFechaInicio.getText());
                }
                setHola(6);

            }if(cbConsultas.getValue().equals("Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty() ){
                    setParametro(tfFechaInicio.getText());
                }
                setHola(7);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula los Locales de mercado que pertenecen a un contribuyente")){
                if(!tfFechaInicio.getText().isEmpty() ){
                    setParametro(tfFechaInicio.getText());
                }
                setHola(8);
            }
            if(cbConsultas.getValue().equals("Consulta por todos los parámetros")){
                setHola(9);
            }
        }
        loadUI("ListadoView",BorderPane);
    }

    public void OnActionBtnReporte(ActionEvent actionEvent) {
    }

    public void OnActioncbConsultas(ActionEvent actionEvent) {
        if(cbConsultas.getValue()!=null){
            if(cbConsultas.getValue().equals("Consulta por un cobro entre dos fechas")){
                tfFechaInicio.setPromptText("Fecha Inicio (yyyy-MM-dd)");
                tfFechaFin.setPromptText("Fecha Fin (yyyy-MM-dd)");
                tfFechaInicio.clear();
                tfFechaFin.clear();
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(true);
                btnConsulta.setVisible(true);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula las Propiedades que pertenecen a un contribuyente")){
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
            }if(cbConsultas.getValue().equals("Consulta por cedula las Licencias comerciales que pertenecen a un contribuyente")){
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
            }
            if(cbConsultas.getValue().equals("Consulta por cedula los Locales de mercado que pertenecen a un contribuyente")){
                tfFechaInicio.clear();
                tfFechaInicio.setPromptText("Cedula contribuyente");
                tfFechaInicio.setVisible(true);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
            }
            if(cbConsultas.getValue().equals("Consulta por todos los parámetros")){
                tfFechaInicio.setVisible(false);
                tfFechaFin.setVisible(false);
                btnConsulta.setVisible(true);
            }
        }

    }

    /*public static void integerTextField(TextField textField) {
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
    }*/
}
