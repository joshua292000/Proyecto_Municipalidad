package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.UsuariosDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceAuditor;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    public JFXButton btnVisualizarInformacion;
    private ObservableList<BitacorasDTO> MovimientosRealizadoslist = FXCollections.observableArrayList();
    private ObservableList<BitacorasDTO> nula = FXCollections.observableArrayList();
    private ObservableList<String> Usuarioslist = FXCollections.observableArrayList();
    public JFXComboBox cbxUsuarios =new JFXComboBox(Usuarioslist);
    String id="";
    String ids="";
    Long numero;
   @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Usuario();
       DatosInicio();
    }
    @Override
    public void initialize() {

    }

    public void Usuario() throws IOException, InterruptedException{
        List<UsuariosDTO> usuario = ConsultasServiceAuditor.usuarioCBX();
        cbxUsuarios.getItems().removeAll();
        for(UsuariosDTO usuarios:usuario){
            Usuarioslist.add(usuarios.getId() +"-"+ usuarios.getNombreUsuario());
        }
        cbxUsuarios.setDisable(false);
        cbxUsuarios.setItems(Usuarioslist);
    }

    @SneakyThrows
    public void DatosInicio(){
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
    public void LlenarTabla(){

        this.tvcId.setCellValueFactory(new PropertyValueFactory("id"));
        this.tvcDescripción.setCellValueFactory(new PropertyValueFactory("bitacoraDescripcion"));
        this.tvcFechaModificacion.setCellValueFactory(new PropertyValueFactory("bitacoraFecha"));
        this.tvcTabla.setCellValueFactory(new PropertyValueFactory("bitacoraTabla"));
        this.tvcNombreUsuario.setCellValueFactory(new PropertyValueFactory("bitacoraUsuario"));
        this.tvcIdUsuario.setCellValueFactory(new PropertyValueFactory("usuario"));
        this.tview_Movimientos.setItems(MovimientosRealizadoslist);
    }

    @SneakyThrows
    public void OnActionbtnVisualizarInformacion(ActionEvent actionEvent) {
       numero= Long.valueOf(0);
       id="";
       ids="";
        for ( int i = 0; i<tview_Movimientos.getItems().size(); i++) {
            tview_Movimientos.getItems().clear();
        }
        id = cbxUsuarios.getValue().toString();
        if(id!=null&&dtFechaDesde.getValue()!=null&&dtFechaHasta.getValue()!=null){
            char [] split = id.toCharArray();
            for(int x=0;x<split.length;x++){
                if(Character.isDigit(split[x])){
                    ids+=split[x];
                }
            }
            numero= Long.valueOf(ids);
            System.out.println("res "+numero);

            List<BitacorasDTO> bitacora = ConsultasServiceAuditor.ObtenerMovimientoUsuarioFecha(numero,dtFechaDesde.getValue(),dtFechaHasta.getValue());
            if(bitacora!=null){
                for(BitacorasDTO bitacoras:bitacora){
                    MovimientosRealizadoslist.add( new  BitacorasDTO(bitacoras.getId(), bitacoras.getBitacoraDescripcion(), bitacoras.getBitacoraTabla(),bitacoras.getBitacoraUsuario(), bitacoras.getBitacoraFecha(), bitacoras.getUsuario()));
                }
              //  AppContext.getInstance().delete("reporte");
               // AppContext.getInstance().set("reporte", MovimientosRealizadoslist);
                this.tview_Movimientos.setItems(MovimientosRealizadoslist);
            }
            System.out.print(bitacora);
            LlenarTabla();

        }
        if(id!=null&&dtFechaDesde.getValue()==null&&dtFechaHasta.getValue()==null){
            char [] split = id.toCharArray();
            for(int x=0;x<split.length;x++){
                if(Character.isDigit(split[x])){
                    ids+=split[x];
                }
            }
            numero= Long.valueOf(ids);
            System.out.println("res "+numero);

            BitacorasDTO bitacora = ConsultasServiceAuditor.ObtenerMovimientoUsuario(numero);
            if(bitacora!=null){
                    MovimientosRealizadoslist.add( new  BitacorasDTO(bitacora.getId(), bitacora.getBitacoraDescripcion(), bitacora.getBitacoraTabla(),bitacora.getBitacoraUsuario(), bitacora.getBitacoraFecha(), bitacora.getUsuario()));

                //  AppContext.getInstance().delete("reporte");
                //AppContext.getInstance().set("reporte", MovimientosRealizadoslist);
                this.tview_Movimientos.setItems(MovimientosRealizadoslist);
            }
            System.out.print(bitacora);
            LlenarTabla();
        }

    }

    public void OnActionbtnVisualizarInformacionsinfiltros(ActionEvent actionEvent) {
        for ( int i = 0; i<tview_Movimientos.getItems().size(); i++) {
            tview_Movimientos.getItems().clear();
        }
        DatosInicio();
    }
}
