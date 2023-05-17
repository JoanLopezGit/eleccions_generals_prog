package Model;

public class Municipis {
    //Declaració de variables de la taula municipis
    private int municipi_id;
    private int provincia_id;
    private String nom_municipi;
    private int codiINE;
    private String districte;

    //Constructor classe municipis
    public Municipis(int id, String nom, int codiIne, int provincia_id, String districte) {
        this.municipi_id = id;
        this.provincia_id = this.provincia_id;
        this.nom_municipi = nom;
        this.codiINE = codiIne;
        this.districte = districte;
    }

    //Getters i setters classe municipis
    public int getMunicipi_id() {
        return municipi_id;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public String getNom_municipi() {
        return nom_municipi;
    }

    public int getCodiINE() {
        return codiINE;
    }

    public String getDistricte() {
        return districte;
    }

    public void setMunicipi_id(int municipi_id) {
        this.municipi_id = municipi_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setNom_municipi(String nom_municipi) {
        this.nom_municipi = nom_municipi;
    }

    public void setCodiINE(int codiINE) {
        this.codiINE = codiINE;
    }

    public void setDistricte(String districte) {
        this.districte = districte;
    }
}