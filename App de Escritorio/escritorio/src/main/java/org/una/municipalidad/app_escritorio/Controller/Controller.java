package org.una.municipalidad.app_escritorio.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.una.municipalidad.app_escritorio.DTO.*;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Controller {

    private Stage stage;
    private String accion;
    private static int hola;
    @FXML
    private static int Impuesto;
    private static int Admin;
    private static int Pantallas;
    private static String Parametro;
    private static String Parametro2;

    public static LocalDate getBitacoraFecha() {
        return bitacoraFecha;
    }

    public static void setBitacoraFecha(LocalDate bitacoraFecha) {
        Controller.bitacoraFecha = bitacoraFecha;
    }

    private static LocalDate bitacoraFecha = LocalDate.parse("2021-11-12");
    public static String getParametro2() {
        return Parametro2;
    }

    public static void setParametro2(String parametro2) {
        Parametro2 = parametro2;
    }

    public static String getParametro() {
        return Parametro;
    }

    public static void setParametro(String parametro) {
        Parametro = parametro;
    }

    public static int getHola() {
        return hola;
    }

    public static void setHola(int hola) {
        Controller.hola = hola;
    }

    public static int getImpuesto() {
        return Impuesto;
    }

    public static void setImpuesto(int Impuesto) {
        Controller.Impuesto = Impuesto;
    }

    public static int getAdmin() {
        return Admin;
    }

    public static void setAdmin(int admin) {
        Admin = admin;
    }

    public static int getPantallas() {
        return Pantallas;
    }

    public static void setPantallas(int pantallas) {
        Pantallas = pantallas;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void sendTabEvent(KeyEvent event) {
        event.consume();
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, null, null, KeyCode.TAB, false, false, false, false);
        ((Control) event.getSource()).fireEvent(keyEvent);
    }
    public void loadUI(String ui, BorderPane border){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/org/una/municipalidad/app_escritorio/views/"+ ui +".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LogginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((VBox) border.getCenter()).getChildren().clear();
        ((VBox) border.getCenter()).getChildren().add(root);

    }

    public String[] StringCobros(ObservableList<CobrosDTO> lista, int tama??o){
        String arreglo[]= new String[12];
        arreglo[0]=lista.get(tama??o).getId().toString();
        arreglo[1]=(lista.get(tama??o).getCobrosPeriodo()==null)? " " : lista.get(tama??o).getCobrosPeriodo().toString();
        arreglo[2]=(lista.get(tama??o).getCobrosMonto()==null)? " " : lista.get(tama??o).getCobrosMonto().toString();
        arreglo[3]=(lista.get(tama??o).getCobrosFechaCreacion()==null)? " " : lista.get(tama??o).getCobrosFechaCreacion().toString();
        arreglo[4]=(lista.get(tama??o).getCobrosFechaVencimiento()==null)? " " : lista.get(tama??o).getCobrosFechaVencimiento().toString();
        arreglo[5]=(lista.get(tama??o).getEstado()==null)? " " : lista.get(tama??o).getEstado().toString();
        arreglo[6]=(lista.get(tama??o).getCobrosFechaPago()==null)? " " : lista.get(tama??o).getCobrosFechaPago().toString();
        arreglo[7]=(lista.get(tama??o).getLicenciascomerciales()==null)? " " : lista.get(tama??o).getLicenciascomerciales().getId().toString();
        arreglo[8]=(lista.get(tama??o).getFacturas()==null)? " " : lista.get(tama??o).getFacturas().getId().toString();
        arreglo[9]=(lista.get(tama??o).getTipocobros()==null)? " " : lista.get(tama??o).getTipocobros().getId().toString();
        arreglo[10]=(lista.get(tama??o).getLocalesmercado()==null)? " " : lista.get(tama??o).getLocalesmercado().getId().toString();
        arreglo[11]=(lista.get(tama??o).getPropiedades()==null)? " " : lista.get(tama??o).getPropiedades().getPropiedades_id().toString();
        return arreglo;
    }

    public String[] StringPropiedades(ObservableList<PropiedadesDTO> lista, int tama??o){
        String arreglo[]= new String[17];
        arreglo[0]=lista.get(tama??o).getPropiedades_id().toString();
        arreglo[1]=(lista.get(tama??o).getPropiedadProvincia()==null)? " " : lista.get(tama??o).getPropiedadProvincia().toString();
        arreglo[2]=(lista.get(tama??o).getPropiedadCanton()==null)? " " : lista.get(tama??o).getPropiedadCanton().toString();
        arreglo[3]=(lista.get(tama??o).getPropiedadDistrito()==null)? " " : lista.get(tama??o).getPropiedadDistrito().toString();
        arreglo[4]=(lista.get(tama??o).getPropiedadDireccion()==null)? " " : lista.get(tama??o).getPropiedadDireccion().toString();
        arreglo[5]=(lista.get(tama??o).getPropiedadGeolocalizacion()==null)? " " : lista.get(tama??o).getPropiedadGeolocalizacion().toString();
        arreglo[6]=(lista.get(tama??o).getPropiedadArea()==null)? " " : lista.get(tama??o).getPropiedadArea().toString();
        arreglo[7]=(lista.get(tama??o).getPropiedadPlano()==null)? " " : lista.get(tama??o).getPropiedadPlano();
        arreglo[8]=(lista.get(tama??o).getPropiedadAMetrosFrente()==null)? " " : lista.get(tama??o).getPropiedadAMetrosFrente().toString();
        arreglo[9]=(lista.get(tama??o).getPropiedadValorTerreno()==null)? " " : lista.get(tama??o).getPropiedadValorTerreno().toString();
        arreglo[10]=(lista.get(tama??o).getPropiedadValorConstruccion()==null)? " " : lista.get(tama??o).getPropiedadValorConstruccion().toString();
        arreglo[11]=(lista.get(tama??o).getPropiedadOtrosValores()==null)? " " : lista.get(tama??o).getPropiedadOtrosValores().toString();
        arreglo[12]= String.valueOf((lista.get(tama??o).isPerteneceEstado()));
        arreglo[13]=(lista.get(tama??o).getPropiedadZona()==null)? " " : lista.get(tama??o).getPropiedadZona().toString();
        arreglo[14]=(lista.get(tama??o).getEstado()==null)? " " : lista.get(tama??o).getEstado().toString();
        arreglo[15]=(lista.get(tama??o).getPropiedad_fecha_Registro()==null)? " " : lista.get(tama??o).getPropiedad_fecha_Registro().toString();
        arreglo[16]=(lista.get(tama??o).getPropiedad_ultima_Actualizacion()==null)? " " : lista.get(tama??o).getPropiedad_ultima_Actualizacion().toString();
        return arreglo;

    }

    public String[] StringLocales(ObservableList<LocalesMercadoDTO> lista, int tama??o){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tama??o).getId().toString();
        arreglo[1]=(lista.get(tama??o).getNombreLocal()==null)? " " : lista.get(tama??o).getNombreLocal().toString();
        arreglo[2]=(lista.get(tama??o).getUbicacionLocal()==null)? " " : lista.get(tama??o).getUbicacionLocal().toString();
        arreglo[3]=(lista.get(tama??o).getCorreoLocal()==null)? " " : lista.get(tama??o).getCorreoLocal().toString();
        arreglo[4]=(lista.get(tama??o).getTelefonoLocal()==null)? " " : lista.get(tama??o).getTelefonoLocal().toString();
        arreglo[5]=(lista.get(tama??o).getMonto_Alquiler_Local()==null)? " " : lista.get(tama??o).getEstado().toString();
        arreglo[6]=(lista.get(tama??o).getFechaRegistrolocal()==null)? " " : lista.get(tama??o).getFechaRegistrolocal().toString();
        arreglo[7]=(lista.get(tama??o).getUltima_Actualizacionlocal()==null)? " " : lista.get(tama??o).getUltima_Actualizacionlocal().toString();
        arreglo[8]=(lista.get(tama??o).getEstado()==null)? " " : lista.get(tama??o).getEstado().toString();

        return arreglo;
    }
    public String[] StringLicencias(ObservableList<LicenciasComercialesDTO> lista, int tama??o){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tama??o).getId().toString();
        arreglo[1]=(lista.get(tama??o).getNombreComercio()==null)? " " : lista.get(tama??o).getNombreComercio().toString();
        arreglo[2]=(lista.get(tama??o).getTelefonoComercio()==null)? " " : lista.get(tama??o).getTelefonoComercio().toString();
        arreglo[3]=(lista.get(tama??o).getCorreoComercio()==null)? " " : lista.get(tama??o).getCorreoComercio().toString();
        arreglo[4]=(lista.get(tama??o).getDistritoComercio()==null)? " " : lista.get(tama??o).getFechaRegistrocomercio().toString();
        arreglo[5]=(lista.get(tama??o).getFechaRegistrocomercio()==null)? " " : lista.get(tama??o).getEstado().toString();
        arreglo[6]=(lista.get(tama??o).getUltima_Actualizacioncomercio()==null)? " " : lista.get(tama??o).getUltima_Actualizacioncomercio().toString();
        arreglo[7]=(lista.get(tama??o).getCodigoComercio()==null)? " " : lista.get(tama??o).getCodigoComercio().toString();
        arreglo[8]=(lista.get(tama??o).getEstado()==null)? " " : lista.get(tama??o).getEstado().toString();

        return arreglo;
    }
    public String[] StringParametros(ObservableList<ParametrosDTO> lista, int tama??o){
        String arreglo[]= new String[3];
        arreglo[0]=lista.get(tama??o).getId().toString();
        arreglo[1]=(lista.get(tama??o).getLlaveParametro()==null)? " " : lista.get(tama??o).getLlaveParametro().toString();
        arreglo[2]=(lista.get(tama??o).getValorParametro()==null)? " " : lista.get(tama??o).getValorParametro().toString();

        return arreglo;
    }

    public String[] StringBitacoras(ObservableList<BitacorasDTO> lista, int tama??o){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tama??o).getId().toString();
        arreglo[1]=(lista.get(tama??o).getBitacoraDescripcion()==null)? " " : lista.get(tama??o).getBitacoraDescripcion().toString();
        arreglo[2]=(lista.get(tama??o).getBitacoraFecha()==null)? " " : lista.get(tama??o).getBitacoraFecha().toString();
        arreglo[3]=(lista.get(tama??o).getBitacoraTabla()==null)? " " : lista.get(tama??o).getBitacoraTabla().toString();
        arreglo[4]=(lista.get(tama??o).getBitacoraUsuario()==null)? " " : lista.get(tama??o).getBitacoraUsuario().toString();
        arreglo[5]=(lista.get(tama??o).getUsuario()==null)? " " : lista.get(tama??o).getUsuario().toString();

        return arreglo;
    }


    public void CrearReporte(TableView tabAuditoriaVolumes, String array[], int tama??o, String Nombre, ObservableList hola) throws IOException, InterruptedException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("sample");

        HSSFRow row = null;
        for (int i = 0; i <= tabAuditoriaVolumes.getItems().size(); i++) {
            row = spreadsheet.createRow(i);
            for (int j = 0; j < tabAuditoriaVolumes.getColumns().size(); j++) {
                if(j<tama??o){
                    if(i==0){
                        row.createCell(j).setCellValue(array[j]);
                    }else{
                        if(getHola()==5){
                            row.createCell(j).setCellValue(StringCobros(hola,i-1)[j]);
                        }
                        if(getHola()==6){
                            row.createCell(j).setCellValue(StringPropiedades(hola,i-1)[j]);
                        }
                        if(getHola()==7){
                            row.createCell(j).setCellValue(StringLicencias(hola,i-1)[j]);
                        }
                        if(getHola()==8){
                            row.createCell(j).setCellValue(StringLocales(hola,i-1)[j]);
                        }
                        if(getHola()==9){
                            row.createCell(j).setCellValue(StringParametros(hola,i-1)[j]);
                        }
                        if(getHola()==10){
                            row.createCell(j).setCellValue(StringCobros(hola,i-1)[j]);
                        }
                        if(getHola()==11){
                            row.createCell(j).setCellValue(StringBitacoras(hola,i-1)[j]);
                        }
                        if(getHola()==12){
                            row.createCell(j).setCellValue(StringLocales(hola,i-1)[j]);
                        }
                        if(getHola()==13){
                            row.createCell(j).setCellValue(StringLicencias(hola,i-1)[j]);
                        }
                        if(getHola()==14){
                            row.createCell(j).setCellValue(StringPropiedades(hola,i-1)[j]);
                        }

                    }
                }


            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(Nombre+".xls",true);
            try {
                workbook.write(fileOut);
                fileOut.close();
                //Platform.exit();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,"Reporte creado exitosamente");

        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro(Nombre, "Creaci??n de reporte en la tabla "+Nombre, AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
        Runtime.getRuntime().exec("cmd /c start "+Nombre+".xls");
        System.out.print(bitacora);

    }
    public static BooleanProperty _activo;

    public final BooleanProperty activoProperty(){
        return this._activo;
    }

    public final Boolean getActivo() {
        return _activo.get();
    }

    public final void setActivo(Boolean activo) {
        this._activo.set(activo);
    }


    public abstract void initialize();
}
