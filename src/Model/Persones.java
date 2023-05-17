package Model;

import java.util.Date;

public class Persones {
    //Declaració de variables per la taula persones
    private int persona_id;
    private String persona_nom;
    private String primerCognom;
    private String segonCognom;
    private String sexe;
    private Date data_naixement;
    private String dni;

    //Constructor classe persones
    public Persones(int id, String nom, String cog1, String cog2, String sexe, Date data_naixement, String dni) {
        this.persona_id = id;
        this.persona_nom = nom;
        this.primerCognom = cog1;
        this.segonCognom = cog2;
        this.sexe = sexe;
        this.data_naixement = data_naixement;
        this.dni = dni;
    }

    //Getters i setters classe persones
    public int getPersona_id() {
        return persona_id;
    }

    public String getPersona_nom() {
        return persona_nom;
    }

    public String getPrimerCognom() {
        return primerCognom;
    }

    public String getCog2() {
        return segonCognom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getData_naixement() {
        return data_naixement;
    }

    public String getDni() {
        return dni;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setPersona_nom(String persona_nom) {
        this.persona_nom = persona_nom;
    }

    public void setPrimerCognom(String primerCognom) {
        this.primerCognom = primerCognom;
    }

    public void setCog2(String cog2) {
        this.segonCognom = cog2;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setData_naixement(Date data_naixement) {
        this.data_naixement = data_naixement;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}