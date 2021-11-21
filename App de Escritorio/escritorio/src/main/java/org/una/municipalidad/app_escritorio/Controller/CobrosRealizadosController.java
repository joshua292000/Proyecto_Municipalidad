package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.CobrosDTO;
import org.una.municipalidad.app_escritorio.DTO.UsuariosDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceAuditor;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CobrosRealizadosController extends Controller implements Initializable {

    public TableColumn tvcId;
    public TableColumn tvcEstado;
    public TableColumn tvcFechaCreacion;
    public TableColumn tvcFechaPago;
    public TableColumn tvcFechaVencimiento;
    public TableColumn tvcMonto;
    public TableColumn tvcPeriodo;
    public TableColumn tvcIdFactura;
    public TableColumn tvcIdLicenciaComercial;
    public TableColumn tvcIdLocalesMercado;
    public TableColumn tvcIdPropiedades;
    public TableColumn tvcIdTipoCobros;
    public TableView Tview_CobrosLista;
    public JFXRadioButton rbSinPagar;
    public JFXRadioButton rbPagados;
    public DatePicker dtFechaDesde;
    public DatePicker dtFechaHasta;
    String estado;
    private ObservableList<CobrosDTO> cobrosRealizadoslist = FXCollections.observableArrayList();
    private String  ArrayCobro[] ={"id","cobrosPeriodo","cobrosMonto","cobrosFechaCreacion","cobrosFechaVencimiento","Estado","cobrosFechaPago",
            "licenciacomerciales","facturas","tipocobros","localesmercado","propiedades"};
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       IniciarDatos();
    }

    @Override
    public void initialize() {

    }

    @SneakyThrows
    public void IniciarDatos(){
        List<CobrosDTO> cobro = ConsultasServiceGerente.obtenerTodoCobro();

        if (cobro != null) {
            for (CobrosDTO cobros : cobro) {
                cobrosRealizadoslist.add(new CobrosDTO(cobros.getId(), cobros.getCobrosPeriodo(), cobros.getCobrosMonto(), cobros.getCobrosFechaCreacion(), cobros.getCobrosFechaVencimiento(), cobros.getEstado(), cobros.getCobrosFechaPago(), cobros.getLicenciascomerciales(), cobros.getFacturas(), cobros.getTipocobros(), cobros.getLocalesmercado(), cobros.getPropiedades()));
            }
            this.Tview_CobrosLista.setItems(cobrosRealizadoslist);
        }

        System.out.print(cobro);
        LlenarTabla();

    }

    public void LlenarTabla(){
        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.tvcFechaCreacion.setCellValueFactory(new PropertyValueFactory("cobrosFechaCreacion"));
        this.tvcFechaPago.setCellValueFactory(new PropertyValueFactory("cobrosFechaPago"));
        this.tvcFechaVencimiento.setCellValueFactory(new PropertyValueFactory("cobrosFechaVencimiento"));
        this.tvcMonto.setCellValueFactory(new PropertyValueFactory("cobrosMonto"));
        this.tvcPeriodo.setCellValueFactory(new PropertyValueFactory("cobrosPeriodo"));
        this.tvcIdFactura.setCellValueFactory(new PropertyValueFactory("facturas"));
        this.tvcIdLicenciaComercial.setCellValueFactory(new PropertyValueFactory("licenciascomerciales"));
        this.tvcIdLocalesMercado.setCellValueFactory(new PropertyValueFactory("localesmercado"));
        this.tvcIdPropiedades.setCellValueFactory(new PropertyValueFactory("propiedades"));
        this.tvcIdTipoCobros.setCellValueFactory(new PropertyValueFactory("tipocobros"));
        this.Tview_CobrosLista.setItems(cobrosRealizadoslist);
    }

    public void OnActionbtnVisualizarInformacionsinfiltros(ActionEvent actionEvent) {
        for ( int i = 0; i< Tview_CobrosLista.getItems().size(); i++) {
            Tview_CobrosLista.getItems().clear();
        }
        IniciarDatos();

    }

    @SneakyThrows
    public void OnActionbtnVisualizarInformacion(ActionEvent actionEvent)  {
        for ( int i = 0; i< Tview_CobrosLista.getItems().size(); i++) {
            Tview_CobrosLista.getItems().clear();
        }
            List<CobrosDTO> cobro = ConsultasServiceAuditor.ObtenerCobrosEstadoFecha(estado,dtFechaDesde.getValue(),dtFechaHasta.getValue());
        if(cobro !=null){
            for(CobrosDTO cobros:cobro){
                cobrosRealizadoslist.add(new CobrosDTO(cobros.getId(), cobros.getCobrosPeriodo(), cobros.getCobrosMonto(), cobros.getCobrosFechaCreacion(), cobros.getCobrosFechaVencimiento(), cobros.getEstado(), cobros.getCobrosFechaPago(), cobros.getLicenciascomerciales(), cobros.getFacturas(), cobros.getTipocobros(), cobros.getLocalesmercado(), cobros.getPropiedades()));
            }
            this.Tview_CobrosLista.setItems(cobrosRealizadoslist);
        }

    }

    public void OnActionrbSinPagar(ActionEvent actionEvent) {
        estado="Pendiente";
    }

    public void OnActionrbPagados(ActionEvent actionEvent) {
        estado="Pagado";
    }

    @SneakyThrows
    public void OnActionbtnGenerarReporte(ActionEvent actionEvent) {
        if(getHola()==10) {
            CrearReporte(Tview_CobrosLista, ArrayCobro, ArrayCobro.length, "Cobros", cobrosRealizadoslist);
        }
    }
}
