package org.una.municipalidad.app_escritorio.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.BitacorasDTO;
import org.una.municipalidad.app_escritorio.DTO.CobrosDTO;
import org.una.municipalidad.app_escritorio.DTO.FechasCobrosDTO;
import org.una.municipalidad.app_escritorio.Service.AutenticacionService;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasServiceGerente;
import org.una.municipalidad.app_escritorio.Util.AppContext;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
public class CobrosMasivosViewController extends Controller implements Initializable {

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_3;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_2;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_5;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_4;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_7;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_6;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_9;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_8;

    @FXML
    private TableView TvFechas;

    @FXML
    private TableColumn<FechasCobrosDTO, Long> Periodo;

    @FXML
    private JFXButton btnTrimestral;

    @FXML
    private JFXButton btnAnual;

    @FXML
    private JFXButton btnMensual;

    @FXML
    private TableColumn ID;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_11;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_12;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_1;

    @FXML
    private TableColumn ColImpuesto;

    @FXML
    private TableColumn<FechasCobrosDTO, Date> Fecha_10;

    private ObservableList<FechasCobrosDTO> options = FXCollections.observableArrayList();
    private ObservableList<Date> fechitas = FXCollections.observableArrayList();
    int pantallita =0;
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<FechasCobrosDTO> cobro = ConsultasServiceGerente.obtenerTodoFechaCobros();
        System.out.println("picha " +cobro);
        if (cobro != null) {
            for (FechasCobrosDTO cobros : cobro) {
                options.add(new FechasCobrosDTO(cobros.getId(), cobros.getFechasCobrosImpuestos(), cobros.getFechasCobrosPeriodo(), cobros.getFechasCobrosFecha1(), cobros.getFechasCobrosFecha2(), cobros.getFechasCobrosFecha3(), cobros.getFechasCobrosFecha4(), cobros.getFechasCobrosFecha5(), cobros.getFechasCobrosFecha6(), cobros.getFechasCobrosFecha7(), cobros.getFechasCobrosFecha8(), cobros.getFechasCobrosFecha9(),cobros.getFechasCobrosFecha10(),cobros.getFechasCobrosFecha11(),cobros.getFechasCobrosFecha12()));
            }
            //Collection.sort(options);
            this.TvFechas.setItems(options);
        }
        //System.out.print(cobro);
        llenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void OnActionBtnMensual(ActionEvent actionEvent) throws IOException, InterruptedException {

        List<FechasCobrosDTO> filaSeleccionada =  TvFechas.getSelectionModel().getSelectedItems();
        if (filaSeleccionada.size() == 1) {
            final FechasCobrosDTO fecha = filaSeleccionada.get(0);

            fechitas.add(fecha.getFechasCobrosFecha1());
            fechitas.add(fecha.getFechasCobrosFecha2());
            fechitas.add(fecha.getFechasCobrosFecha3());
            fechitas.add(fecha.getFechasCobrosFecha4());
            fechitas.add(fecha.getFechasCobrosFecha5());
            fechitas.add(fecha.getFechasCobrosFecha6());
            fechitas.add(fecha.getFechasCobrosFecha7());
            fechitas.add(fecha.getFechasCobrosFecha8());
            fechitas.add(fecha.getFechasCobrosFecha9());
            fechitas.add(fecha.getFechasCobrosFecha10());
            fechitas.add(fecha.getFechasCobrosFecha11());
            fechitas.add(fecha.getFechasCobrosFecha12());

            FechasCobrosDTO licencia = ConsultasServiceGerente.ActualizarFechasCobros(fecha.getId(),fecha.getFechasCobrosImpuestos(),fecha.getFechasCobrosPeriodo(),fecha.getFechasCobrosFecha1(),fecha.getFechasCobrosFecha2(),fecha.getFechasCobrosFecha3(),fecha.getFechasCobrosFecha4(),fecha.getFechasCobrosFecha5(),fecha.getFechasCobrosFecha6(),fecha.getFechasCobrosFecha7(),fecha.getFechasCobrosFecha8(),fecha.getFechasCobrosFecha9(),fecha.getFechasCobrosFecha10(),fecha.getFechasCobrosFecha11(),fecha.getFechasCobrosFecha12());


            if(fecha.getFechasCobrosImpuestos().equals("Licencia Comercial") || fecha.getFechasCobrosImpuestos().equals("Timbre Licencia")) {
                pantallita=1;
            }else if(fecha.getFechasCobrosImpuestos().equals("Propiedades")){
                pantallita=2;
            }else if(fecha.getFechasCobrosImpuestos().equals("Locales de mercado")){
                pantallita=3;
            }
        }

        JOptionPane.showMessageDialog(null, "Archivo actualizado correctamente");
        BitacorasDTO bitacora =  ConsultasGestorService.CrearRegistro("FechasCobros", "Actualizacion de una fecha de cobro", AppContext.getInstance().get("usuario").toString(),getBitacoraFecha(), AutenticacionService.datos.get(0).getUsuarioDTO().getId());
        System.out.println("tiene " + pantallita);
        if(pantallita==1){
            for(int i =0; i<fechitas.size();i++){
                System.out.println("hola");
                if(fechitas.get(i)!=null) {
                    System.out.println("hola adentro");
                    ConsultasServiceGerente.CrearCobrosMasivosxLicencias(fechitas.get(i));
                }
            }
            setHola(10);
            loadUI("ListadoView",BorderPane);
        } else if(pantallita==2){
            for(int i =0; i<fechitas.size();i++){
                if(fechitas.get(i)!=null){
                    ConsultasServiceGerente.CrearCobrosMasivosxpropiedad(fechitas.get(i));
                }
            }
            setHola(10);
            loadUI("ListadoView",BorderPane);
        }else if(pantallita==3){
            System.out.println("entre");
            for(int i =0; i<fechitas.size();i++){
                if(fechitas.get(i)!=null) {
                    ConsultasServiceGerente.CrearCobrosMasivosxLocal(fechitas.get(i));
                }
            }
          setHola(10);
            loadUI("ListadoView",BorderPane);
        }

        /*ConsultasServiceGerente.CrearCobrosMasivosxLocal();
        setHola(10);
        loadUI("ListadoView",BorderPane);*/
    }

