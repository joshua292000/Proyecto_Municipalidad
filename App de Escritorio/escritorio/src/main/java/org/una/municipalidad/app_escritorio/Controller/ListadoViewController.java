package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ListadoViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private JFXButton btnImprime;

    @FXML
    private ScrollPane ScPane;

    @FXML
    private TableView Tvdatos;

    @FXML
    private TableColumn Col11;

    @FXML
    private TableColumn Col12;

    @FXML
    private TableColumn Col1;

    @FXML
    private TableColumn Col2;

    @FXML
    private TableColumn Col3;

    @FXML
    private TableColumn Col4;

    @FXML
    private TableColumn Col5;

    @FXML
    private TableColumn Col6;

    @FXML
    private TableColumn Col7;

    @FXML
    private TableColumn Col8;

    @FXML
    private TableColumn Col9;

    @FXML
    private TableColumn Col10;

    @FXML
    private TableColumn Col13;

    @FXML
    private TableColumn Col14;

    @FXML
    private TableColumn Col15;

    @FXML
    private TableColumn Col16;

    @FXML
    private TableColumn Col17;


    @FXML
    private JFXButton btnGenerar;

    private ObservableList<CobrosDTO> options = FXCollections.observableArrayList();
    private ObservableList<ContribuyentesDTO> optionscont = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Locales_MercadoDTO> optionscontLoc = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Licencias_ComercialesDTO> optionscontLic = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_PropiedadesDTO> optionscontPro = FXCollections.observableArrayList();
    private ObservableList<LocalesMercadoDTO> optionsLoc = FXCollections.observableArrayList();
    private ObservableList<LicenciasComercialesDTO> optionsLic = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> optionsPro = FXCollections.observableArrayList();
    private ObservableList<ParametrosDTO> optionspar = FXCollections.observableArrayList();
    private String  ArrayCobro[] ={"id","cobrosPeriodo","cobrosMonto","cobrosFechaCreacion","cobrosFechaVencimiento","Estado","cobrosFechaPago",
            "licenciacomerciales","facturas","tipocobros","localesmercado","propiedades"};

    private String  ArrayPropiedad[] ={"propiedades_id","propiedadProvincia","propiedadCanton","propiedadDistrito","propiedadDireccion","propiedadGeolocalizacion","propiedadArea",
            "propiedadPlano","propiedadAMetrosFrente","propiedadValorTerreno","propiedadValorConstruccion","propiedadOtrosValores","PerteneceEstado","propiedadZona","Estado","propiedad_fecha_Registro","propiedad_ultima_Actualizacion"};

    private String  ArrayLicencias[] ={"id","nombreComercio","telefonoComercio","correoComercio","distritoComercio","fechaRegistrocomercio","ultima_Actualizacioncomercio",
            "codigoComercio","estado"};

    private String  ArrayLocales[] ={"id","nombreLocal", "ubicacionLocal" ,"correoLocal", "telefonoLocal", "Monto_Alquiler_Local",
            "fechaRegistrolocal", "ultima_Actualizacionlocal" ,"estado"};

    private String  ArrayParametros[] ={ "id","llaveParametro","valorParametro"};
    public int Consulta=0;
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGenerar.setVisible(false);
        btnEliminar.setVisible(false);
        btnImprime.setVisible(false);
        switch (Controller.getHola()){
            case 1: {
                Consulta=1;
                List<CobrosDTO> cobro = ConsultasServiceGerente.obtenerTodoCobroXEsatado("Eliminando");
                if (cobro != null) {
                    for (CobrosDTO cobros : cobro) {
                        options.add(new CobrosDTO(cobros.getId(), cobros.getCobrosPeriodo(), cobros.getCobrosMonto(), cobros.getCobrosFechaCreacion(), cobros.getCobrosFechaVencimiento(), cobros.getEstado(), cobros.getCobrosFechaPago(), cobros.getLicenciascomerciales(), cobros.getFacturas(), cobros.getTipocobros(), cobros.getLocalesmercado(), cobros.getPropiedades()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(options);
                }
                //System.out.print(cobro);
                LlenarTabla();
                btnEliminar.setVisible(true);
                break;
            }
            case 2: {
                Consulta=2;
                List<LicenciasComercialesDTO> Licecias= ConsultasServiceGerente.obtenerTodoLicenciasxEstado("Eliminando");
                if(Licecias!=null){
                    for(LicenciasComercialesDTO lic:Licecias){
                        optionsLic.add(new LicenciasComercialesDTO(lic.getId(),lic.getNombreComercio(),lic.getTelefonoComercio(),lic.getCorreoComercio(),lic.getDistritoComercio(),lic.getFechaRegistrocomercio(),lic.getUltima_Actualizacioncomercio(),lic.getCodigoComercio(),lic.getEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLic);
                }
                LlenarTablaLic();
                btnEliminar.setVisible(true);
                break;
            }
            case 3: {
                Consulta=3;
                List<PropiedadesDTO> propiedad= ConsultasServiceGerente.obtenerTodoPropiedadesxEstado("Eliminando");
                if(propiedad!=null){
                    for(PropiedadesDTO pro:propiedad){
                        optionsPro.add(new PropiedadesDTO(pro.getPropiedades_id(),pro.getPropiedadProvincia(),pro.getPropiedadCanton(),pro.getPropiedadDistrito(),pro.getPropiedadDireccion(),pro.getPropiedadGeolocalizacion(),pro.getPropiedadArea(),pro.getPropiedadPlano(),pro.getPropiedadAMetrosFrente(),pro.getPropiedadValorTerreno(),pro.getPropiedadValorConstruccion(),pro.getPropiedadOtrosValores(),pro.isPerteneceEstado(),pro.getPropiedadZona(),pro.getEstado(),pro.getPropiedad_fecha_Registro(),pro.getPropiedad_fecha_Registro()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsPro);
                }
                LlenarTablaPro();
                btnEliminar.setVisible(true);
                break;
            }
            case 4: {
                Consulta=4;
                List<LocalesMercadoDTO> local= ConsultasServiceGerente.obtenerTodoLocalesxEstado("Eliminando");
                if(local!=null){
                    for(LocalesMercadoDTO loc:local){
                        optionsLoc.add(new LocalesMercadoDTO(loc.getId(),loc.getNombreLocal(),loc.getUbicacionLocal(),loc.getCorreoLocal(),loc.getTelefonoLocal(),loc.getMonto_Alquiler_Local(),loc.getFechaRegistrolocal(),loc.getUltima_Actualizacionlocal(),loc.getEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLoc);
                }
                LlenarTablaLoc();
                btnEliminar.setVisible(true);
                break;
            }

            case 5: {
                List<CobrosDTO> cobro= ConsultasServiceGerente.obtenerTodoCobroXFechas(LocalDate.parse(getParametro()),LocalDate.parse(getParametro2()));
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciascomerciales(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    this.Tvdatos.setItems(options);
                }
                LlenarTabla();
                btnGenerar.setVisible(true);
                break;
            }

            case 6: {
                List<PropiedadesDTO> propiedad= ConsultasGestorService.ObtenerPropiedad(getParametro());
                if(propiedad!=null){
                    for(PropiedadesDTO pro:propiedad){
                        optionsPro.add(new PropiedadesDTO(pro.getPropiedades_id(),pro.getPropiedadProvincia(),pro.getPropiedadCanton(),pro.getPropiedadDistrito(),pro.getPropiedadDireccion(),pro.getPropiedadGeolocalizacion(),pro.getPropiedadArea(),pro.getPropiedadPlano(),pro.getPropiedadAMetrosFrente(),pro.getPropiedadValorTerreno(),pro.getPropiedadValorConstruccion(),pro.getPropiedadOtrosValores(),pro.isPerteneceEstado(),pro.getPropiedadZona(),pro.getEstado(),pro.getPropiedad_fecha_Registro(),pro.getPropiedad_fecha_Registro()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsPro);
                }
                LlenarTablaPro();
                btnGenerar.setVisible(true);
                break;
            }

            case 7: {
                List<LicenciasComercialesDTO> Licecias= ConsultasGestorService.ObtenerLicencia(getParametro());
                if(Licecias!=null){
                    for(LicenciasComercialesDTO lic:Licecias){
                        optionsLic.add(new LicenciasComercialesDTO(lic.getId(),lic.getNombreComercio(),lic.getTelefonoComercio(),lic.getCorreoComercio(),lic.getDistritoComercio(),lic.getFechaRegistrocomercio(),lic.getUltima_Actualizacioncomercio(),lic.getCodigoComercio(),lic.getEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLic);
                }
                LlenarTablaLic();
                btnGenerar.setVisible(true);
                break;
            }

            case 8: {
                List<LocalesMercadoDTO> local= ConsultasGestorService.ObtenerLocal(getParametro());
                if(local!=null){
                    for(LocalesMercadoDTO loc:local){
                        optionsLoc.add(new LocalesMercadoDTO(loc.getId(),loc.getNombreLocal(),loc.getUbicacionLocal(),loc.getCorreoLocal(),loc.getTelefonoLocal(),loc.getMonto_Alquiler_Local(),loc.getFechaRegistrolocal(),loc.getUltima_Actualizacionlocal(),loc.getEstado()));
                    }
                    this.Tvdatos.setItems(optionsLoc);
                }
                LlenarTablaLoc();
                btnGenerar.setVisible(true);
                break;
            }

            case 9: {
                List<ParametrosDTO> Para= ConsultasServiceGerente.obtenerTodoParametros();
                if(Para!=null){
                    for(ParametrosDTO par:Para){
                        optionspar.add(new ParametrosDTO(par.getId(),par.getLlaveParametro(),par.getValorParametro()));
                    }
                    this.Tvdatos.setItems(optionspar);
                }
                LlenarTablaPar();
                btnGenerar.setVisible(true);
                break;
            }
            case 10: {
                List<CobrosDTO> cobro = ConsultasServiceGerente.obtenerTodoCobroXEsatado("Pendiente");
                if (cobro != null) {
                    for (CobrosDTO cobros : cobro) {
                        options.add(new CobrosDTO(cobros.getId(), cobros.getCobrosPeriodo(), cobros.getCobrosMonto(), cobros.getCobrosFechaCreacion(), cobros.getCobrosFechaVencimiento(), cobros.getEstado(), cobros.getCobrosFechaPago(), cobros.getLicenciascomerciales(), cobros.getFacturas(), cobros.getTipocobros(), cobros.getLocalesmercado(), cobros.getPropiedades()));
                    }
                    this.Tvdatos.setItems(options);
                }
                LlenarTabla();
                break;
            }
        }

    }

    @Override
    public void initialize() {

    }
    public void LlenarTabla(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("cobrosPeriodo"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("cobrosMonto"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("cobrosFechaCreacion"));
        this.Col5.setCellValueFactory(new PropertyValueFactory("cobrosFechaVencimiento"));
        this.Col6.setCellValueFactory(new PropertyValueFactory("Estado"));
        this.Col7.setCellValueFactory(new PropertyValueFactory("cobrosFechaPago"));
        this.Col8.setCellValueFactory(new PropertyValueFactory("licenciacomercial"));
        this.Col9.setCellValueFactory(new PropertyValueFactory("facturas"));
        this.Col10.setCellValueFactory(new PropertyValueFactory("tipocobros"));
        this.Col11.setCellValueFactory(new PropertyValueFactory("localesmercado"));
        this.Col12.setCellValueFactory(new PropertyValueFactory("propiedades"));
        Col1.setText("id");
        Col2.setText("cobrosPeriodo");
        Col3.setText("cobrosMonto");
        Col4.setText("cobrosFechaCreacion");
        Col5.setText("cobrosFechaVencimiento");
        Col6.setText("Estado");
        Col7.setText("cobrosFechaPago");
        Col8.setText("licenciacomercial");
        Col9.setText("facturas");
        Col10.setText("tipocobros");
        Col11.setText("localesmercado");
        Col12.setText("propiedades");
        Col13.setVisible(false);
        Col14.setVisible(false);
        Col15.setVisible(false);
        Col16.setVisible(false);
        Col17.setVisible(false);
        this.Tvdatos.setItems(options);
    }
    public void LlenarTablaPar(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("llaveParametro"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("valorParametro"));
        Col1.setText("id");
        Col2.setText("llaveParametro");
        Col3.setText("valorParametro");
        Col4.setVisible(false);
        Col5.setVisible(false);
        Col6.setVisible(false);
        Col7.setVisible(false);
        Col8.setVisible(false);
        Col9.setVisible(false);
        Col10.setVisible(false);
        Col11.setVisible(false);
        Col12.setVisible(false);
        Col13.setVisible(false);
        Col14.setVisible(false);
        Col15.setVisible(false);
        Col16.setVisible(false);
        Col17.setVisible(false);
        this.Tvdatos.setItems(optionspar);
    }
    public void LlenarTablaLic(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("nombreComercio"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("telefonoComercio"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("correoComercio"));
        this.Col5.setCellValueFactory(new PropertyValueFactory("distritoComercio"));
        this.Col6.setCellValueFactory(new PropertyValueFactory("fechaRegistrocomercio"));
        this.Col7.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacioncomercio"));
        this.Col8.setCellValueFactory(new PropertyValueFactory("codigoComercio"));
        this.Col9.setCellValueFactory(new PropertyValueFactory("estado"));
        Col1.setText("id");
        Col2.setText("nombreComercio");
        Col3.setText("telefonoComercio");
        Col4.setText("correoComercio");
        Col5.setText("distritoComercio");
        Col6.setText("fechaRegistrocomercio");
        Col7.setText("ultima_Actualizacioncomercio");
        Col8.setText("codigoComercio");
        Col9.setText("estado");
        Col10.setVisible(false);
        Col11.setVisible(false);
        Col12.setVisible(false);
        Col13.setVisible(false);
        Col14.setVisible(false);
        Col15.setVisible(false);
        Col16.setVisible(false);
        Col17.setVisible(false);
        this.Tvdatos.setItems(optionsLic);
    }

    public void LlenarTablaPro(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("propiedades_id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("propiedadProvincia"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("propiedadCanton"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("propiedadDistrito"));
        this.Col5.setCellValueFactory(new PropertyValueFactory("propiedadDireccion"));
        this.Col6.setCellValueFactory(new PropertyValueFactory("propiedadGeolocalizacion"));
        this.Col7.setCellValueFactory(new PropertyValueFactory("propiedadArea"));
        this.Col8.setCellValueFactory(new PropertyValueFactory("propiedadPlano"));
        this.Col9.setCellValueFactory(new PropertyValueFactory("propiedadAMetrosFrente"));
        this.Col10.setCellValueFactory(new PropertyValueFactory("propiedadValorTerreno"));
        this.Col11.setCellValueFactory(new PropertyValueFactory("propiedadValorConstruccion"));
        this.Col12.setCellValueFactory(new PropertyValueFactory("propiedadOtrosValores"));
        this.Col13.setCellValueFactory(new PropertyValueFactory("PerteneceEstado"));
        this.Col14.setCellValueFactory(new PropertyValueFactory("propiedadZona"));
        this.Col15.setCellValueFactory(new PropertyValueFactory("Estado"));
        this.Col16.setCellValueFactory(new PropertyValueFactory("propiedad_fecha_Registro"));
        this.Col17.setCellValueFactory(new PropertyValueFactory("propiedad_ultima_Actualizacion"));
        Col1.setText("propiedades_id");
        Col2.setText("propiedadProvincia");
        Col3.setText("propiedadCanton");
        Col4.setText("propiedadDistrito");
        Col5.setText("propiedadDireccion");
        Col6.setText("propiedadGeolocalizacion");
        Col7.setText("propiedadArea");
        Col8.setText("propiedadPlano");
        Col9.setText("propiedadAMetrosFrente");
        Col10.setText("propiedadValorTerreno");
        Col11.setText("propiedadValorConstruccion");
        Col12.setText("propiedadOtrosValores");
        Col13.setText("PerteneceEstado");
        Col14.setText("propiedadZona");
        Col15.setText("Estado");
        Col16.setText("propiedad_fecha_Registro");
        Col17.setText("propiedad_ultima_Actualizacion");
        this.Tvdatos.setItems(optionsPro);
    }

    public void LlenarTablaLoc(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("nombreLocal"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("ubicacionLocal"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("correoLocal"));
        this.Col5.setCellValueFactory(new PropertyValueFactory("telefonoLocal"));
        this.Col6.setCellValueFactory(new PropertyValueFactory("Monto_Alquiler_Local"));
        this.Col7.setCellValueFactory(new PropertyValueFactory("fechaRegistrolocal"));
        this.Col8.setCellValueFactory(new PropertyValueFactory("ultima_Actualizacionlocal"));
        this.Col9.setCellValueFactory(new PropertyValueFactory("estado"));
        Col1.setText("id");
        Col2.setText("nombreLocal");
        Col3.setText("ubicacionLocal");
        Col4.setText("correoLocal");
        Col5.setText("telefonoLocal");
        Col6.setText("Monto_Alquiler_Local");
        Col7.setText("fechaRegistrolocal");
        Col8.setText("ultima_Actualizacionlocal");
        Col9.setText("estado");
        Col10.setVisible(false);
        Col11.setVisible(false);
        Col12.setVisible(false);
        Col13.setVisible(false);
        Col14.setVisible(false);
        Col15.setVisible(false);
        Col16.setVisible(false);
        Col17.setVisible(false);
        this.Tvdatos.setItems(optionsLoc);
    }

    public void OnActionBtnGenerar(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(getHola()==5){
            CrearReporte(Tvdatos,ArrayCobro,ArrayCobro.length,"Cobros",options);
        }
        if(getHola()==6){
            CrearReporte(Tvdatos,ArrayPropiedad,ArrayPropiedad.length,"Propiedades",optionsPro);
        }
        if(getHola()==7){
            CrearReporte(Tvdatos,ArrayLicencias,ArrayLicencias.length,"Licencias",optionsLic);
        }
        if(getHola()==8){
            CrearReporte(Tvdatos,ArrayLocales,ArrayLocales.length,"Locales",optionsLoc);
        }
        if(getHola()==9){
            CrearReporte(Tvdatos,ArrayParametros,ArrayParametros.length,"Parametros",optionspar);
        }
    }

    public void OnActionBtnImprime(ActionEvent actionEvent) {
    }

    public void OnActionBtnEliminar(ActionEvent actionEvent) throws IOException, InterruptedException {
        switch (Consulta){
            case 1:
                //Cobros
                ConsultasServiceGerente.EliminarTodoCobrosxEstado();
                break;
            case 2:
                //Licencias
                ConsultasServiceGerente.EliminarTodoLicenciasxEstado();
                break;
            case 3:
                ConsultasServiceGerente.EliminarTodoPropiedadesxEstado();
                break;
            case 4:
                //Locales
                ConsultasServiceGerente.EliminarTodoLocalesxEstado();
                break;
        }
        JOptionPane.showMessageDialog(null,"Registros eliminados correctamente");
        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("Cobros", "Eliminar un cobro", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
    }
}

