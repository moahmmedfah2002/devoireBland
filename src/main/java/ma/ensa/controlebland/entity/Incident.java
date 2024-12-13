package ma.ensa.controlebland.entity;

import java.sql.Date;

public class Incident {
    private String referance;
    private Date time;
    private boolean statue;
    private Membre membre;
    public Incident(String referance, Date time, boolean statue) {
        this.referance = referance;
        this.time = time;
        this.statue = statue;


    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Incident() {

    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isStatue() {
        return statue;
    }

    public void setStatue(boolean statue) {
        this.statue = statue;
    }
}
