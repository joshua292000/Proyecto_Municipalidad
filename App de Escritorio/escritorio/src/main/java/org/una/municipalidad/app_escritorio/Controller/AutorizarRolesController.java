package org.una.municipalidad.app_escritorio.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import lombok.SneakyThrows;
import org.una.municipalidad.app_escritorio.DTO.ContribuyentesDTO;
import org.una.municipalidad.app_escritorio.DTO.RolesDTO;
import org.una.municipalidad.app_escritorio.DTO.UsuariosDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;
import org.una.municipalidad.app_escritorio.Service.ConsultasService;

import javax.swing.*;

public class AutorizarRolesController  extends Controller implements Initializable {

    @FXML
    private TableColumn<UsuariosDTO, String> colCedula;

    @FXML
    private TableColumn<?, ?> colEstado;

    @FXML
    private Button btnInsertar;

    @FXML
    private TableView<UsuariosDTO> TablaUsuario;

    @FXML
    private TableColumn<UsuariosDTO, String> colNombre;

    @FXML
    private HBox itemC;

    @FXML
    private TextField txtCedula;

    @FXML
    private TableColumn<UsuariosDTO, String> colClave;

    @FXML
    private TableColumn<?, ?> colRol;

    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<?, ?> colId;

    private ObservableList<String> options2 = FXCollections.observableArrayList();

    @FXML
    private ComboBox cbxRoles = new ComboBox(options2);

    @FXML
    private Button btnBuscar;

    @FXML
    private TextField txtClave;

    private ObservableList<UsuariosDTO> options = FXCollections.observableArrayList();


    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<RolesDTO> rol = ConsultasService.RolCBX();
        cbxRoles.getItems().removeAll();
        for(RolesDTO roles:rol){
            options2.add(roles.getId() +"-"+ roles.getNombreRol());

        }
        cbxRoles.setDisable(false);
        cbxRoles.setItems(options2);
        LlenarTabla();
    }

    @Override
    public void initialize() {
        LlenarTabla();
    }

    public void OnActionInsertar(ActionEvent actionEvent) throws IOException, InterruptedException {
        String id;
        String ids="";
        Long numero= Long.valueOf(0);
        id = cbxRoles.getValue().toString();
        char [] split = id.toCharArray();
        for(int x=0;x<split.length;x++){
            if(Character.isDigit(split[x])){
                ids+=split[x];
            }
        }
        numero= Long.valueOf(ids);
        if(txtNombre.getText().length()==0 || txtCedula.getText().length()==0 || txtClave.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Hay campos vacios");
        }else{
            RolesDTO rolcito = ConsultasService.ObtenerRol(numero);
            Long idd = Long.valueOf(1);
            boolean estado = true;
            options.add(new UsuariosDTO(idd,txtNombre.getText(),txtClave.getText(),txtCedula.getText(),estado,rolcito));
            this.TablaUsuario.setItems(options);
            txtCedula.clear();
            txtClave.clear();
            txtNombre.clear();
        }
    }

    public void OnActionBuscar(ActionEvent actionEvent) throws IOException, InterruptedException {
        TablaUsuario.getItems().clear();
        if(txtCedula.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Es necesario escribrir una cedula");
        }else{
            List<UsuariosDTO> usuario = ConsultasService.ObtenerUsuario(txtCedula.getText());
            if(usuario!=null){
                for(UsuariosDTO usuarios:usuario) {
                    options.add(new UsuariosDTO(usuarios.getId(), usuarios.getNombreUsuario(), usuarios.getClaveEncriptado(), usuarios.getCedula(), usuarios.isEstado(), usuarios.getRoles()));

                }
                this.TablaUsuario.setItems(options);
            }
        }
        txtCedula.clear();
    }

    public void OnActionGuardar(ActionEvent actionEvent) throws IOException, InterruptedException {
        long idd=8;
        for(int x=0;x<options.size();x++){
            UsuariosDTO usuario = ConsultasService.CrearUsuario(options.get(x).getNombreUsuario(),options.get(x).getClaveEncriptado(),options.get(x).getCedula(),options.get(x).isEstado(),options.get(x).getRoles());
        }
        JOptionPane.showMessageDialog(null,"Archivo guardado correctamente");
        TablaUsuario.getItems().clear();
    }

    public void LlenarTabla() {
        TablaUsuario.setEditable(true);
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombreUsuario"));
        this.colNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colNombre.setOnEditCommit(
                data->{
                    UsuariosDTO con = data.getRowValue();
                    con.setNombreUsuario(data.getNewValue());
                    System.out.println(con);
                }
        );

        this.colClave.setCellValueFactory(new PropertyValueFactory("claveEncriptado"));
        this.colClave.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colClave.setOnEditCommit(
                data->{
                    UsuariosDTO con = data.getRowValue();
                    con.setClaveEncriptado(data.getNewValue());
                    System.out.println(con);
                }
        );

        this.colCedula.setCellValueFactory(new PropertyValueFactory("cedula"));
        this.colCedula.setCellFactory(TextFieldTableCell.forTableColumn());
        this.colCedula.setOnEditCommit(
                data2->{
                    UsuariosDTO con = data2.getRowValue();
                    con.setCedula(data2.getNewValue());
                    System.out.println(con);
                }
        );

        this.colEstado.setCellValueFactory(new PropertyValueFactory("estado"));

        this.colRol.setCellValueFactory(new PropertyValueFactory("roles"));

        this.TablaUsuario.setItems(options);
    }
}
