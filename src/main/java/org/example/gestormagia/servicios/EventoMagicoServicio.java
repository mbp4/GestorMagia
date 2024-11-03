package org.example.gestormagia.servicios;

import org.example.gestormagia.DatabaseConfig;
import org.example.gestormagia.model.entidades.EventoMagico;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoMagicoServicio {

    public List<EventoMagico> listadoEventos() {
        List<EventoMagico> eventos = new ArrayList<>();
        String query = "SELECT * FROM eventosMagicos";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                EventoMagico evento = new EventoMagico();
                // Set properties of evento from resultSet
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    }

    public int guardarEvento(EventoMagico eventoMagico) {
        int result = 0;
        String query = "INSERT INTO eventosMagicos (mago, tipo) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, eventoMagico.getMago());
            statement.setString(2, eventoMagico.getTipo());

            if (eventoMagico.getMago().equals("Voldemort")) {
                result = 1;
            } else if (eventoMagico.getTipo().equals("Pocima")) {
                result = 2;
            }

            if (result == 0) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}