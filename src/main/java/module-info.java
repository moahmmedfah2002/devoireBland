module ma.ensa.controlebland {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires com.opencsv;

    opens ma.ensa.controlebland to javafx.fxml;
    exports ma.ensa.controlebland;
    exports ma.ensa.controlebland.controller;
    opens ma.ensa.controlebland.controller to javafx.fxml;
}