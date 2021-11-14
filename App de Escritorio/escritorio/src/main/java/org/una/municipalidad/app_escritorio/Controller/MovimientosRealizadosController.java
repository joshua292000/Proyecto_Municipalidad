package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
    public DatePicker dtFechaDesde;
    public DatePicker dtFechaHasta;
    private ObservableList<BitacorasDTO> MovimientosRealizadoslist = FXCollections.observableArrayList();
    private ObservableList<String> Usuarioslist = FXCollections.observableArrayList();
    public JFXComboBox cbxUsuarios =new JFXComboBox(Usuarioslist);

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<BitacorasDTO> bitacora = ConsultasServiceAuditor.obtenerTodoMovimientos();
        List<UsuariosDTO>usuario=ConsultasServiceAuditor.obtenerTodoUsuarios();
        if(usuario!=null){
            for(UsuariosDTO usuarios : usuario){
                Usuarioslist.add(String.valueOf(new UsuariosDTO(usuarios.getId(),usuarios.getCedula(),usuarios.getNombreUsuario(),usuarios.getClaveEncriptado(),usuarios.isEstado(),usuarios.getRoles())));
            }
        }
        //Usuarioslist.add(new UsuariosDTO())
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
        this.tvcIdUsuario.setCellValueFactory(new PropertyValueFactory("usuario"));
        this.tview_Movimientos.setItems(MovimientosRealizadoslist);
    }
}
