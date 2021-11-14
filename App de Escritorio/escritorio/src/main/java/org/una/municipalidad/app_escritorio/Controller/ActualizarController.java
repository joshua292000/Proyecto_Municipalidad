package org.una.municipalidad.app_escritorio.Controller;

import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import javax.swing.*;

public class ActualizarController extends Controller implements Initializable {

    @FXML
    private TableView<LicenciasComercialesDTO> tablaLicencia;

    @FXML
    private TableView<CobrosDTO> tablaCobros;

    @FXML
    private TableView<PropiedadesDTO> tablaPropiedades;

    @FXML
    private TableView<LocalesMercadoDTO> tablaLocales;

    @FXML
    private TableColumn col17;

    @FXML
    private TableColumn col16;

    @FXML
    private TableColumn<PropiedadesDTO, String> col15;

    @FXML
    private TableColumn<PropiedadesDTO, String> col14;

    @FXML
    private TableColumn<PropiedadesDTO, String> col13;

    @FXML
    private TableColumn<PropiedadesDTO, Long> col12;

    @FXML
    private TableColumn<PropiedadesDTO, Long> col11;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colnombreC;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colEstadoC;

    @FXML
    private TableColumn<?, ?> col5I;

    @FXML
    private TableColumn<?, ?> col11I;

    @FXML
    private TableColumn<PropiedadesDTO, String> col8;

    @FXML
    private TableColumn<PropiedadesDTO, Long> col9;

    @FXML
    private TableColumn<?, ?> col9I;

    @FXML
    private TableColumn<PropiedadesDTO, String> col6;

    @FXML
    private TableColumn<PropiedadesDTO, Long> col7;

    @FXML
    private TableColumn<PropiedadesDTO, String> col4;

    @FXML
    private TableColumn<PropiedadesDTO, String> col5;

    @FXML
    private TableColumn<PropiedadesDTO, String> col2;

    @FXML
    private TableColumn<PropiedadesDTO, String> col3;

    @FXML
    private TableColumn<PropiedadesDTO, String> col1;

    @FXML
    private TableColumn<?, ?> col1I;

    @FXML
    private TableColumn colRegistroC;

    @FXML
    private TableColumn<LocalesMercadoDTO, Long> colMontoM;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colCorreoM;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colRegistroM;

    @FXML
    private TableColumn<?, ?> col4I;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colCorreoC;

    @FXML
    private TableColumn<?, ?> col8I;

    @FXML
    private TableColumn<?, ?> col10I;

    @FXML
    private TableColumn<PropiedadesDTO, Long> col10;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colDistritoC;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableColumn<LicenciasComercialesDTO, Long> colTelefonoC;

    @FXML
    private Pane Panefondo;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colCodigoC;

    @FXML
    private TableColumn colActuaC;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colIdM;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<CobrosDTO, Long> col3I;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colNombreM;

    @FXML
    private TableColumn<?, ?> col7I;

    @FXML
    private TableColumn<LicenciasComercialesDTO, String> colIdC;

    @FXML
    private TableColumn<LocalesMercadoDTO, Long> colTelefonoM;

    @FXML
    private Button btnActualizar;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colEstadoM;

    @FXML
    private HBox itemC;

    @FXML
    private TableColumn<CobrosDTO, String> col2I;

    @FXML
    private TableColumn<?, ?> colActualizacionM;

    @FXML
    private TableColumn<CobrosDTO, String> col6I;

    @FXML
    private TableColumn<?, ?> col12I;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<LocalesMercadoDTO, String> colUbicacionM;

