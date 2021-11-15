package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import javax.swing.*;

public class BusquedaCancelacionCobrosController extends Controller implements Initializable {

    @FXML
    private TableView tablacobros;

    @FXML
    private TableColumn Col11;

    @FXML
    private TableColumn Col12;

    @FXML
    private HBox itemC;

    @FXML
    private TableColumn Col1;

    @FXML
    private TableColumn Col2;

    @FXML
    private TableColumn Col3;

    @FXML
    private TableColumn Col4;

    @FXML
    private TableColumn Col5;

    @FXML
    private TableColumn Col6;

    @FXML
    private TableColumn Col7;

    @FXML
    private TableColumn Col8;

    @FXML
    private TableColumn Col9;

    @FXML
    private TableColumn Col10;

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtCedula;

    private ObservableList<String> tipo = FXCollections.observableArrayList();

    @FXML
    private ComboBox cbxTipo = new ComboBox(tipo);

    private String Estado = "Pendiente";
    private String Tipo;

    private ObservableList<CobrosDTO> options = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipo.add("Licencia Comercial");
        tipo.add("Local de Mercado");
        tipo.add("Propiedades");
        cbxTipo.setItems(tipo);
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    @FXML
    void OnActionBuscar(ActionEvent event) throws IOException, InterruptedException {
        Tipo = cbxTipo.getValue().toString();

        if(txtCedula.getLength()==0){
            JOptionPane.showMessageDialog(null,"El campo cedula se encuentra vacio, porfavor digite una cedula");
        }else{
            if(Tipo == "Licencia Comercial"){
                List<CobrosDTO> cobro= ConsultasGestorService.obtenerCobro2(txtCedula.getText(),Estado);
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomercial(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    this.tablacobros.setItems(options);
                }
            }

            else if(Tipo == "Local de Mercado"){
                List<CobrosDTO> cobro= ConsultasGestorService.obtenerCobro3(txtCedula.getText(),Estado);
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomercial(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    this.tablacobros.setItems(options);
                }
            }

            else if(Tipo == "Propiedades"){
                List<CobrosDTO> cobro= ConsultasGestorService.obtenerCobro4(txtCedula.getText(),Estado);
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomercial(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    this.tablacobros.setItems(options);
                }
            }

        }
    }

    public void LlenarTabla(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("cobrosPeriodo"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("cobrosMonto"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("cobrosFechaCreacion"));
        this.Col5.setCellValueFactory(new PropertyValueFactory("cobrosFechaVencimiento"));
        this.Col6.setCellValueFactory(new PropertyValueFactory("Estado"));
        this.Col7.setCellValueFactory(new PropertyValueFactory("cobrosFechaPago"));
        this.Col8.setCellValueFactory(new PropertyValueFactory("licenciacomerciales"));
        this.Col9.setCellValueFactory(new PropertyValueFactory("facturas"));
        this.Col10.setCellValueFactory(new PropertyValueFactory("tipocobros"));
        this.Col11.setCellValueFactory(new PropertyValueFactory("localesmercado"));
        this.Col12.setCellValueFactory(new PropertyValueFactory("propiedades"));
        Col1.setText("id");
        Col2.setText("cobrosPeriodo");
        Col3.setText("cobrosMonto");
        Col4.setText("cobrosFechaCreacion");
        Col5.setText("cobrosFechaVencimiento");
        Col6.setText("Estado");
        Col7.setText("cobrosFechaPago");
        Col8.setText("licenciacomerciales");
        Col9.setText("facturas");
        Col10.setText("tipocobros");
        Col11.setText("localesmercado");
        Col12.setText("propiedades");
        this.tablacobros.setItems(options);
    }
}
