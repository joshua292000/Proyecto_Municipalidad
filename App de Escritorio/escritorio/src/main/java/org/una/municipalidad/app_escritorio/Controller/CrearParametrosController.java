package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.una.municipalidad.app_escritorio.DTO.ContribuyentesDTO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.una.municipalidad.app_escritorio.DTO.ParametrosDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrearParametrosController extends Controller implements Initializable {

    @FXML
    private TextField txtvalorParametro;

    @FXML
    private TableView<ParametrosDTO> TablaParametro;

    @FXML
    private TableColumn<ParametrosDTO, String> colllaveParametro;

    @FXML
    private TableColumn<ParametrosDTO, String> colvalorParametro;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnInsertar;

    @FXML
    private TextField txtllaveParametro;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private HBox itemC;

    @FXML
    private Button btnBuscar;

    private ObservableList<ParametrosDTO> options = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    public void OnActionBuscar(ActionEvent actionEvent) throws IOException, InterruptedException {
        TablaParametro.getItems().clear();
        if(txtllaveParametro.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Es necesario escribrir una llave");
        }else{
            ParametrosDTO parametro = ConsultasService.ObtenerParametro(txtllaveParametro.getText());
            if(parametro!=null){
                options.add(new ParametrosDTO(parametro.getId(),parametro.getLlaveParametro(),parametro.getValorParametro()));
                this.TablaParametro.setItems(options);
            }
        }
        txtllaveParametro.clear();
    }



    public void OnActionInsertar(ActionEvent actionEvent) {
        if(txtllaveParametro.getText().length()==0 || txtvalorParametro.getText().length()==0 ){
            JOptionPane.showMessageDialog(null,"Hay campos vacios");
        }else{
            Long id = Long.valueOf(1);
            options.add(new ParametrosDTO(id,txtllaveParametro.getText(),txtvalorParametro.getText()));
            this.TablaParametro.setItems(options);
            txtllaveParametro.clear();
            txtvalorParametro.clear();

        }
    }

    public void OnActionGuardar(ActionEvent actionEvent) throws IOException, InterruptedException {
        long idd=8;
        for(int x=0;x<options.size();x++){
            ParametrosDTO parametro = ConsultasService.CrearParametro(options.get(x).getLlaveParametro(),options.get(x).getValorParametro());
        }
        JOptionPane.showMessageDialog(null,"Archivo guardado correctamente");
        TablaParametro.getItems().clear();
    }


    public void LlenarTabla() {
        TablaParametro.setEditable(true);
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));

        this.colllaveParametro.setCellValueFactory(new PropertyValueFactory("llaveParametro"));
        this.colllaveParametro.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colllaveParametro.setOnEditCommit(
                data->{
                    ParametrosDTO con = data.getRowValue();
                    con.setLlaveParametro(data.getNewValue());
                    System.out.println(con);
                }
        );

        this.colvalorParametro.setCellValueFactory(new PropertyValueFactory("valorParametro"));
        this.colvalorParametro.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colvalorParametro.setOnEditCommit(
                data->{
                    ParametrosDTO con = data.getRowValue();
                    con.setValorParametro(data.getNewValue());
                    System.out.println(con);
                }
        );



        this.TablaParametro.setItems(options);
    }


}
