package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Comunitats_autonomes;
public class comunitats_autonomesDAO implements DAODB<Comunitats_autonomes> {
    private Connection con;
    public comunitats_autonomesDAO(Connection con) {
        this.con = con;
    }
    @Override
    public boolean create(Comunitats_autonomes comunitat) throws SQLException {
        String sql = "INSERT INTO comunitats_autonomes (nom, codi_ine) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, comunitat.getNom_comunitat_aut());
            ps.setInt(2, comunitat.getCodi_ine());
            return ps.executeUpdate() > 0;
        }
    }
    @Override
    public boolean update(Comunitats_autonomes comunitat) throws SQLException {
        String sql = "UPDATE comunitats_autonomes SET nom = ? WHERE comunitat_aut_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, comunitat.getNom_comunitat_aut());
            ps.setInt(2, comunitat.getComunitat_aut_id());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Comunitats_autonomes exists(int id) throws SQLException {
        String sql = "SELECT * FROM comunitats_autonomes WHERE comunitat_aut_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    int codiINE = rs.getInt("codi_ine");
                    return new Comunitats_autonomes(id, nom, codiINE);
                }
                return null;
            }
        }
    }
    @Override
    public List<Comunitats_autonomes> seleccionarTot() throws SQLException {
        String sql = "SELECT * FROM comunitats_autonomes";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Comunitats_autonomes> comunitats = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("comunitat_aut_id");
                    String nom = rs.getString("nom");
                    int codiINE = rs.getInt("codi_ine");
                    comunitats.add(new Comunitats_autonomes(id, nom, codiINE));
                }
                return comunitats;
            }
        }
    }
}

