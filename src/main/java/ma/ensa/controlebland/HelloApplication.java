package ma.ensa.controlebland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.controlebland.dao.daoImpl.IncidentImpl;
import ma.ensa.controlebland.dao.daoImpl.MenberImpl;
import ma.ensa.controlebland.entity.Incident;
import ma.ensa.controlebland.entity.Membre;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterMembre.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        MenberImpl menberinpl=new MenberImpl();


        launch();


    }
}