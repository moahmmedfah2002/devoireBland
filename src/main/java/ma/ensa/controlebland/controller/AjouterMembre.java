package ma.ensa.controlebland.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import ma.ensa.controlebland.dao.daoImpl.MenberImpl;
import ma.ensa.controlebland.entity.Membre;

import java.sql.SQLException;

public class AjouterMembre {

    @FXML
    public TextField nom=new TextField();

    @FXML
    public TextField prenom=new TextField();

    @FXML
    public TextField email=new TextField();

    @FXML
    public TextField phone=new TextField();

    @FXML
    public Button insertBtn=new Button();
    @FXML
    public Label msg=new Label();

    @FXML
    public void insert(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        if(mouseEvent.getClickCount()==1){
            MenberImpl menberImpl=new MenberImpl();
            Membre membre=new Membre();
            membre.setIdentifiant(String.valueOf(System.currentTimeMillis()));
            membre.setNom(nom.getText());
            membre.setPrenom(prenom.getText());
            membre.setEmail(email.getText());
            membre.setPhone(phone.getText());
            if(menberImpl.inser(membre)){
                msg.setText("added");

            }else {
                msg.setText("not added");
            }


        }

    }
}