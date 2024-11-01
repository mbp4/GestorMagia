package org.example.gestormagia.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.gestormagia.model.dao.AuditoriaDao;
import org.example.gestormagia.model.entidades.Auditoria;
import org.example.gestormagia.seguridad.SeguridadServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class ConfigAspect {

    @Autowired
    private SeguridadServicio seguridadServicio;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuditoriaDao auditoriaDao;

    @Around("execution(* org.example.clase.controlador.EventoMagicoController.formulario(..)) || execution(* org.example.clase.controlador.AuditoriaController.list(..))")
    public Object checkearPermiso(ProceedingJoinPoint joinPoint) throws Throwable {
        String rolUsuario = seguridadServicio.getRolUsuarioActual();
        if (rolUsuario.equals("ROLE_ADMIN")) {
            return joinPoint.proceed();
        }else {
            return "redirect:/evento/prohibido";
        }
    }

    @AfterReturning(pointcut = "execution(* org.example.clase.servicios.EventoMagicoServicio.guardarEvento(..))", returning = "result")
    public void controlErrorGuardado(JoinPoint joinPoint, int result){
        if (result > 0){
            if (result == 1){
                logger.error("Se intento dar de alta un evento mágico causado por Voldemort");
            } else if (result == 2) {
                logger.error("Se intento dar de alta un evento magico de tipo Pocima");
            }
        }

        Auditoria auditoria = new Auditoria();
        auditoria.setUsuario(seguridadServicio.getUserName());
        auditoria.setFecha(LocalDateTime.now());
        if (result == 0){
            auditoria.setAccion("Guardado de evento magico");
        } else {
            auditoria.setAccion("Se intento hacer un guardado con error");
        }
        auditoriaDao.save(auditoria);
    }

}
