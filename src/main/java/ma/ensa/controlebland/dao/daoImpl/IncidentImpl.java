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
    }

    @Override
    public boolean insert(Incident incident) throws SQLException {
        PreparedStatement ps=this.con.prepareCall("INSERT INTO incident(time,statue,idMember) values (?,?,?)");
        ps.setDate(1,incident.getTime());
        ps.setBoolean(2,incident.isStatue());
        ps.setString(3,incident.getMembre().getIdentifiant());
        return ps.executeUpdate()>0;


    }

    @Override
    public void inser(Set<Incident> is)  {
        final boolean[] res = {true};
        is.forEach((e)->{
            try {
                PreparedStatement ps=this.con.prepareCall("INSERT INTO incident(time,statue,idMember) values (?,?,?)");
                ps.setDate(1,e.getTime());
                ps.setBoolean(2,e.isStatue());
                ps.setString(3,e.getMembre().getIdentifiant());



            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }



        });





    }
}
