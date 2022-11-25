
package com.web.portfolio.repository;

import com.web.portfolio.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Long> {
    
}

