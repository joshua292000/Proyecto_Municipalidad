package org.una.municipalidad.app_escritorio.Controller;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Controller {

    private Stage stage;
    private String accion;
    private static int hola;
    public static int getHola() {
        return hola;
    }

    public static void setHola(int hola) {
        Controller.hola = hola;
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
