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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

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

    private ObservableList<CobrosDTO> options = FXCollections.observableArrayList();
    private ObservableList<ContribuyentesDTO> optionscont = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Locales_MercadoDTO> optionscontLoc = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Licencias_ComercialesDTO> optionscontLic = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_PropiedadesDTO> optionscontPro = FXCollections.observableArrayList();
    private ObservableList<LocalesMercadoDTO> optionsLoc = FXCollections.observableArrayList();
    private ObservableList<LicenciasComercialesDTO> optionsLic = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> optionsPro = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    @FXML
    void OnActionBuscar(ActionEvent event) throws IOException, InterruptedException {

            System.out.print("Hola Joss");
            List<CobrosDTO> cobro= ConsultasServiceGerente.obtenerTodoCobro();
            if(cobro!=null){
                for(CobrosDTO cobros:cobro){
                    options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.isEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomerciales(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                }
                //Collection.sort(options);
                this.tablacobros.setItems(options);
            }
            System.out.print(cobro);


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
