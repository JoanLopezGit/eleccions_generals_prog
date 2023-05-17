package Model;

public class Candidatures {
    //Declaració de variables de la taula candidatures
    private int candidatura_id;
    private int eleccioID;
    private String nom_curt;
    private String nom_llarg;
    private int codi_candidatura;
    private int codi_acumulació_provincia;
    private int codi_acumulacio_ca;
    private int codi_acumulacio_nacional;

    //Constructor de la classe candidatures
    public Candidatures(int candidatura_id, String nomCurt, String nomLlarg, int eleccioId, int codiCandidatura, int codiAcumulacioProvincia, int codiAcumulacioCa, int codiAcumulacioNacional) {
        this.candidatura_id = candidatura_id;
        this.nom_curt = nomCurt;
        this.nom_llarg = nomLlarg;
        this.eleccioID = eleccioId;
        this.codi_candidatura = codiCandidatura;
        this.codi_acumulació_provincia = codiAcumulacioProvincia;
        this.codi_acumulacio_ca = codiAcumulacioCa;
        this.codi_acumulacio_nacional = codiAcumulacioNacional;
    }

    //Getters i setters classe candidatures
    public int getIdEleccio() {
        return eleccioID;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }

    public int getCodi_candidatura() {
        return codi_candidatura;
    }

    public int getCodi_acumulació_provincia() {
        return codi_acumulació_provincia;
    }

    public int getCodi_acumulacio_ca() {
        return codi_acumulacio_ca;
    }

    public int getCodi_acumulacio_nacional() {
        return codi_acumulacio_nacional;
    }

    public String getNom_curt() {
        return nom_curt;
    }

    public String getNom_llarg() {
        return nom_llarg;
    }


    }

