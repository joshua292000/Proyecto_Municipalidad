package org.una.municipalidad.app_escritorio.Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListadoViewController extends Controller implements Initializable {

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

    private ObservableList<CobrosDTO> options = FXCollections.observableArrayList();
    private ObservableList<ContribuyentesDTO> optionscont = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Locales_MercadoDTO> optionscontLoc = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_Licencias_ComercialesDTO> optionscontLic = FXCollections.observableArrayList();
    private ObservableList<Contribuyentes_PropiedadesDTO> optionscontPro = FXCollections.observableArrayList();
    private ObservableList<LocalesMercadoDTO> optionsLoc = FXCollections.observableArrayList();
    private ObservableList<LicenciasComercialesDTO> optionsLic = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> optionsPro = FXCollections.observableArrayList();
    private String  ArrayCobro[] ={"id","cobrosPeriodo","cobrosMonto","cobrosFechaCreacion","cobrosFechaVencimiento","Estado","cobrosFechaPago",
            "licenciacomerciales","facturas","tipocobros","localesmercado","propiedades"};
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        switch (Controller.getHola()){
            case 1: {
                List<CobrosDTO> cobro= ConsultasServiceGerente.obtenerTodoCobroXEsatado("Pendiente");
               // ListaAExcel.main(cobro);
                if(cobro!=null){
                    for(CobrosDTO cobros:cobro){
                        options.add(new CobrosDTO(cobros.getId(),cobros.getCobrosPeriodo(),cobros.getCobrosMonto(),cobros.getCobrosFechaCreacion(),cobros.getCobrosFechaVencimiento(),cobros.getEstado(),cobros.getCobrosFechaPago(),cobros.getLicenciascomerciales(),cobros.getFacturas(),cobros.getTipocobros(),cobros.getLocalesmercado(),cobros.getPropiedades()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(options);
                }
                //System.out.print(cobro);
                LlenarTabla();
                criarPlanilha(Tvdatos);
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
                List<LicenciasComercialesDTO> Licecias= ConsultasServiceGerente.obtenerTodoLicenciasxEstado("Pendiente");
                if(Licecias!=null){
                    for(LicenciasComercialesDTO lic:Licecias){
                        optionsLic.add(new LicenciasComercialesDTO(lic.getId(),lic.getNombreComercio(),lic.getTelefonoComercio(),lic.getCorreoComercio(),lic.getDistritoComercio(),lic.getFechaRegistrocomercio(),lic.getUltima_Actualizacioncomercio(),lic.getCodigoComercio(),lic.getEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLic);
                }
                LlenarTablaLic();
                break;
            }
            case 7: {
                List<PropiedadesDTO> propiedad= ConsultasServiceGerente.obtenerTodoPropiedadesxEstado("Pendiente");
                if(propiedad!=null){
                    for(PropiedadesDTO pro:propiedad){
                        optionsPro.add(new PropiedadesDTO(pro.getPropiedades_id(),pro.getPropiedadProvincia(),pro.getPropiedadCanton(),pro.getPropiedadDistrito(),pro.getPropiedadDireccion(),pro.getPropiedadGeolocalizacion(),pro.getPropiedadArea(),pro.getPropiedadPlano(),pro.getPropiedadAMetrosFrente(),pro.getPropiedadValorTerreno(),pro.getPropiedadValorConstruccion(),pro.getPropiedadOtrosValores(),pro.isPerteneceEstado(),pro.getPropiedadZona(),pro.getEstado(),pro.getPropiedad_fecha_Registro(),pro.getPropiedad_fecha_Registro()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsPro);
                }
                LlenarTablaPro();
                break;
            }
            case 8: {
                List<LocalesMercadoDTO> local= ConsultasServiceGerente.obtenerTodoLocalesxEstado("Pendiente");
                if(local!=null){
                    for(LocalesMercadoDTO loc:local){
                        optionsLoc.add(new LocalesMercadoDTO(loc.getId(),loc.getNombreLocal(),loc.getUbicacionLocal(),loc.getCorreoLocal(),loc.getTelefonoLocal(),loc.getMonto_Alquiler_Local(),loc.getFechaRegistrolocal(),loc.getUltima_Actualizacionlocal(),loc.getEstado()));
                    }
                    //Collection.sort(options);
                    this.Tvdatos.setItems(optionsLoc);
                }
                LlenarTablaLoc();
                break;
            }
        }

    System.out.println("tamaño"+ Tvdatos.getItems().get(1).toString());
    }

    @Override
    public void initialize() {

    }

    public String[] StringCobros(ObservableList<CobrosDTO> lista,int tamaño){
        String arreglo[]= new String[12];
        arreglo[0]=lista.get(tamaño).getId().toString();
        arreglo[1]=(lista.get(tamaño).getCobrosPeriodo()==null)? " " : lista.get(tamaño).getCobrosPeriodo().toString();
        arreglo[2]=(lista.get(tamaño).getCobrosMonto()==null)? " " : lista.get(tamaño).getCobrosMonto().toString();
        arreglo[3]=(lista.get(tamaño).getCobrosFechaCreacion()==null)? " " : lista.get(tamaño).getCobrosFechaCreacion().toString();
        arreglo[4]=(lista.get(tamaño).getCobrosFechaVencimiento()==null)? " " : lista.get(tamaño).getCobrosFechaVencimiento().toString();
        arreglo[5]=(lista.get(tamaño).getEstado()==null)? " " : lista.get(tamaño).getEstado().toString();
        arreglo[6]=(lista.get(tamaño).getCobrosFechaPago()==null)? " " : lista.get(tamaño).getCobrosFechaPago().toString();
        arreglo[7]=(lista.get(tamaño).getLicenciascomerciales()==null)? " " : lista.get(tamaño).getLicenciascomerciales().getId().toString();
        arreglo[8]=(lista.get(tamaño).getFacturas()==null)? " " : lista.get(tamaño).getFacturas().getId().toString();
        arreglo[9]=(lista.get(tamaño).getTipocobros()==null)? " " : lista.get(tamaño).getTipocobros().getId().toString();
        arreglo[10]=(lista.get(tamaño).getLocalesmercado()==null)? " " : lista.get(tamaño).getLocalesmercado().getId().toString();
        arreglo[11]=(lista.get(tamaño).getPropiedades()==null)? " " : lista.get(tamaño).getPropiedades().getPropiedades_id().toString();
        return arreglo;
    }

    public String[] StringPropiedades(ObservableList<PropiedadesDTO> lista,int tamaño){
        String arreglo[]= new String[12];
        arreglo[0]=lista.get(tamaño).getPropiedades_id().toString();
        arreglo[1]=(lista.get(tamaño).getPropiedadProvincia()==null)? " " : lista.get(tamaño).getPropiedadProvincia().toString();
        arreglo[2]=(lista.get(tamaño).getPropiedadCanton()==null)? " " : lista.get(tamaño).getPropiedadCanton().toString();
        arreglo[3]=(lista.get(tamaño).getPropiedadDistrito()==null)? " " : lista.get(tamaño).getPropiedadDistrito().toString();
        arreglo[4]=(lista.get(tamaño).getPropiedadDireccion()==null)? " " : lista.get(tamaño).getPropiedadDireccion().toString();
        arreglo[5]=(lista.get(tamaño).getPropiedadGeolocalizacion()==null)? " " : lista.get(tamaño).getPropiedadGeolocalizacion().toString();
        arreglo[6]=(lista.get(tamaño).getPropiedadArea()==null)? " " : lista.get(tamaño).getPropiedadArea().toString();
        arreglo[7]=(lista.get(tamaño).getPropiedadPlano()==null)? " " : lista.get(tamaño).getPropiedadPlano();
        arreglo[8]=(lista.get(tamaño).getPropiedadAMetrosFrente()==null)? " " : lista.get(tamaño).getPropiedadAMetrosFrente().toString();
        arreglo[9]=(lista.get(tamaño).getPropiedadValorTerreno()==null)? " " : lista.get(tamaño).getPropiedadValorTerreno().toString();
        arreglo[10]=(lista.get(tamaño).getPropiedadValorConstruccion()==null)? " " : lista.get(tamaño).getPropiedadValorConstruccion().toString();
        arreglo[11]=(lista.get(tamaño).getPropiedadOtrosValores()==null)? " " : lista.get(tamaño).getPropiedadOtrosValores().toString();
       // arreglo[11]=(lista.get(tamaño).isPerteneceEstado()==null)? " " : lista.get(tamaño).isPerteneceEstado();
        arreglo[11]=(lista.get(tamaño).getPropiedadZona()==null)? " " : lista.get(tamaño).getPropiedadZona().toString();
        arreglo[11]=(lista.get(tamaño).getEstado()==null)? " " : lista.get(tamaño).getEstado().toString();
        arreglo[11]=(lista.get(tamaño).getPropiedad_fecha_Registro()==null)? " " : lista.get(tamaño).getPropiedad_fecha_Registro().toString();
        arreglo[11]=(lista.get(tamaño).getPropiedad_ultima_Actualizacion()==null)? " " : lista.get(tamaño).getPropiedad_ultima_Actualizacion().toString();
        return arreglo;

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
        Col13.setVisible(false);
        Col14.setVisible(false);
        Col15.setVisible(false);
        Col16.setVisible(false);
        Col17.setVisible(false);
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

    public void criarPlanilha(TableView tabAuditoriaVolumes) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("sample");

        HSSFRow row = null;
        for (int i = 0; i <= tabAuditoriaVolumes.getItems().size(); i++) {
            row = spreadsheet.createRow(i);
        //System.out.print("\n Fila "+options.get(2).+ "\n");
            //row.createCell(0).setCellValue(tabAuditoriaVolumes.getItems().get(i).toString());
            //row.createCell(0).setCellValue("hola, mundo, albin, feo , kevin, guapo");
            for (int j = 0; j < tabAuditoriaVolumes.getColumns().size(); j++) {
                if(j<12){
                    if(i==0){
                        row.createCell(j).setCellValue(ArrayCobro[j]);
                        //row.createCell(j).setCellValue(StringCobros(options,i)[j]);
                    }else{
                        row.createCell(j).setCellValue(StringCobros(options,i-1)[j]);
                    }
                }


            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("workbook2.xls",true);
            try {
                workbook.write(fileOut);
                fileOut.close();
                Platform.exit();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
