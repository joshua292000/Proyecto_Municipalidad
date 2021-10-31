package org.una.municipalidad.app_escritorio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.una.municipalidad.app_escritorio.Util.FlowController;

public class Inicio extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FlowController.getInstance().InitializeFlow(stage, null);
        FlowController.getInstance().goViewInWindow("Loggin");

    }
}
