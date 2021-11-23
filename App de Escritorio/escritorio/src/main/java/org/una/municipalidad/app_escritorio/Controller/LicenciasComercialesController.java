package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.LicenciasComercialesDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;
import org.una.municipalidad.app_escritorio.Util.AppContext;

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
    private String  ArrayLicencias[] ={"id","nombreComercio","telefonoComercio","correoComercio","distritoComercio","fechaRegistrocomercio","ultima_Actualizacioncomercio",
            "codigoComercio","estado"};

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<LicenciasComercialesDTO> licenciacomercial = ConsultasServiceGerente.obtenerTodoLicencias();

        if (licenciacomercial != null) {
            for (LicenciasComercialesDTO licenciascomerciales : licenciacomercial) {
                LicenciasComercialeslist.add(new LicenciasComercialesDTO(licenciascomerciales.getId(), licenciascomerciales.getNombreComercio(), licenciascomerciales.getTelefonoComercio(), licenciascomerciales.getCorreoComercio(), licenciascomerciales.getDistritoComercio(), licenciascomerciales.getFechaRegistrocomercio(), licenciascomerciales.getUltima_Actualizacioncomercio(), licenciascomerciales.getCodigoComercio(), licenciascomerciales.getEstado()));
            }
            this.TviewLicenciaComercialLista.setItems(LicenciasComercialeslist);
        }
        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Licencias_Comerciales", "Se visualizó la información de la tabla licencias comerciales", AppContext.getInstance().get("usuario").toString(),Controller.getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
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
    @SneakyThrows
    public void OnActionbtnGenerarReporte(ActionEvent actionEvent) {
        if(getHola()==13){
            CrearReporte(TviewLicenciaComercialLista,ArrayLicencias,ArrayLicencias.length,"Licencias",LicenciasComercialeslist);
        }

    }
}
