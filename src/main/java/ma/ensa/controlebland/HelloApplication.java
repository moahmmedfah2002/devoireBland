package ma.ensa.controlebland;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.controlebland.entity.Membre;

import javax.net.ssl.SSLContext;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ajouterMembre.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Membre membre = new Membre();
        membre.setIdentifiant("hi");

        System.out.println(membre.getIdentifiant());
    }
}