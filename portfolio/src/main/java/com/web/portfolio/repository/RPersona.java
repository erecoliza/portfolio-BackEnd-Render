package com.web.portfolio.repository;

import com.web.portfolio.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository<Persona, Long> {
    public Optional<Persona> findByApellidonombre(String apellidonombre);
    public boolean existsByApellidonombre(String apellidonombre);
    
    
}
