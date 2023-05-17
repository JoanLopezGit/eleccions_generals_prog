package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Candidatures;


public class CandidaturesDAO implements DAODB<Candidatures> {
    private Connection con;

    public CandidaturesDAO(Connection con) {
        this.con = con;
    }

    @Override
    public boolean create(Candidatures canditures) throws SQLException {
        String sql = "INSERT INTO candidatures (eleccio_id, codi_candidatura, nom_curt, nom_llarg, codi_acumulacio_provincia, codi_acumulacio_ca, codi_acumulacio_nacional) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, canditures.getIdEleccio());
            ps.setInt(2, canditures.getCandidatura_id());
            ps.setString(3, canditures.getNom_curt());
            ps.setString(4, canditures.getNom_llarg());
            ps.setInt(5, canditures.getCodi_acumulació_provincia());
            ps.setInt(6, canditures.getCodi_acumulacio_ca());
            ps.setInt(7, canditures.getCodi_acumulacio_nacional());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Candidatures candidature) throws SQLException {
        String sql = "UPDATE candidatures SET eleccio_id = ?, codi_candidatura = ?, nom_curt = ?, nom_llarg = ?, codi_acumulacio_provincia = ?, codi_acumulacio_ca = ?, codi_acumulacio_nacional = ? WHERE candidatura_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, candidature.getIdEleccio());
            ps.setInt(2, candidature.getCodi_candidatura());
            ps.setString(3, candidature.getNom_curt());
            ps.setString(4, candidature.getNom_llarg());
            ps.setInt(5, candidature.getCodi_acumulació_provincia());
            ps.setInt(6, candidature.getCodi_acumulacio_ca());
            ps.setInt(7, candidature.getCodi_acumulacio_nacional());
            ps.setInt(8, candidature.getCandidatura_id());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM candidatures WHERE candidatura_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Candidatures exists(int id) throws SQLException {
        String sql = "SELECT * FROM candidatures WHERE candidatura_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int eleccioId = rs.getInt("eleccio_id");
                    String nomCurt = rs.getString("nom_curt");
                    String nomLlarg = rs.getString("nom_llarg");
                    int codiCandidatura = rs.getInt("codi_candidatura");
                    int codiAcumulacioProvincia = rs.getInt("codi_acumulacio_provincia");
                    int codiAcumulacioCa = rs.getInt("codi_acumulacio_ca");
                    int codiAcumulacioNacional = rs.getInt("codi_acumulacio_nacional");
                    Candidatures candidature = new Candidatures(id, nomCurt, nomLlarg, eleccioId, codiCandidatura, codiAcumulacioProvincia, codiAcumulacioCa, codiAcumulacioNacional);
                    return candidature;
                } else {
                    return null;
                }
            }
        }
    }
    @Override
    public List<Candidatures> seleccionarTot() throws SQLException {
        List<Candidatures> candidatures = new ArrayList<>();
        String sql = "SELECT * FROM candidatures";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("candidatura_id");
                String nomCurt = rs.getString("nom_curt");
                String nomLlarg = rs.getString("nom_llarg");
                int eleccioId = rs.getInt("eleccio_id");
                int codiCandidatura = rs.getInt("codi_candidatura");
                int codiAcumulacioProvincia = rs.getInt("codi_acumulacio_provincia");
                int codiAcumulacioCa = rs.getInt("codi_acumulacio_ca");
                int codiAcumulacioNacional = rs.getInt("codi_acumulacio_nacional");
                Candidatures candidature = new Candidatures(id, nomCurt, nomLlarg, eleccioId, codiCandidatura, codiAcumulacioProvincia, codiAcumulacioCa, codiAcumulacioNacional);
                candidatures.add(candidature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return candidatures;
    }
}