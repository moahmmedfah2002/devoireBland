package ma.ensa.controlebland.Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public Connection con;

    public Connexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/controlebland","root","root");

    }

    public Connection getCon() {
        return con;
    }
}
