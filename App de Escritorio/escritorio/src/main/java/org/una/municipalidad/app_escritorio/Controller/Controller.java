package org.una.municipalidad.app_escritorio.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.collections.ObservableList;
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
    private static int Impuesto;
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

    public String[] StringCobros(ObservableList<CobrosDTO> lista, int tamaño){
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

    public String[] StringPropiedades(ObservableList<PropiedadesDTO> lista, int tamaño){
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
        arreglo[12]= String.valueOf((lista.get(tamaño).isPerteneceEstado()));
        arreglo[13]=(lista.get(tamaño).getPropiedadZona()==null)? " " : lista.get(tamaño).getPropiedadZona().toString();
        arreglo[14]=(lista.get(tamaño).getEstado()==null)? " " : lista.get(tamaño).getEstado().toString();
        arreglo[15]=(lista.get(tamaño).getPropiedad_fecha_Registro()==null)? " " : lista.get(tamaño).getPropiedad_fecha_Registro().toString();
        arreglo[16]=(lista.get(tamaño).getPropiedad_ultima_Actualizacion()==null)? " " : lista.get(tamaño).getPropiedad_ultima_Actualizacion().toString();
        return arreglo;

    }

    public String[] StringLocales(ObservableList<LocalesMercadoDTO> lista, int tamaño){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tamaño).getId().toString();
        arreglo[1]=(lista.get(tamaño).getNombreLocal()==null)? " " : lista.get(tamaño).getNombreLocal().toString();
        arreglo[2]=(lista.get(tamaño).getUbicacionLocal()==null)? " " : lista.get(tamaño).getUbicacionLocal().toString();
        arreglo[3]=(lista.get(tamaño).getCorreoLocal()==null)? " " : lista.get(tamaño).getCorreoLocal().toString();
        arreglo[4]=(lista.get(tamaño).getTelefonoLocal()==null)? " " : lista.get(tamaño).getTelefonoLocal().toString();
        arreglo[5]=(lista.get(tamaño).getMonto_Alquiler_Local()==null)? " " : lista.get(tamaño).getEstado().toString();
        arreglo[6]=(lista.get(tamaño).getFechaRegistrolocal()==null)? " " : lista.get(tamaño).getFechaRegistrolocal().toString();
        arreglo[7]=(lista.get(tamaño).getUltima_Actualizacionlocal()==null)? " " : lista.get(tamaño).getUltima_Actualizacionlocal().toString();
        arreglo[8]=(lista.get(tamaño).getEstado()==null)? " " : lista.get(tamaño).getEstado().toString();

        return arreglo;
    }
    public String[] StringLicencias(ObservableList<LicenciasComercialesDTO> lista, int tamaño){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tamaño).getId().toString();
        arreglo[1]=(lista.get(tamaño).getNombreComercio()==null)? " " : lista.get(tamaño).getNombreComercio().toString();
        arreglo[2]=(lista.get(tamaño).getTelefonoComercio()==null)? " " : lista.get(tamaño).getTelefonoComercio().toString();
        arreglo[3]=(lista.get(tamaño).getCorreoComercio()==null)? " " : lista.get(tamaño).getCorreoComercio().toString();
        arreglo[4]=(lista.get(tamaño).getDistritoComercio()==null)? " " : lista.get(tamaño).getFechaRegistrocomercio().toString();
        arreglo[5]=(lista.get(tamaño).getFechaRegistrocomercio()==null)? " " : lista.get(tamaño).getEstado().toString();
        arreglo[6]=(lista.get(tamaño).getUltima_Actualizacioncomercio()==null)? " " : lista.get(tamaño).getUltima_Actualizacioncomercio().toString();
        arreglo[7]=(lista.get(tamaño).getCodigoComercio()==null)? " " : lista.get(tamaño).getCodigoComercio().toString();
        arreglo[8]=(lista.get(tamaño).getEstado()==null)? " " : lista.get(tamaño).getEstado().toString();

        return arreglo;
    }
    public String[] StringParametros(ObservableList<ParametrosDTO> lista, int tamaño){
        String arreglo[]= new String[3];
        arreglo[0]=lista.get(tamaño).getId().toString();
        arreglo[1]=(lista.get(tamaño).getLlaveParametro()==null)? " " : lista.get(tamaño).getLlaveParametro().toString();
        arreglo[2]=(lista.get(tamaño).getValorParametro()==null)? " " : lista.get(tamaño).getValorParametro().toString();

        return arreglo;
    }

    public String[] StringBitacoras(ObservableList<BitacorasDTO> lista, int tamaño){
        String arreglo[]= new String[9];
        arreglo[0]=lista.get(tamaño).getId().toString();
        arreglo[1]=(lista.get(tamaño).getBitacoraDescripcion()==null)? " " : lista.get(tamaño).getBitacoraDescripcion().toString();
        arreglo[2]=(lista.get(tamaño).getBitacoraFecha()==null)? " " : lista.get(tamaño).getBitacoraFecha().toString();
        arreglo[3]=(lista.get(tamaño).getBitacoraTabla()==null)? " " : lista.get(tamaño).getBitacoraTabla().toString();
        arreglo[4]=(lista.get(tamaño).getBitacoraUsuario()==null)? " " : lista.get(tamaño).getBitacoraUsuario().toString();
        arreglo[5]=(lista.get(tamaño).getUsuario()==null)? " " : lista.get(tamaño).getUsuario().toString();

        return arreglo;
    }


    public void CrearReporte(TableView tabAuditoriaVolumes, String array[], int tamaño, String Nombre, ObservableList hola) throws IOException, InterruptedException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("sample");

        HSSFRow row = null;
        for (int i = 0; i <= tabAuditoriaVolumes.getItems().size(); i++) {
            row = spreadsheet.createRow(i);
            for (int j = 0; j < tabAuditoriaVolumes.getColumns().size(); j++) {
                if(j<tamaño){
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

        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro(Nombre, "Creación de reporte en la tabla "+Nombre, AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
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
