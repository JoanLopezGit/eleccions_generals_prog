package Model;

public class Candidats {
    //Declaració de variables de la taula candidats
    private int candidat_id;
    private int candidatura_id;
    private int persona_id;
    private int provincia_id;

    //Constructor de la classe candidats
    public Candidats(int id, int CandidaturaID, int PersonaID, int ProvinciaID) {
        this.candidat_id = id;
        this.candidatura_id = CandidaturaID;
        this.persona_id = PersonaID;
        this.provincia_id = ProvinciaID;
    }

    //Getters i setters classe candidats
    public int getCandidat_id() {
        return candidat_id;
    }

    public void setCandidat_id(int candidat_id) {
        this.candidat_id = candidat_id;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }
}