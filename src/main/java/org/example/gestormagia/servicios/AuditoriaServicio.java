package org.example.gestormagia.servicios;

import org.example.gestormagia.AuditoriaDatabaseConfig;
import org.example.gestormagia.model.entidades.Auditoria;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriaServicio {

    public void guardarAuditoria(Auditoria auditoria) {
        String query = "INSERT INTO auditorias (usuario, fecha, accion) VALUES (?, ?, ?)";

        try (Connection connection = AuditoriaDatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, auditoria.getUsuario());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(auditoria.getFecha()));
            statement.setString(3, auditoria.getAccion());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new audit record was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Auditoria> listarAuditorias() {
        List<Auditoria> auditorias = new ArrayList<>();
        String query = "SELECT * FROM auditorias";

        try (Connection connection = AuditoriaDatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Auditoria auditoria = new Auditoria();
                auditoria.setId(resultSet.getLong("id"));
                auditoria.setUsuario(resultSet.getString("usuario"));
                auditoria.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime());
                auditoria.setAccion(resultSet.getString("accion"));
                auditorias.add(auditoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return auditorias;
    }
}
