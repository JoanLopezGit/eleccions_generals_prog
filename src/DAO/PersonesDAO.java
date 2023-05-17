package DAO;

import Model.Persones;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonesDAO implements DAODB<Persones> {
    private Connection con;

    public PersonesDAO(Connection con) {
        this.con = con;
    }

    private Persones convertirFilaPersones(ResultSet rs) throws SQLException {
        int id = rs.getInt("persona_id");
        String nom = rs.getString("nom");
        String cog1 = rs.getString("cog1");
        String cog2 = rs.getString("cog2");
        String sexe = rs.getString("sexe");
        java.util.Date dataNaixement = rs.getDate("data_naixement");
        String dni = rs.getString("dni");
        return new Persones(id, nom, cog1, cog2, sexe, dataNaixement, dni);
    }

    private void omplirSentencia(Persones persones, PreparedStatement ps) throws SQLException {
        ps.setString(1, persones.getPersona_nom());
        ps.setString(2, persones.getPrimerCognom());
        ps.setString(3, persones.getCog2());
        ps.setString(4, persones.getSexe());
        ps.setDate(5, new java.sql.Date(persones.getData_naixement().getTime()));
        ps.setString(6, persones.getDni());
    }
    @Override
    public List<Persones> seleccionarTot() throws SQLException {
        String sql = "SELECT * FROM persones";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Persones> listPersones = new ArrayList<>();
                while (rs.next()) {
                    listPersones.add(convertirFilaPersones(rs));
                }
                return listPersones;
            }
        }
    }
    @Override
    public Persones exists(int id) throws SQLException {
        String sql = "SELECT * FROM persones WHERE persona_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return convertirFilaPersones(rs);
                } else {
                    return null;
                }
            }
        }
    }
    @Override
    public boolean create(Persones persones) throws SQLException {
        String sql = "INSERT INTO persones (nom, cog1, cog2, sexe, data_naixemnet, dni) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            omplirSentencia(persones, ps);
            ps.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean update(Persones persones) throws SQLException {
        String sql = "UPDATE persones SET nom = ?, cog1 = ?, cog2 = ?, sexe = ?, data_naixement = ?, dni = ? WHERE persona_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            omplirSentencia(persones, ps);
            ps.setInt(7, persones.getPersona_id());
            ps.executeUpdate();
        }
        return true;
    }
    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM persones WHERE persona_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        return true;
    }
}
