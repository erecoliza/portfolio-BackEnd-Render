
package com.web.portfolio.repository;

import com.web.portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona, Long> {
    
}

