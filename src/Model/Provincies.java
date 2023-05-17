package Model;

public class Provincies {
    //Declaració de variables de la taula provincies
    private int provincia_id;
    private int comunitat_aut_id;
    private int codiINE;
    private String nom;

    //Constructor de classe provincies
    public Provincies(int provincia_id, int comunitat_aut_id, String nom, int codiINE) {
        this.provincia_id = provincia_id;
        this.comunitat_aut_id = comunitat_aut_id;
        this.nom = nom;
        this.codiINE = codiINE;
    }

    //Getters i setters de la classe provincies
    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public int getidComunitatAutonoma() {
        return comunitat_aut_id;
    }

    public void setidComunitatAutonoma(int idComunitatAutonoma) {
        this.comunitat_aut_id = idComunitatAutonoma;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodiINE() {
        return codiINE;
    }

    public void setCodiINE(int codiINE) {
        this.codiINE = codiINE;
    }
}