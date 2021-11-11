package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.net.URL;
import java.util.*;

public class ListadoViewController extends Controller implements Initializable {
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

    private ObservableList<CobrosDTO> options = FXCollections.observableArrayList();
    private ObservableList<ContribuyentesDTO> optionscont = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Locales_MercadoDTO> optionscontLoc = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Licencias_ComercialesDTO> optionscontLic = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_PropiedadesDTO> optionscontPro = FXCollections.observableArrayList();
    private ObservableList<LocalesMercadoDTO> optionsLoc = FXCollections.observableArrayList();
    private ObservableList<LicenciasComercialesDTO> optionsLic = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> optionsPro = FXCollections.observableArrayList();
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.print("Hola Joshua Rico");

        switch (Controller.getHola()){
            case 1: {
                System.out.print("Hola Joss");
                List<CobrosDTO> cobro= ConsultasServiceGerente.obtenerTodoCobro();
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.isEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciacomerciales(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(options);
                }
                System.out.print(cobro);
                LlenarTabla();
                break;
            }
            case 2: {
                List<ContribuyentesDTO> contri= ConsultasServiceGerente.obtenerTodoContribuyente();
                if(contri!=null){
                    for(ContribuyentesDTO contribu:contri){
                        optionscont.add(new ContribuyentesDTO(contribu.getId(),contribu.getNombreContribuyente(),contribu.getApellidoContribuyente(),contribu.getCedulaContribuyente()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscont);
                }
                LlenarTablaContr();
                break;
            }
            case 3: {
              /*  List<Contribuyentes_Locales_MercadoDTO> contriLoc= ConsultasServiceGerente.obtenerTodoContribuyente();
                if(contriLoc!=null){
                    for(Contribuyentes_Locales_MercadoDTO contribuLoc:contriLoc){
                        optionscontLoc.add(new Contribuyentes_Locales_MercadoDTO());
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscontLoc);
                }
                LlenarTablaContr();*/
                break;
            }
            case 4: {
                /*List<ContribuyentesDTO> contri= ConsultasServiceGerente.obtenerTodoContribuyente();
                if(contri!=null){
                    for(ContribuyentesDTO contribu:contri){
                        optionscont.add(new ContribuyentesDTO(contribu.getId(),contribu.getNombreContribuyente(),contribu.getApellidoContribuyente(),contribu.getCedulaContribuyente()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscont);
                }
                LlenarTablaContr();
                break;*/
            }
            case 5: {
               /* List<ContribuyentesDTO> contri= ConsultasServiceGerente.obtenerTodoContribuyente();
                if(contri!=null){
                    for(ContribuyentesDTO contribu:contri){
                        optionscont.add(new ContribuyentesDTO(contribu.getId(),contribu.getNombreContribuyente(),contribu.getApellidoContribuyente(),contribu.getCedulaContribuyente()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscont);
                }
                LlenarTablaContr();*/
                break;
            }
            case 6: {
                List<LicenciasComercialesDTO> Licecias= ConsultasServiceGerente.obtenerTodoLicencias();
                if(Licecias!=null){
                    for(LicenciasComercialesDTO lic:Licecias){
                        optionsLic.add(new LicenciasComercialesDTO(lic.getId(),lic.getNombreComercio(),lic.getTelefonoComercio(),lic.getCorreoComercio(),lic.getDistritoComercio(),lic.getFechaRegistrocomercio(),lic.getUltima_Actualizacioncomercio(),lic.getCodigoComercio(),lic.isEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLic);
                }
                LlenarTablaLic();
                break;
            }
            case 7: {
                List<PropiedadesDTO> propiedad= ConsultasServiceGerente.obtenerTodoPropiedades();
                if(propiedad!=null){
                    for(PropiedadesDTO pro:propiedad){
                        optionsPro.add(new PropiedadesDTO(pro.getPropiedades_id(),pro.getPropiedadProvincia(),pro.getPropiedadCanton(),pro.getPropiedadDistrito(),pro.getPropiedadDireccion(),pro.getPropiedadGeolocalizacion(),pro.getPropiedadArea(),pro.getPropiedadPlano(),pro.getPropiedadAMetrosFrente(),pro.getPropiedadValorTerreno(),pro.getPropiedadValorConstruccion(),pro.getPropiedadOtrosValores(),pro.isPerteneceEstado(),pro.getPropiedadZona(),pro.isEstado(),pro.getPropiedad_fecha_Registro(),pro.getPropiedad_fecha_Registro()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscont);
                }
                LlenarTablaContr();
                break;
            }
            case 8: {
                List<ContribuyentesDTO> contri= ConsultasServiceGerente.obtenerTodoContribuyente();
                if(contri!=null){
                    for(ContribuyentesDTO contribu:contri){
                        optionscont.add(new ContribuyentesDTO(contribu.getId(),contribu.getNombreContribuyente(),contribu.getApellidoContribuyente(),contribu.getCedulaContribuyente()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionscont);
                }
                LlenarTablaContr();
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
        this.Col8.setCellValueFactory(new PropertyValueFactory("licenciacomerciales"));
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
        Col8.setText("licenciacomerciales");
        Col9.setText("facturas");
        Col10.setText("tipocobros");
        Col11.setText("localesmercado");
        Col12.setText("propiedades");
        this.Tvdatos.setItems(options);
    }
    public void LlenarTablaContr(){
        this.Col1.setCellValueFactory(new PropertyValueFactory("id"));
        this.Col2.setCellValueFactory(new PropertyValueFactory("nombreContribuyente"));
        this.Col3.setCellValueFactory(new PropertyValueFactory("apellidoContribuyente"));
        this.Col4.setCellValueFactory(new PropertyValueFactory("cedulaContribuyente"));
        Col1.setText("id");
        Col2.setText("nombreContribuyente");
        Col3.setText("apellidoContribuyente");
        Col4.setText("cedulaContribuyente");
        Col5.setVisible(false);
        Col6.setVisible(false);
        Col7.setVisible(false);
        Col8.setVisible(false);
        Col9.setVisible(false);
        Col10.setVisible(false);
        Col11.setVisible(false);
        Col12.setVisible(false);
        this.Tvdatos.setItems(optionscont);
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
        this.Tvdatos.setItems(optionsLic);
    }

    /*private Long propiedades_id;
    private String propiedadProvincia;
    private String propiedadCanton;
    private String propiedadDistrito;
    private String propiedadDireccion;
    private String propiedadGeolocalizacion;
    private Long propiedadArea;
    private String propiedadPlano;
    private Long propiedadAMetrosFrente;
    private Long propiedadValorTerreno;
    private Long propiedadValorConstruccion;
    private Long propiedadOtrosValores;
    private boolean PerteneceEstado;
    private String propiedadZona;
    private boolean Estado;
    private Date propiedad_fecha_Registro;
    private Date propiedad_ultima_Actualizacion;*/
}
