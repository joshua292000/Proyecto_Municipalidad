module org.una.municipalidad.app_escritorio {

    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires lombok;
    requires com.jfoenix;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires jasperreports;
    requires java.desktop;
    requires poi;
    requires jxbrowser;
    requires jxbrowser.swing;


    opens org.una.municipalidad.app_escritorio to javafx.fxml;
    opens org.una.municipalidad.app_escritorio.Controller to javafx.fxml;
    exports org.una.municipalidad.app_escritorio;
    exports org.una.municipalidad.app_escritorio.Controller;
    exports org.una.municipalidad.app_escritorio.DTO to com.fasterxml.jackson.databind;
    opens org.una.municipalidad.app_escritorio.DTO to javafx.base;
}