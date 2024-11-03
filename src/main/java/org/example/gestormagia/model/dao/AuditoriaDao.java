package org.example.gestormagia.model.dao;

import org.example.gestormagia.model.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaDao extends JpaRepository<Auditoria, Long> {
}
