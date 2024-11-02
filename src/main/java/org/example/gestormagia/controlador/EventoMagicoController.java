package org.example.gestormagia.controlador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.gestormagia.model.entidades.EventoMagico;
import org.example.gestormagia.servicios.EventoMagicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/evento")
public class EventoMagicoController {

    @Autowired
    private EventoMagicoServicio eventoMagicoServicio;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "0") String error){
        model.addAttribute("eventosMagicos", eventoMagicoServicio.listadoEventos());
        model.addAttribute("error", error);
        return "listaHechizos";
    }

    @GetMapping("/formulario")
    public String formulario(Model model){
        model.addAttribute("eventoMagico", new EventoMagico());
        return "formularioHechizo";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute EventoMagico eventoMagico){
        int result = eventoMagicoServicio.guardarEvento(eventoMagico);
        if (result == 0){
            return "redirect:/evento/list";
        }else {
            return "redirect:/evento/list?error=" + result;
        }

    }

    @GetMapping("/salir")
    public String salir(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/volver")
    public String volver(){
        return "redirect:/evento/list";
    }

    @GetMapping("/prohibido")
    public String prohibido(){
        return "prohibido";
    }
}
