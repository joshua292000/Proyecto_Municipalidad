package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import org.una.municipalidad.app_escritorio.DTO.CobrosDTO;
import org.una.municipalidad.app_escritorio.DTO.ContribuyentesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;

public class IngresarContribuyenteController extends Controller implements Initializable {
    @FXML
    private TableView TablaContribuyente;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<ContribuyentesDTO,String> colCedula;

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<ContribuyentesDTO,String> colNombre;

    @FXML
    private TableColumn<ContribuyentesDTO,String> colApellidos;

    @FXML
    private TableColumn colId;

    @FXML
    private HBox itemC;

    @FXML
    private TextField txtCedula;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnGuardar;

    private ObservableList<ContribuyentesDTO> options = FXCollections.observableArrayList();
    private ObservableList<String> options2 = FXCollections.observableArrayList();
    String[] opcionemss1 = {"OK"};
    private int j = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    @FXML
    void OnActionBuscar(ActionEvent event) throws IOException, InterruptedException {
        TablaContribuyente.getItems().clear();
        if(txtCedula.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Es necesario escribrir una cedula");
        }else{
            ContribuyentesDTO contribuyente = ConsultasGestorService.ObtenerContribuyente(txtCedula.getText());
            if(contribuyente!=null){
               // for(ContribuyentesDTO contribuyentes:contribuyente){
                    options.add(new ContribuyentesDTO(contribuyente.getId(),contribuyente.getNombreContribuyente(),contribuyente.getApellidoContribuyente(),contribuyente.getCedulaContribuyente()));

               // }
                this.TablaContribuyente.setItems(options);
            }
        }
        txtCedula.clear();
    }

    @FXML
    void OnActionInsertar(ActionEvent event) {
        if(txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtCedula.getText().length()==0){
             JOptionPane.showOptionDialog(null, "Alguno de los campos se encuentra vacio <<" , "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,opcionemss1 ,opcionemss1[0]);
        }else{
            Long id = Long.valueOf(1);
            options.add(new ContribuyentesDTO(id,txtNombre.getText(),txtApellido.getText(),txtCedula.getText()));
            this.TablaContribuyente.setItems(options);
            txtCedula.clear();
            txtApellido.clear();
            txtNombre.clear();
        }

    }


    @FXML
    void OnActionCancelar(ActionEvent event) {

    }

    @FXML
    void OnActionGuardar(ActionEvent event) throws IOException, InterruptedException {

        long idd=8;
        for(int x=0;x<options.size();x++){
            ContribuyentesDTO contribuyente = ConsultasGestorService.CrearContribuyente(options.get(x).getApellidoContribuyente(),options.get(x).getCedulaContribuyente(),options.get(x).getNombreContribuyente());
        }
        JOptionPane.showMessageDialog(null,"Archivo guardado correctamente");
        TablaContribuyente.getItems().clear();
    }
    public void LlenarTabla() {
        TablaContribuyente.setEditable(true);
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombreContribuyente"));
        this.colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colNombre.setOnEditCommit(
                data->{
                    System.out.println("Nuevo " + data.getNewValue());
                    System.out.println("Nuevo " + data.getOldValue());
                    ContribuyentesDTO con = data.getRowValue();
                    con.setNombreContribuyente(data.getNewValue());
                    System.out.println(con);
                }
        );

        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidoContribuyente"));
        this.colApellidos.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colApellidos.setOnEditCommit(
                data->{
                    System.out.println("Nuevo " + data.getNewValue());
                    System.out.println("Nuevo " + data.getOldValue());
                    ContribuyentesDTO con = data.getRowValue();
                    con.setNombreContribuyente(data.getNewValue());
                    System.out.println(con);
                }
        );

        this.colCedula.setCellValueFactory(new PropertyValueFactory("cedulaContribuyente"));
        this.colCedula.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colCedula.setOnEditCommit(
                data2->{
                    System.out.println("Nuevo " + data2.getNewValue());
                    System.out.println("Nuevo " + data2.getOldValue());
                    ContribuyentesDTO con = data2.getRowValue();
                    con.setNombreContribuyente(data2.getNewValue());
                    System.out.println(con);
                }
        );

        this.TablaContribuyente.setItems(options);
    }





}
