package Model;

public class Comunitats_autonomes {
    //Declaració de variables de la taula comunitats_autonomes
    private int comunitat_aut_id;
    private String nom_comunitat_aut;
    private int codi_ine;

    //Constructor de la classe comunitats_autonomes
    public Comunitats_autonomes(int comunitatAutId, String nom, int codiINE) {
        this.comunitat_aut_id = comunitat_aut_id;
        this.nom_comunitat_aut = nom;
        this.codi_ine = codiINE;
    }

    //Getters i setters de la taula comunitats_autonomes
    public int getComunitat_aut_id() {
        return comunitat_aut_id;
    }

    public void setComunitat_aut_id(int comunitatAutId) {
        this.comunitat_aut_id = comunitatAutId;
    }

    public String getNom_comunitat_aut() {
        return nom_comunitat_aut;
    }

    public void setNom_comunitat_aut(String nom_comunitat_aut) {
        this.nom_comunitat_aut = nom_comunitat_aut;
    }

    public int getCodi_ine() {
        return codi_ine;
    }

    public void setCodi_ine(int codi_ine) {
        this.codi_ine = codi_ine;
    }
}