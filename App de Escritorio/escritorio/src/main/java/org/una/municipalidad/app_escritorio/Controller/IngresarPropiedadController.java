package org.una.municipalidad.app_escritorio.Controller;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;
import org.una.municipalidad.app_escritorio.DTO.LocalesMercadoDTO;
import org.una.municipalidad.app_escritorio.DTO.PropiedadesDTO;
import org.una.municipalidad.app_escritorio.Service.ConsultasGestorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class IngresarPropiedadController extends Controller implements Initializable {
    @FXML
    private ComboBox<String> cbxPerteneceEstado;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Pane Panefondo;

    @FXML
    private Button btnInsertar;

    @FXML
    private TextField txtArea;

    @FXML
    private Label lbl1;

    @FXML
    private TextField txtDistrito;

    @FXML
    private Label lbl4;

    @FXML
    private HBox itemC;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private TextField txtfrente;

    @FXML
    private TextField txtCanton;

    @FXML
    private Label lbl6;

    @FXML
    private Button btnGeo;

    private int Contador=0;
    private Long propiedades_id;
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
    private String Estado = "Activo";
    private Date propiedad_fecha_Registro;
    private Date propiedad_ultima_Actualizacion;

    ObservableList<String> items = FXCollections.observableArrayList();
    private ObservableList<PropiedadesDTO> options = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        items.addAll("Si", "No");
        cbxPerteneceEstado.setItems(items);
        integerTextField(txtArea);
        integerTextField(txtfrente);
    }

    @Override
    public void initialize() {

    }

    public void OnActionInsertar(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(Contador == 0){
            if(txtfrente.getLength()==0 || txtDireccion.getLength()==0 || txtCanton.getLength()==0 || txtDistrito.getLength()==0 || txtArea.getLength()==0){
                JOptionPane.showMessageDialog(null,"Existen campos vacios, porfavor ingrese todos todos los datos");
            }else{
                propiedadAMetrosFrente = Long.valueOf(txtfrente.getText());
                propiedadArea = Long.valueOf(txtArea.getText());
                propiedadCanton = txtCanton.getText();
                propiedadDireccion = txtDireccion.getText();
                propiedadDistrito = txtDistrito.getText();
                if(cbxPerteneceEstado.getValue() == "Si"){
                    PerteneceEstado = true;
                }else if(cbxPerteneceEstado.getValue() == "No"){
                    PerteneceEstado = false;
                }

                btnGeo.setVisible(true);
                lbl5.setText("Geolocalizacion");
                txtDistrito.clear();
                txtDistrito.setPromptText("Geolocalizacion");

                lbl2.setText("Otros valores");
                txtArea.clear();
                txtArea.setPromptText("Otros valores");

                lbl3.setText("Plano");
                txtCanton.clear();
                txtCanton.setPromptText("Plano");

                lbl4.setText("Provincia");
                txtDireccion.clear();
                txtDireccion.setPromptText("Provincia");

                lbl1.setText("Valor de construccion");
                txtfrente.clear();
                txtfrente.setPromptText("Valor de construccion");

                lbl6.setVisible(false);
                cbxPerteneceEstado.setVisible(false);

                Contador += 1;
            }

        }else if(Contador ==1){
            if(txtfrente.getLength()==0 || txtDireccion.getLength()==0 || txtCanton.getLength()==0 || txtDistrito.getLength()==0 || txtArea.getLength()==0){
                JOptionPane.showMessageDialog(null,"Existen campos vacios, porfavor ingrese todos todos los datos");
            }else {
                btnGeo.setVisible(false);
                propiedadGeolocalizacion = txtDistrito.getText();
                propiedadOtrosValores = Long.valueOf(txtArea.getText());
                propiedadPlano = txtCanton.getText();
                propiedadProvincia = txtDireccion.getText();
                propiedadValorConstruccion = Long.valueOf(txtfrente.getText());

                lbl1.setText("Valor del terreno");
                txtfrente.clear();
                txtfrente.setPromptText("Valor del terreno");

                lbl4.setText("Zona");
                txtDireccion.clear();
                txtDireccion.setPromptText("Zona");

                lbl2.setVisible(false);
                lbl3.setVisible(false);
                lbl5.setVisible(false);
                txtDistrito.setVisible(false);
                txtArea.setVisible(false);
                txtCanton.setVisible(false);
                btnInsertar.setText("Guardar propiedad");
                Contador += 1;
            }
        }else if(Contador ==2){
            if(txtfrente.getLength()==0 || txtDireccion.getLength()==0){
                JOptionPane.showMessageDialog(null,"Existen campos vacios, porfavor ingrese todos todos los datos");
            }else {
                propiedadValorTerreno = Long.valueOf(txtfrente.getText());
                propiedadZona = txtDireccion.getText();
                long idd = 8;
                LocalDate fechaRegistro = LocalDate.parse("2021-11-12");
                Date fecha = new Date();
                options.add(new PropiedadesDTO(idd, propiedadProvincia, propiedadCanton, propiedadDistrito, propiedadDireccion, propiedadGeolocalizacion, propiedadArea, propiedadPlano, propiedadAMetrosFrente, propiedadValorTerreno, propiedadValorConstruccion, propiedadOtrosValores, PerteneceEstado, propiedadZona, Estado, fecha, fecha));
                for (int x = 0; x < options.size(); x++) {
                    PropiedadesDTO propiedad = ConsultasGestorService.CrearPropiedad(options.get(x).getPropiedadProvincia(), options.get(x).getPropiedadCanton(), options.get(x).getPropiedadDistrito(), options.get(x).getPropiedadDireccion(), options.get(x).getPropiedadGeolocalizacion(), options.get(x).getPropiedadArea(), options.get(x).getPropiedadPlano(), options.get(x).getPropiedadAMetrosFrente(), options.get(x).getPropiedadValorTerreno(), options.get(x).getPropiedadValorConstruccion(), options.get(x).getPropiedadOtrosValores(), options.get(x).isPerteneceEstado(), options.get(x).getPropiedadZona(), Estado, fechaRegistro, fechaRegistro);
                }
                JOptionPane.showMessageDialog(null, "Archivo guardado correctamente");
                Contador = 0;
            }
        }
    }

    public void OnActionGeo(ActionEvent actionEvent) {
        Engine engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey("1BNDHFSC1G0VRGZOEPHZ46KY4YI29ZAOX46IAP1ZC709GIV167OH49YFGSWZVYLM86Q30G")
                        .build());
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JFrame frame = new JFrame("Mapita");
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTextField addressBar = new JTextField("http://maps.google.com");
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            frame.add(addressBar, BorderLayout.NORTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            browser.navigation().loadUrl(addressBar.getText());
        });
    }

    public static void integerTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();

            if (newText.matches("-?([0-9]*)?")) {

                return change;
            }

            return null;
        };
        textField.setTextFormatter(
                new TextFormatter<Integer>(
                        new IntegerStringConverter(), 0, integerFilter));
    }
}
