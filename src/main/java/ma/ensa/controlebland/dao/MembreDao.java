package ma.ensa.controlebland.dao;

import ma.ensa.controlebland.entity.Incident;

import ma.ensa.controlebland.entity.Membre;


import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface MembreDao {
    public boolean inser(Membre M) throws SQLException;
    public List<Incident> chargeListIncident() throws SQLException;
    public Set<Membre> chargerListeMembre(String nomFichier);

}

