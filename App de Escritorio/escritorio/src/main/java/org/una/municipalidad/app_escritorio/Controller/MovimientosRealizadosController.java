package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceAuditor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MovimientosRealizadosController extends Controller implements Initializable {
    public TableColumn tvcId;
    public TableColumn tvcDescripción;
    public TableColumn tvcFechaModificacion;
    public TableColumn tvcTabla;
    public TableColumn tvcNombreUsuario;
    public TableColumn tvcIdUsuario;
    public TableView tview_Movimientos;
    private ObservableList<BitacorasDTO> MovimientosRealizadoslist = FXCollections.observableArrayList();


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<BitacorasDTO> bitacora = ConsultasServiceAuditor.obtenerTodoMovimientos();

        if (bitacora != null) {
            for (BitacorasDTO bitacoras : bitacora) {
                MovimientosRealizadoslist.add(new BitacorasDTO(bitacoras.getId(), bitacoras.getBitacoraDescripcion(), bitacoras.getBitacoraTabla(),bitacoras.getBitacoraUsuario(), bitacoras.getBitacoraFecha(), bitacoras.getUsuario()));
            }
            this.tview_Movimientos.setItems(MovimientosRealizadoslist);
        }
        System.out.print(bitacora);
        LlenarTabla();
    }
    @Override
    public void initialize() {

    }

    public void LlenarTabla(){
        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcDescripción.setCellValueFactory(new PropertyValueFactory("bitacoraDescripcion"));
        this.tvcFechaModificacion.setCellValueFactory(new PropertyValueFactory("bitacoraFecha"));
        this.tvcTabla.setCellValueFactory(new PropertyValueFactory("bitacoraTabla"));
        this.tvcNombreUsuario.setCellValueFactory(new PropertyValueFactory("bitacoraUsuario"));
        this.tvcId.setCellValueFactory(new PropertyValueFactory("usuario"));
        this.tview_Movimientos.setItems(MovimientosRealizadoslist);
    }
}
