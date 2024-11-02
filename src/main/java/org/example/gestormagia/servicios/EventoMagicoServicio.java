package org.example.gestormagia.servicios;

import org.example.gestormagia.model.dao.EventoMagicoDao;
import org.example.gestormagia.model.entidades.EventoMagico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoMagicoServicio {

    @Autowired
    private EventoMagicoDao eventoMagicoDao;

    public List<EventoMagico> listadoEventos(){
        List<EventoMagico> eventos = eventoMagicoDao.findAll();
        return eventos;
    }

    public int guardarEvento(EventoMagico eventoMagico){
        int result = 0;
        if (eventoMagico.getMago().equals("Voldemort")){
            result = 1;
        }else if (eventoMagico.getTipo().equals("Pocima")){
            result = 2;
        }
        if (result == 0) {
            eventoMagicoDao.save(eventoMagico);
        }

        return result;
    }
}
