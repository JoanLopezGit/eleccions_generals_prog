package DAO;

import Model.Municipis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MunicipisDAO implements DAODB <Municipis> {
    private final Connection connection;

    public MunicipisDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean create(Municipis municipi) throws SQLException {
        String query = "INSERT INTO municipis (nom, codi_ine, provincia_id, districte) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            omplirSentencia(municipi, statement);
            statement.executeUpdate();
        }
        return true;
    }
    @Override
    public boolean update(Municipis municipi) throws SQLException {
        String query = "UPDATE municipis SET nom = ?, codi_ine = ?, provincia_id = ?, districte = ? WHERE municipi_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            omplirSentencia(municipi, statement);
            statement.setInt(5, municipi.getMunicipi_id());
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM municipis WHERE municipi_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        return true;
    }

    @Override
    public Municipis exists(int id) throws SQLException {
        String query = "SELECT * FROM municipis WHERE municipi_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return convertirFilaMunicipi(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Municipis> seleccionarTot() throws SQLException {
        String query = "SELECT * FROM municipis";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Municipis municipi = convertirFilaMunicipi(rs);
                    System.out.println(municipi);
                }
            }
        }
        return null;
    }

    private void omplirSentencia(Municipis municipi, PreparedStatement statement) throws SQLException {
        statement.setString(1, municipi.getNom_municipi());
        statement.setInt(2, municipi.getCodiINE());
        statement.setInt(3, municipi.getProvincia_id());
        statement.setString(4, municipi.getDistricte());
    }

    private Municipis convertirFilaMunicipi(ResultSet rs) throws SQLException {
        int id = rs.getInt("municipi_id");
        String nom = rs.getString("nom");
        int codiINE = rs.getInt("codi_ine");
        int provincia_id = rs.getInt("provincia_id");
        String districte = rs.getString("districte");

        return new Municipis(id, nom, codiINE, provincia_id, districte);
    }
}
