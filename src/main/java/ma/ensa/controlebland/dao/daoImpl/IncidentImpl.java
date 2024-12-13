package ma.ensa.controlebland.dao.daoImpl;

import ma.ensa.controlebland.Connexion.Connexion;
import ma.ensa.controlebland.dao.IncidentDao;
import ma.ensa.controlebland.entity.Incident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class IncidentImpl implements IncidentDao {
    private Connection con;
    public IncidentImpl() throws SQLException, ClassNotFoundException {
        Connexion connexion=new Connexion();
        con=connexion.getCon();
    }

    @Override
    public boolean insert(Incident incident) throws SQLException {
        PreparedStatement ps=this.con.prepareCall("INSERT INTO incident(referance,time,statue,idMembre) values (?,?,?,?)");
        ps.setString(1,incident.getReferance());
        ps.setDate(2,incident.getTime());
        ps.setBoolean(3,incident.isStatue());
        ps.setString(4,incident.getMembre().getIdentifiant());

        return ps.executeUpdate()>0;


    }

    @Override
    public void inser(Set<Incident> is)  {
        final boolean[] res = {true};
        is.forEach((e)->{
            try {
                PreparedStatement ps=this.con.prepareCall("INSERT INTO incident(referance,time,statue,idMembre) values (?,?,?,?)");
                ps.setString(1,e.getReferance());
                ps.setDate(2,e.getTime());
                ps.setBoolean(3,e.isStatue());
                System.out.println(e.getMembre().getIdentifiant());


                ps.setString(4,e.getMembre().getIdentifiant());
                ps.executeUpdate();



            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }



        });





    }
}
