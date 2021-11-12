package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import org.una.municipalidad.app_escritorio.DTO.CobrosDTO;
import org.una.municipalidad.app_escritorio.DTO.ContribuyentesDTO;

import javax.swing.*;

public class IngresarContribuyenteController extends Controller implements Initializable {
    @FXML
    private TableView TablaContribuyente;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn colCedula;

    @FXML
    private Button btnInsertar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colApellidos;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LlenarTabla();
    }

    @Override
    public void initialize() {

    }

    @FXML
    void OnActionBuscar(ActionEvent event) {

    }

    @FXML
    void OnActionInsertar(ActionEvent event) {
        if(txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtCedula.getText().length()==0){
             JOptionPane.showOptionDialog(null, "Alguno de los campos se encuentra vacio <<" , "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,opcionemss1 ,opcionemss1[0]);
        }else{
            Long id = Long.valueOf(1);
            options.add(new ContribuyentesDTO(id,txtNombre.getText(),txtApellido.getText(),txtCedula.getText()));
            this.TablaContribuyente.setItems(options);
            TablaContribuyente.setEditable(true);
        }

    }


    @FXML
    void OnActionCancelar(ActionEvent event) {

    }

    @FXML
    void OnActionGuardar(ActionEvent event) {

    }
    public void LlenarTabla() {
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombreContribuyente"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidoContribuyente"));
        this.colCedula.setCellValueFactory(new PropertyValueFactory("cedulaContribuyente"));
        this.TablaContribuyente.setItems(options);
    }
}
