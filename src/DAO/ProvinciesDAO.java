package DAO;

import Model.Provincies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProvinciesDAO implements DAODB<Provincies> {
    private final Connection connection;

    public ProvinciesDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Provincies provincia) throws SQLException {
        String query = "INSERT INTO provincies (comunitat_aut_id, nom, codi_ine) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            omplirSentencia(provincia, statement);
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean update(Provincies provincia) throws SQLException {
        String query = "UPDATE provincies SET comunitat_aut_id = ?, nom = ? WHERE provincia_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            omplirSentencia(provincia, statement);
            statement.setInt(3, provincia.getProvincia_id());
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM provincies WHERE provincia_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public Provincies exists(int id) throws SQLException {
        String query = "SELECT * FROM provincies WHERE provincia_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return convertirFilaProvincia(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Provincies> seleccionarTot() throws SQLException {
        String query = "SELECT * FROM provincies";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Provincies provincia = convertirFilaProvincia(rs);
                    System.out.println(provincia);
                }
            }
        }
        return null;
    }
    private void omplirSentencia(Provincies provincia, PreparedStatement statement) throws SQLException {
        statement.setInt(1, provincia.getidComunitatAutonoma());
        statement.setString(2, provincia.getNom());
        statement.setInt(3, provincia.getCodiINE());
    }
    private Provincies convertirFilaProvincia(ResultSet rs) throws SQLException {
        int id = rs.getInt("provincia_id");
        int idComunitat = rs.getInt("comunitat_aut_id");
        String nom = rs.getString("nom");
        int idCodiIne = rs.getInt("codi_ine");

        return new Provincies(id, idComunitat, nom, idCodiIne);
    }
}
