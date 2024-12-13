package ma.ensa.controlebland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.controlebland.dao.daoImpl.IncidentImpl;
import ma.ensa.controlebland.entity.Incident;
import ma.ensa.controlebland.entity.Membre;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
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
        Set<Incident> set = new HashSet<>();
        Incident incident = new Incident();
        incident.setReferance(String.valueOf(System.currentTimeMillis()));
        incident.setTime(Date.valueOf(LocalDate.now()));
        incident.setStatue(true);
        Membre membre = new Membre();
        membre.setIdentifiant("1734091011353");
        System.out.println(membre.getIdentifiant());
        incident.setMembre(membre);
        IncidentImpl incident1=new IncidentImpl();
        set.add(incident);
        incident1.insert(incident);
        launch();


    }
}