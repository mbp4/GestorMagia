package org.example.gestormagia.controlador;

import org.example.gestormagia.model.dao.AuditoriaDao;
import org.example.gestormagia.model.entidades.Auditoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaDao auditoriaDao;

    @GetMapping("/listar")
    public String list(Model model) {
        List<Auditoria> auditorias = auditoriaDao.findAll();
        model.addAttribute("auditorias", auditorias);
        return "listaAuditoria";
    }

}
