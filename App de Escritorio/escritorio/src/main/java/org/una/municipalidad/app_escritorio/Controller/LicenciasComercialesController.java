package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.LicenciasComercialesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LicenciasComercialesController  extends Controller implements Initializable {
    public TableView TviewLicenciaComercialLista;
    public TableColumn tvcId;
    public TableColumn tvcCodigo;
    public TableColumn tvcCorreo;
    public TableColumn tvcDistritoComercio;
    public TableColumn tvcEstado;
    public TableColumn tvcFechaRegistroComercio;
    public TableColumn tvcNombreComercio;
    public TableColumn tvcTelefonoComercio;
    public TableColumn tvcIFechaUltimaActualizacion;
    private ObservableList<LicenciasComercialesDTO> LicenciasComercialeslist = FXCollections.observableArrayList();

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<LicenciasComercialesDTO> licenciacomercial = ConsultasServiceGerente.obtenerTodoLicencias();

        if (licenciacomercial != null) {
            for (LicenciasComercialesDTO licenciascomerciales : licenciacomercial) {
                LicenciasComercialeslist.add(new LicenciasComercialesDTO(licenciascomerciales.getId(), licenciascomerciales.getNombreComercio(), licenciascomerciales.getTelefonoComercio(), licenciascomerciales.getCorreoComercio(), licenciascomerciales.getDistritoComercio(), licenciascomerciales.getFechaRegistrocomercio(), licenciascomerciales.getUltima_Actualizacioncomercio(), licenciascomerciales.getCodigoComercio(), licenciascomerciales.isEstado()));
            }
            this.TviewLicenciaComercialLista.setItems(LicenciasComercialeslist);
        }
        System.out.print(licenciacomercial);
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void LlenarTabla() {
        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcCodigo.setCellValueFactory(new PropertyValueFactory("codigoComercio"));
        this.tvcCorreo.setCellValueFactory(new PropertyValueFactory("correoComercio"));
        this.tvcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.tvcDistritoComercio.setCellValueFactory(new PropertyValueFactory("distritoComercio"));
        this.tvcFechaRegistroComercio.setCellValueFactory(new PropertyValueFactory("fechaRegistrocomercio"));
        this.tvcNombreComercio.setCellValueFactory(new PropertyValueFactory("nombreComercio"));
        this.tvcTelefonoComercio.setCellValueFactory(new PropertyValueFactory("telefonoComercio"));
        this.tvcIFechaUltimaActualizacion.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacioncomercio"));
        this.TviewLicenciaComercialLista.setItems(LicenciasComercialeslist);
    }
}
