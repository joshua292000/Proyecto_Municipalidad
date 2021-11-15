package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.CobrosDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

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
    private ObservableList<CobrosDTO> cobrosRealizadoslist = FXCollections.observableArrayList();

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<CobrosDTO> cobro = ConsultasServiceGerente.obtenerTodoCobro();

        if (cobro != null) {
            for (CobrosDTO cobros : cobro) {
                cobrosRealizadoslist.add(new CobrosDTO(cobros.getId(), cobros.getCobrosPeriodo(), cobros.getCobrosMonto(), cobros.getCobrosFechaCreacion(), cobros.getCobrosFechaVencimiento(), cobros.getEstado(), cobros.getCobrosFechaPago(), cobros.getLicenciacomercial(), cobros.getFacturas(), cobros.getTipocobros(), cobros.getLocalesmercado(), cobros.getPropiedades()));
            }
            this.Tview_CobrosLista.setItems(cobrosRealizadoslist);
        }
        System.out.print(cobro);
        LlenarTabla();
    }

    @Override
    public void initialize() {

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
        this.tvcIdLicenciaComercial.setCellValueFactory(new PropertyValueFactory("licenciacomerciales"));
        this.tvcIdLocalesMercado.setCellValueFactory(new PropertyValueFactory("localesmercado"));
        this.tvcIdPropiedades.setCellValueFactory(new PropertyValueFactory("propiedades"));
        this.tvcIdTipoCobros.setCellValueFactory(new PropertyValueFactory("tipocobros"));
        this.Tview_CobrosLista.setItems(cobrosRealizadoslist);
    }
}
