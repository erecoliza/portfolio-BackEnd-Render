
package com.web.portfolio.repository;

import com.web.portfolio.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Long> {
    public Optional<Habilidad> findByHabilidad(String habilidad);
    public Boolean existsByHabilidad(String habilidad);  
    
}

