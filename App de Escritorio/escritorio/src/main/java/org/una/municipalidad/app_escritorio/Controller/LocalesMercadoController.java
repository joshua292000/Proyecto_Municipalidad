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
import org.una.municipalidad.app_escritorio.DTO.LocalesMercadoDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class LocalesMercadoController extends Controller implements Initializable {
    public TableColumn tvcId;
    public TableColumn tvcUltimaActualizacion;
    public TableColumn tvcNombreLocal;
    public TableColumn tvcTelefonoLocal;
    public TableColumn tvcUbicacionLocal;
    public TableColumn tvcCorreoLocal;
    public TableColumn tvcMontoAlquiler;
    public TableColumn tvcEstado;
    public TableColumn tvcFechaRegistro;
    public TableView Tview_LocalesMercadoLista;
    private ObservableList<LocalesMercadoDTO> LocalesMercadolist = FXCollections.observableArrayList();
    private String  ArrayLocales[] ={"id","nombreLocal", "ubicacionLocal" ,"correoLocal", "telefonoLocal", "Monto_Alquiler_Local",
            "fechaRegistrolocal", "ultima_Actualizacionlocal" ,"estado"};

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<LocalesMercadoDTO> localmercado = ConsultasServiceGerente.obtenerTodoLocales();
        if (localmercado != null) {
            for (LocalesMercadoDTO localesmercado : localmercado) {
                LocalesMercadolist.add(new LocalesMercadoDTO(localesmercado.getId(),localesmercado.getNombreLocal(),localesmercado.getUbicacionLocal(), localesmercado.getCorreoLocal(),localesmercado.getTelefonoLocal(), localesmercado.getMonto_Alquiler_Local(),localesmercado.getFechaRegistrolocal(),localesmercado.getUltima_Actualizacionlocal(),localesmercado.getEstado()));
            }
            this.Tview_LocalesMercadoLista.setItems(LocalesMercadolist);
        }
        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Locales_Mercado", "Se visualiz?? la informaci??n de la tabla locales comerciales", AppContext.getInstance().get("usuario").toString(),Controller.getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
        System.out.print(localmercado);
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void LlenarTabla(){
        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcNombreLocal.setCellValueFactory(new PropertyValueFactory("nombreLocal"));
        this.tvcTelefonoLocal.setCellValueFactory(new PropertyValueFactory("telefonoLocal"));
        this.tvcUbicacionLocal.setCellValueFactory(new PropertyValueFactory("ubicacionLocal"));
        this.tvcMontoAlquiler.setCellValueFactory(new PropertyValueFactory("Monto_Alquiler_Local"));
        this.tvcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this. tvcFechaRegistro.setCellValueFactory(new PropertyValueFactory("fechaRegistrolocal"));
        this.tvcCorreoLocal.setCellValueFactory(new PropertyValueFactory("correoLocal"));
        this.tvcUltimaActualizacion.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacionlocal"));
        this.Tview_LocalesMercadoLista.setItems(LocalesMercadolist);
    }

@SneakyThrows
    public void OnActionbtnGenerarReporte(ActionEvent actionEvent) {
        if(getHola()==12) {
            CrearReporte(Tview_LocalesMercadoLista, ArrayLocales, ArrayLocales.length, "Locales", LocalesMercadolist);
        }
    }
}
