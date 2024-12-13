package ma.ensa.controlebland.dao;

import ma.ensa.controlebland.entity.Incident;

import java.sql.SQLException;
import java.util.Set;

public interface IncidentDao {
    public boolean insert(Incident incident) throws SQLException;
    public void inser(Set<Incident> is) ;
}
