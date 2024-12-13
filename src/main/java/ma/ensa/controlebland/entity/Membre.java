package ma.ensa.controlebland.entity;

import java.util.List;
import java.util.Objects;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private List<Incident> incidents;

    public Membre(String identifiant, String nom, String prenom, String email, String phone, List<Incident> incidents) {
        this.identifiant = String.valueOf(System.currentTimeMillis());
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phone = phone;
        this.incidents = incidents;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public Membre() {

    }

    @Override
    public boolean equals(Object obj) {
        return this.identifiant==((Membre)obj).identifiant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant);
    }

    public String getIdentifiant() {
        return this.identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