    public void OnActionBtnAnual(ActionEvent actionEvent) throws IOException, InterruptedException {

        /*for(int i =0; i<fechitas.size();i++){
            ConsultasServiceGerente.CrearCobrosMasivosxpropiedad(fechitas.get(i));
        }
        setHola(10);
        loadUI("ListadoView",BorderPane);*/
    }

    public void OnActionbtnTrimestral(ActionEvent actionEvent) throws IOException, InterruptedException {
        /*ConsultasServiceGerente.CrearCobrosMasivosxLicencias();

        setHola(10);
        loadUI("ListadoView",BorderPane);*/
    }

    public void llenarTabla(){
        TvFechas.setEditable(true);
        this.ID.setCellValueFactory(new PropertyValueFactory("id"));
        this.ColImpuesto.setCellValueFactory(new PropertyValueFactory("FechasCobrosImpuestos"));

        this.Periodo.setCellValueFactory(new PropertyValueFactory("FechasCobrosPeriodo"));
        this.Periodo.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Long>forTableColumn(new LongStringConverter()));
        this.Periodo.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosPeriodo(Long.valueOf(data.getNewValue()));
                    System.out.println(con);
                }
        );
        this.Fecha_1.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha1"));
        this.Fecha_1.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_1.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha1(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_2.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha2"));
        this.Fecha_2.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_2.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha2(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_3.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha3"));
        this.Fecha_3.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_3.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha3(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_4.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha4"));
        this.Fecha_4.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_4.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha4(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_5.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha5"));
        this.Fecha_5.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_5.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha5(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_6.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha6"));
        this.Fecha_6.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_6.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha6(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_7.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha7"));
        this.Fecha_7.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_7.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha7(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_8.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha8"));
        this.Fecha_8.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_8.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha8(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_9.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha9"));
        this.Fecha_9.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_9.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha9(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_10.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha10"));
        this.Fecha_10.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_10.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha10(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_11.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha11"));
        this.Fecha_11.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_11.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha11(data.getNewValue());
                    System.out.println(con);
                }
        );
        this.Fecha_12.setCellValueFactory(new PropertyValueFactory("FechasCobrosFecha12"));
        this.Fecha_12.setCellFactory(TextFieldTableCell.<FechasCobrosDTO,Date>forTableColumn(new DateStringConverter()));
        this.Fecha_12.setOnEditCommit(
                data->{
                    FechasCobrosDTO con = data.getRowValue();
                    con.setFechasCobrosFecha12(data.getNewValue());
                    System.out.println(con);
                }
        );



    }
}
