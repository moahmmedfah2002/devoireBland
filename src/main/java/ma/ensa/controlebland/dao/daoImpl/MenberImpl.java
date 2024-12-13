package ma.ensa.controlebland.dao.daoImpl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import ma.ensa.controlebland.Connexion.Connexion;
import ma.ensa.controlebland.dao.MembreDao;
import ma.ensa.controlebland.entity.Incident;
import ma.ensa.controlebland.entity.Membre;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Member;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenberImpl implements MembreDao {

    public Connection con;
    public MenberImpl() throws SQLException, ClassNotFoundException {
        Connexion connexion=new Connexion();
        this.con= connexion.getCon();
    }


    @Override
    public boolean inser(Membre M) throws SQLException {
        PreparedStatement ps = this.con.prepareCall("INSERT INTO member(identifiant,nom,prenom,email,phone) VALUES (?,?,?,?,?)");
        boolean result=false;
        ps.setString(1, M.getIdentifiant());
        ps.setString(1, M.getNom());
        ps.setString(2,M.getPrenom());
        ps.setString(3,M.getEmail());
        ps.setString(4,M.getPhone());
        result=ps.executeUpdate()>0;
        for(Incident i:M.getIncidents()){
            PreparedStatement ps1 = this.con.prepareCall("INSERT INTO memberincident(idMember,idIncident) VALUES (?,?)");
            ps1.setString(2,i.getReferance());
            ps1.setString(1,ps.getGeneratedKeys().getString("identifiant"));
            result =ps1.executeUpdate()>0;
        }
        return result;



    }

    @Override
    public List<Incident> chargeListIncident() throws SQLException {
        PreparedStatement ps=this.con.prepareCall("SELECT * FROM INCIDENT");
        ResultSet rs=ps.executeQuery();
        List<Incident> listIncident=new ArrayList<>();
        while(rs.next()){
            Incident incident=new Incident();
            incident.setReferance(rs.getString("referance"));
            incident.setStatue(rs.getBoolean("statue"));
            incident.setTime(rs.getDate("time"));
            PreparedStatement psM=this.con.prepareCall("SELECT * FROM member where id=?");
            psM.setString(1,incident.getReferance());
            ResultSet rsM=psM.executeQuery();
            Membre membre=new Membre();
            if(rsM.next()){
                membre.setIdentifiant(rsM.getString("setIdentifiant"));
                membre.setNom(rsM.getString("nom"));
                membre.setPrenom(rsM.getString("prenom"));
                membre.setEmail(rsM.getString("email"));
                membre.setPhone(rsM.getString("phone"));

            }
            incident.setMembre(membre);



            listIncident.add(incident);
        }
        return listIncident;
    }

    @Override
    public Set<Membre> chargerListeMembre(String nomFichier) {
        File file = new File(nomFichier);
        Set<Membre> res = new HashSet<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(nomFichier));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;

            try {
                while ((nextRecord = csvReader.readNext()) != null) {

                    Membre membre = new Membre();
                    membre.setNom(nextRecord[0]);
                    membre.setPrenom(nextRecord[1]);
                    membre.setEmail(nextRecord[2]);
                    membre.setPhone(nextRecord[3]);
                    res.add(membre);

                }
            } catch (CsvValidationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
        }
    }
