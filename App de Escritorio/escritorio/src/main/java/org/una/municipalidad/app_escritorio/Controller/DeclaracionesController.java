package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.DeclaracionesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceAuditor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeclaracionesController extends Controller implements Initializable {
    public TableView Tview_DeclaracionesLista;
    public TableColumn tvcId;
    public TableColumn tvcFechaDeclarado;
    public TableColumn tvcMontoDeclarado;
    public TableColumn tvcIdLicencia;
    private ObservableList<DeclaracionesDTO> Declaracioneslist = FXCollections.observableArrayList();

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<DeclaracionesDTO> declaracion = ConsultasServiceAuditor.obtenerTodoDeclaraciones();
        if (declaracion != null) {
            for (DeclaracionesDTO declaraciones : declaracion) {
                Declaracioneslist.add(new DeclaracionesDTO(declaraciones.getId(),declaraciones.getMontoDeclarado(), declaraciones.getFechaDeclarado(), declaraciones.getLicenciacomercial()));
            }
            this.Tview_DeclaracionesLista.setItems(Declaracioneslist);
        }
        System.out.print(declaracion);
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void LlenarTabla(){
        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcFechaDeclarado.setCellValueFactory(new PropertyValueFactory("bitacoraDescripcion"));
        this.tvcMontoDeclarado.setCellValueFactory(new PropertyValueFactory("bitacoraFecha"));
        this.tvcIdLicencia.setCellValueFactory(new PropertyValueFactory("bitacoraTabla"));
        this.Tview_DeclaracionesLista.setItems(Declaracioneslist);
    }
}
