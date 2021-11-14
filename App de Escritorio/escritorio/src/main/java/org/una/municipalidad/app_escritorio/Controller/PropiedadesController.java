package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.PropiedadesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PropiedadesController  extends Controller implements Initializable {
    public TableView TviewPropiedadesLista;
    public TableColumn tvcId;
    public TableColumn tvcPerteneceEstado;
    public TableColumn tvcEstado;
    public TableColumn tvcPropiedadMetrosFrente;
    public TableColumn tvcAreaPropiedad;
    public TableColumn tvcDireccion;
    public TableColumn tvcDistrito;
    public TableColumn tvcCanton;
    public TableColumn tvcGeolocalizacion;
    public TableColumn tvcOtrosvalores;
    public TableColumn tvcPlanoPropiedad;
    public TableColumn tvcProvincia;
    public TableColumn tvcValorConstruccion;
    public TableColumn tvcValorterreno;
    public TableColumn tvcZona;
    public TableColumn tvcFechaRegistro;
    public TableColumn tvcUltimaFecha;
    private ObservableList<PropiedadesDTO> Propiedadeslist = FXCollections.observableArrayList();

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<PropiedadesDTO> propiedad = ConsultasServiceGerente.obtenerTodoPropiedades();

        if (propiedad  != null) {
            for (PropiedadesDTO propiedades : propiedad) {
                Propiedadeslist.add(new PropiedadesDTO(propiedades.getPropiedades_id(),propiedades.getPropiedadProvincia(),propiedades.getPropiedadCanton(),propiedades.getPropiedadDistrito(),propiedades.getPropiedadDireccion(),propiedades.getPropiedadGeolocalizacion(),propiedades.getPropiedadArea(),propiedades.getPropiedadPlano(),propiedades.getPropiedadAMetrosFrente(),propiedades.getPropiedadValorTerreno(),propiedades.getPropiedadValorConstruccion(),propiedades.getPropiedadOtrosValores(),propiedades.isPerteneceEstado(),propiedades.getPropiedadZona(),propiedades.isEstado(),propiedades.getPropiedad_fecha_Registro(),propiedades.getPropiedad_fecha_Registro()));
            }
            this.TviewPropiedadesLista.setItems(Propiedadeslist);
        }
        System.out.print(propiedad);
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void LlenarTabla() {
        this.tvcId.setCellValueFactory(new PropertyValueFactory("propiedades_id"));
        this.tvcPerteneceEstado.setCellValueFactory(new PropertyValueFactory("perteneceEstado"));
        this.tvcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.tvcPropiedadMetrosFrente.setCellValueFactory(new PropertyValueFactory("propiedadAMetrosFrente"));
        this.tvcAreaPropiedad.setCellValueFactory(new PropertyValueFactory("propiedadArea"));
        this.tvcDireccion.setCellValueFactory(new PropertyValueFactory("propiedadDireccion"));
        this.tvcDistrito.setCellValueFactory(new PropertyValueFactory("propiedadDistrito"));
        this.tvcCanton.setCellValueFactory(new PropertyValueFactory("propiedadCanton"));
        this.tvcGeolocalizacion.setCellValueFactory(new PropertyValueFactory("propiedadGeolocalizacion"));
        this.tvcOtrosvalores.setCellValueFactory(new PropertyValueFactory("propiedadOtrosValores"));
        this.tvcPlanoPropiedad.setCellValueFactory(new PropertyValueFactory("propiedadPlano"));
        this.tvcProvincia.setCellValueFactory(new PropertyValueFactory("propiedadProvincia"));
        this.tvcValorConstruccion.setCellValueFactory(new PropertyValueFactory("propiedadValorConstruccion"));
        this.tvcValorterreno.setCellValueFactory(new PropertyValueFactory("propiedadValorTerreno"));
        this.tvcZona.setCellValueFactory(new PropertyValueFactory("propiedadZona"));
        this.tvcFechaRegistro.setCellValueFactory(new PropertyValueFactory("propiedad_fecha_Registro"));
        this.tvcUltimaFecha.setCellValueFactory(new PropertyValueFactory("propiedad_ultima_Actualizacion"));
        this.TviewPropiedadesLista.setItems(Propiedadeslist);
    }

}