    private String Tipo;
    private String SolicitarEliminar = "Eliminando";
    private LocalDate fechaRegistro = LocalDate.parse("2021-11-12");
    private ObservableList<CobrosDTO> listaCobros = FXCollections.observableArrayList();
    private ObservableList<LicenciasComercialesDTO> listaLicencia = FXCollections.observableArrayList();
    private ObservableList<LocalesMercadoDTO> listaLocales = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> listaPropiedades = FXCollections.observableArrayList();
    private BooleanProperty _activo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        LlenarTablaLicencia();
        LlenarTablaLocal();
        LlenarTablaCobros();
        LlenarTablaPropiedad();
    }

    @Override
    public void initialize() {

    }

    public final BooleanProperty activoProperty(){
        return this._activo;
    }

    public void OnActionActualizar(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(Tipo=="Licencia") {

            for (int x = 0; x < listaLicencia.size(); x++) {
                LicenciasComercialesDTO licencia = ConsultasGestorService.ActualizarLicenciaComercial(listaLicencia.get(x).getId(), listaLicencia.get(x).getNombreComercio(), listaLicencia.get(x).getTelefonoComercio(), listaLicencia.get(x).getCorreoComercio(), listaLicencia.get(x).getDistritoComercio(), fechaRegistro, fechaRegistro, listaLicencia.get(x).getCodigoComercio(), listaLicencia.get(x).getEstado());
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaLicencia.getItems().clear();
        }
        else if(Tipo=="Local") {
            for (int x = 0; x < listaLocales.size(); x++) {
                LocalesMercadoDTO local = ConsultasGestorService.ActualizarLocalMercado(listaLocales.get(x).getId(),listaLocales.get(x).getNombreLocal(),listaLocales.get(x).getUbicacionLocal(),listaLocales.get(x).getCorreoLocal(),listaLocales.get(x).getTelefonoLocal(),listaLocales.get(x).getMonto_Alquiler_Local(),fechaRegistro,fechaRegistro,listaLocales.get(x).getEstado());
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaLocales.getItems().clear();
        }
        else if(Tipo=="Propiedad") {
            for (int x = 0; x < listaPropiedades.size(); x++) {
                PropiedadesDTO local = ConsultasGestorService.ActualizarPropiedad(listaPropiedades.get(x).getPropiedades_id(),listaPropiedades.get(x).getPropiedadProvincia(),listaPropiedades.get(x).getPropiedadCanton(),
                        listaPropiedades.get(x).getPropiedadDistrito(),listaPropiedades.get(x).getPropiedadDireccion(),listaPropiedades.get(x).getPropiedadGeolocalizacion(),listaPropiedades.get(x).getPropiedadArea(),
                        listaPropiedades.get(x).getPropiedadPlano(),listaPropiedades.get(x).getPropiedadAMetrosFrente(),listaPropiedades.get(x).getPropiedadValorTerreno(),listaPropiedades.get(x).getPropiedadValorConstruccion(),
                        listaPropiedades.get(x).getPropiedadOtrosValores(),listaPropiedades.get(x).isPerteneceEstado(),listaPropiedades.get(x).getPropiedadZona(),listaPropiedades.get(x).getEstado(),fechaRegistro,fechaRegistro);
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaPropiedades.getItems().clear();
        }
    }

    public void OnActionBuscar(ActionEvent actionEvent) throws IOException, InterruptedException {
        btnActualizar.setDisable(false);
        btnEliminar.setDisable(false);
        if(txtCedula.getLength()==0){
            JOptionPane.showMessageDialog(null,"El campo cedula se encuentra vacio, porfavor digite una cedula");
        }else{
            if(Tipo=="Licencia"){
                List<LicenciasComercialesDTO> licencia= ConsultasGestorService.ObtenerLicencia(txtCedula.getText());
                if(licencia!=null){
                    for(LicenciasComercialesDTO licencias:licencia){
                        listaLicencia.add(new LicenciasComercialesDTO(licencias.getId(),licencias.getNombreComercio(),licencias.getTelefonoComercio(),licencias.getCorreoComercio(),licencias.getDistritoComercio(),licencias.getFechaRegistrocomercio(),licencias.getUltima_Actualizacioncomercio(),licencias.getCodigoComercio(),licencias.getEstado()));
                    }
                    this.tablaLicencia.setItems(listaLicencia);
                }

            }else if(Tipo=="Local"){
                List<LocalesMercadoDTO> local= ConsultasGestorService.ObtenerLocal(txtCedula.getText());
                if(local!=null){
                    for(LocalesMercadoDTO locales:local){
                        listaLocales.add(new LocalesMercadoDTO(locales.getId(),locales.getNombreLocal(),locales.getUbicacionLocal(),locales.getCorreoLocal(),locales.getTelefonoLocal(),locales.getMonto_Alquiler_Local(),locales.getFechaRegistrolocal(),locales.getUltima_Actualizacionlocal(),locales.getEstado()));
                    }
                    this.tablaLocales.setItems(listaLocales);
                }
            }else if(Tipo=="Propiedad"){
                List<PropiedadesDTO> propiedad= ConsultasGestorService.ObtenerPropiedad(txtCedula.getText());
                if(propiedad!=null){
                    for(PropiedadesDTO propiedades:propiedad){
                        listaPropiedades.add(new PropiedadesDTO(propiedades.getPropiedades_id(),propiedades.getPropiedadProvincia(),propiedades.getPropiedadCanton(),
                                propiedades.getPropiedadDistrito(),propiedades.getPropiedadDireccion(),propiedades.getPropiedadGeolocalizacion(),propiedades.getPropiedadArea(),
                                propiedades.getPropiedadPlano(),propiedades.getPropiedadAMetrosFrente(),propiedades.getPropiedadValorTerreno(),propiedades.getPropiedadValorConstruccion(),
                                propiedades.getPropiedadOtrosValores(),propiedades.isPerteneceEstado(),propiedades.getPropiedadZona(),propiedades.getEstado(),propiedades.getPropiedad_fecha_Registro(),
                                propiedades.getPropiedad_ultima_Actualizacion()));
                    }
                    this.tablaPropiedades.setItems(listaPropiedades);
                }
            }else if(Tipo=="Cobros"){
                List<CobrosDTO> cobro= ConsultasGestorService.obtenerCobro(txtCedula.getText());
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        listaCobros.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomerciales(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    this.tablaCobros.setItems(listaCobros);
                }
            }
        }
    }

    public void OnActionEliminar(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(Tipo=="Licencia") {

            for (int x = 0; x < listaLicencia.size(); x++) {
                LicenciasComercialesDTO licencia = ConsultasGestorService.ActualizarLicenciaComercial(listaLicencia.get(x).getId(), listaLicencia.get(x).getNombreComercio(), listaLicencia.get(x).getTelefonoComercio(), listaLicencia.get(x).getCorreoComercio(), listaLicencia.get(x).getDistritoComercio(), fechaRegistro, fechaRegistro, listaLicencia.get(x).getCodigoComercio(), SolicitarEliminar);
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaLicencia.getItems().clear();
        }
        else if(Tipo=="Local") {
            for (int x = 0; x < listaLocales.size(); x++) {
                LocalesMercadoDTO local = ConsultasGestorService.ActualizarLocalMercado(listaLocales.get(x).getId(),listaLocales.get(x).getNombreLocal(),listaLocales.get(x).getUbicacionLocal(),listaLocales.get(x).getCorreoLocal(),listaLocales.get(x).getTelefonoLocal(),listaLocales.get(x).getMonto_Alquiler_Local(),fechaRegistro,fechaRegistro,SolicitarEliminar);
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaLocales.getItems().clear();
        }
        else if(Tipo=="Propiedad") {
            for (int x = 0; x < listaPropiedades.size(); x++) {
                PropiedadesDTO local = ConsultasGestorService.ActualizarPropiedad(listaPropiedades.get(x).getPropiedades_id(),listaPropiedades.get(x).getPropiedadProvincia(),listaPropiedades.get(x).getPropiedadCanton(),
                        listaPropiedades.get(x).getPropiedadDistrito(),listaPropiedades.get(x).getPropiedadDireccion(),listaPropiedades.get(x).getPropiedadGeolocalizacion(),listaPropiedades.get(x).getPropiedadArea(),
                        listaPropiedades.get(x).getPropiedadPlano(),listaPropiedades.get(x).getPropiedadAMetrosFrente(),listaPropiedades.get(x).getPropiedadValorTerreno(),listaPropiedades.get(x).getPropiedadValorConstruccion(),
                        listaPropiedades.get(x).getPropiedadOtrosValores(),listaPropiedades.get(x).isPerteneceEstado(),listaPropiedades.get(x).getPropiedadZona(),SolicitarEliminar,fechaRegistro,fechaRegistro);
            }
            JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
            tablaPropiedades.getItems().clear();
        }

    }

    public void SeleccionCobros(Event event) {
        Tipo = "Cobros";
    }

    public void SeleccionPropiedad(Event event) {
        Tipo = "Propiedad";
    }

    public void SeleccionLocal(Event event) {
        Tipo = "Local";
    }

    public void SeleccionLicencia(Event event) {
        Tipo = "Licencia";
    }

    public void LlenarTablaLicencia(){

        tablaLicencia.setEditable(true);
        this.colIdC.setCellValueFactory(new PropertyValueFactory("id"));

        this.colnombreC.setCellValueFactory(new PropertyValueFactory("nombreComercio"));
        this.colnombreC.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colnombreC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setNombreComercio(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colTelefonoC.setCellValueFactory(new PropertyValueFactory("telefonoComercio"));
        this.colTelefonoC.setCellFactory(TextFieldTableCell.<LicenciasComercialesDTO, Long>forTableColumn(new LongStringConverter()));
        this.colTelefonoC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setTelefonoComercio(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.colCorreoC.setCellValueFactory(new PropertyValueFactory("correoComercio"));
        this.colCorreoC.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colCorreoC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setCorreoComercio(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colDistritoC.setCellValueFactory(new PropertyValueFactory("distritoComercio"));
        this.colDistritoC.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colDistritoC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setDistritoComercio(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colRegistroC.setCellValueFactory(new PropertyValueFactory("fechaRegistrocomercio"));
        this.colActuaC.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacioncomercio"));

        this.colCodigoC.setCellValueFactory(new PropertyValueFactory("codigoComercio"));
        this.colCodigoC.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colCodigoC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setCodigoComercio(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colEstadoC.setCellValueFactory(new PropertyValueFactory("estado"));
        this.colEstadoC.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colEstadoC.setOnEditCommit(
                data->{
                    LicenciasComercialesDTO con = data.getRowValue();
                    con.setEstado(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.tablaLicencia.setItems(listaLicencia);
    }

    public void LlenarTablaLocal(){
        tablaLicencia.setEditable(true);
        this.colIdM.setCellValueFactory(new PropertyValueFactory("id"));

        this.colNombreM.setCellValueFactory(new PropertyValueFactory("nombreLocal"));
        this.colNombreM.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colNombreM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setNombreLocal(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colUbicacionM.setCellValueFactory(new PropertyValueFactory("ubicacionLocal"));
        this.colUbicacionM.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colUbicacionM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setUbicacionLocal(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colCorreoM.setCellValueFactory(new PropertyValueFactory("correoLocal"));
        this.colCorreoM.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colCorreoM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setCorreoLocal(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.colTelefonoM.setCellValueFactory(new PropertyValueFactory("telefonoLocal"));
        this.colTelefonoM.setCellFactory(TextFieldTableCell.<LocalesMercadoDTO, Long>forTableColumn(new LongStringConverter()));
        this.colTelefonoM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setTelefonoLocal(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.colMontoM.setCellValueFactory(new PropertyValueFactory("Monto_Alquiler_Local"));
        this.colMontoM.setCellFactory(TextFieldTableCell.<LocalesMercadoDTO, Long>forTableColumn(new LongStringConverter()));
        this.colMontoM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setMonto_Alquiler_Local(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.colRegistroM.setCellValueFactory(new PropertyValueFactory("fechaRegistrolocal"));
        this.colActualizacionM.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacionlocal"));

        this.colEstadoM.setCellValueFactory(new PropertyValueFactory("estado"));
        this.colEstadoM.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colEstadoM.setOnEditCommit(
                data->{
                    LocalesMercadoDTO con = data.getRowValue();
                    con.setEstado(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.tablaLocales.setItems(listaLocales);
    }

    public void LlenarTablaPropiedad(){
        tablaLicencia.setEditable(true);
        this.col1.setCellValueFactory(new PropertyValueFactory("propiedades_id"));

        this.col2.setCellValueFactory(new PropertyValueFactory("propiedadProvincia"));
        this.col2.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col2.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadProvincia(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col3.setCellValueFactory(new PropertyValueFactory("propiedadCanton"));
        this.col3.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col3.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadCanton(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col4.setCellValueFactory(new PropertyValueFactory("propiedadDistrito"));
        this.col4.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col4.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadDistrito(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col5.setCellValueFactory(new PropertyValueFactory("propiedadDireccion"));
        this.col5.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col5.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadDireccion(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col6.setCellValueFactory(new PropertyValueFactory("propiedadGeolocalizacion"));
        this.col6.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col6.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadGeolocalizacion(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col7.setCellValueFactory(new PropertyValueFactory("propiedadArea"));
        this.col7.setCellFactory(TextFieldTableCell.<PropiedadesDTO, Long>forTableColumn(new LongStringConverter()));
        this.col7.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadArea(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col8.setCellValueFactory(new PropertyValueFactory("propiedadPlano"));
        this.col8.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col8.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadPlano(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col9.setCellValueFactory(new PropertyValueFactory("propiedadAMetrosFrente"));
        this.col9.setCellFactory(TextFieldTableCell.<PropiedadesDTO, Long>forTableColumn(new LongStringConverter()));
        this.col9.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadAMetrosFrente(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col10.setCellValueFactory(new PropertyValueFactory("propiedadValorTerreno"));
        this.col10.setCellFactory(TextFieldTableCell.<PropiedadesDTO, Long>forTableColumn(new LongStringConverter()));
        this.col10.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadValorTerreno(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col11.setCellValueFactory(new PropertyValueFactory("propiedadValorConstruccion"));
        this.col11.setCellFactory(TextFieldTableCell.<PropiedadesDTO, Long>forTableColumn(new LongStringConverter()));
        this.col11.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadValorConstruccion(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col12.setCellValueFactory(new PropertyValueFactory("propiedadOtrosValores"));
        this.col12.setCellFactory(TextFieldTableCell.<PropiedadesDTO, Long>forTableColumn(new LongStringConverter()));
        this.col12.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadOtrosValores(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col13.setCellValueFactory(new PropertyValueFactory("PerteneceEstado"));
        this.col13.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col13.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPerteneceEstado(Boolean.parseBoolean(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.col14.setCellValueFactory(new PropertyValueFactory("propiedadZona"));
        this.col14.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col14.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setPropiedadZona(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col15.setCellValueFactory(new PropertyValueFactory("estado"));
        this.col15.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col15.setOnEditCommit(
                data->{
                    PropiedadesDTO con = data.getRowValue();
                    con.setEstado(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.col16.setCellValueFactory(new PropertyValueFactory("propiedad_fecha_Registro"));
        this.col17.setCellValueFactory(new PropertyValueFactory("propiedad_ultima_Actualizacion"));

        this.tablaPropiedades.setItems(listaPropiedades);
    }

    public void LlenarTablaCobros() {
        this.col1I.setCellValueFactory(new PropertyValueFactory("id"));

        this.col2I.setCellValueFactory(new PropertyValueFactory("cobrosPeriodo"));
        this.col2I.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col2I.setOnEditCommit(
                data->{
                    CobrosDTO con = data.getRowValue();
                    con.setCobrosPeriodo(data.getNewValue());
                }
        );
        this.col3I.setCellValueFactory(new PropertyValueFactory("cobrosMonto"));
        this.col3I.setCellFactory(TextFieldTableCell.<CobrosDTO, Long>forTableColumn(new LongStringConverter()));
        this.col3I.setOnEditCommit(
                data->{
                    CobrosDTO con = data.getRowValue();
                    con.setCobrosMonto(Long.valueOf(data.getNewValue()));
                }
        );
        this.col4I.setCellValueFactory(new PropertyValueFactory("cobrosFechaCreacion"));
        this.col5I.setCellValueFactory(new PropertyValueFactory("cobrosFechaVencimiento"));
        this.col6I.setCellValueFactory(new PropertyValueFactory("Estado"));
        this.col6I.setCellFactory(TextFieldTableCell.forTableColumn());
        this.col6I.setOnEditCommit(
                data->{
                    CobrosDTO con = data.getRowValue();
                    con.setEstado(data.getNewValue());
                }
        );
        this.col7I.setCellValueFactory(new PropertyValueFactory("cobrosFechaPago"));
        this.col8I.setCellValueFactory(new PropertyValueFactory("licenciacomerciales"));
        this.col9I.setCellValueFactory(new PropertyValueFactory("facturas"));
        this.col10I.setCellValueFactory(new PropertyValueFactory("tipocobros"));
        this.col11I.setCellValueFactory(new PropertyValueFactory("localesmercado"));
        this.col12I.setCellValueFactory(new PropertyValueFactory("propiedades"));

        this.tablaCobros.setItems(listaCobros);
    }
}
