package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Candidats;

public class CandidatDAO implements DAODB<Candidats> {
    /**
     * Implementació de les regles CRUD i arquitectura DAO a la taula de candidats
     */
    private static final String INSERT_CANDIDAT = "INSERT INTO candidats (candidatura_id, persona_id, provincia_id) VALUES (?, ?, ?)";
    private static final String UPDATE_CANDIDAT = "UPDATE candidats SET candidatura_id = ?, persona_id = ? WHERE candidat_id = ?";
    private static final String DELETE_CANDIDAT = "DELETE FROM candidats WHERE candidat_id = ?";
    private static final String FIND_CANDIDAT = "SELECT * FROM candidats WHERE candidat_id = ?";
    private static final String COUNT_CANDIDATURA = "SELECT COUNT(*) FROM candidats WHERE candidatura_id = ?";
    private static final String SELECT_ALL_CANDIDATS = "SELECT * FROM candidats";

    //Estableix la connexió amb MySQL Workbench
    private Connection con;
    public CandidatDAO(Connection con) {
        this.con = con;
    }


    @Override
    public boolean create(Candidats candidats) throws SQLException {
        return executeUpdate(INSERT_CANDIDAT, candidats);
    }


    @Override
    public boolean update(Candidats candidats) throws SQLException {
        return executeUpdate(UPDATE_CANDIDAT, candidats);
    }
    private boolean executeUpdate(String sql, Candidats candidats) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, candidats.getCandidatura_id());
            ps.setInt(2, candidats.getPersona_id());
            ps.setInt(3, candidats.getCandidat_id());
            ps.executeUpdate();
            return true;
        }
    }
    @Override
    public boolean delete(int id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(DELETE_CANDIDAT)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }
    }
    @Override
    public Candidats exists(int id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(FIND_CANDIDAT)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? construeixCandidats(rs) : null;
            }
        }
    }

    @Override
    public List<Candidats> seleccionarTot() throws SQLException {
        List<Candidats> candidatsList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(SELECT_ALL_CANDIDATS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    candidatsList.add(construeixCandidats(rs));
                }
            }
        }
        return candidatsList;
    }
    private Candidats construeixCandidats(ResultSet rs) throws SQLException {
        int id = rs.getInt("candidat_id");
        int idCandidatura = rs.getInt("candidatura_id");
        int idPersona = rs.getInt("persona_id");
        int idProvincia = rs.getInt("provincia_id");
        return new Candidats(id, idCandidatura, idPersona, idProvincia);
    }
}
