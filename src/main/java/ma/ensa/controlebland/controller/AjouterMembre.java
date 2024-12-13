package ma.ensa.controlebland.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ma.ensa.controlebland.dao.daoImpl.MenberImpl;
import ma.ensa.controlebland.entity.Membre;

import java.sql.SQLException;

public class AjouterMembre {

    @FXML
    TextField nom=new TextField();

    @FXML
    TextField prenom=new TextField();

    @FXML
    TextField email=new TextField();

    @FXML
    TextField phone=new TextField();

    @FXML
    Button insertBtn=new Button();

    @FXML
    public void insert(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if(insertBtn.isPressed()){
            MenberImpl menberImpl=new MenberImpl();
            Membre membre=new Membre();
            membre.setIdentifiant(String.valueOf(System.currentTimeMillis()));
            membre.setNom(nom.getText());
            membre.setPrenom(prenom.getText());
            membre.setEmail(email.getText());
            membre.setPhone(phone.getText());
            menberImpl.inser(membre);

        }

    }
}