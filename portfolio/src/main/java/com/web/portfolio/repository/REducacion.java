
package com.web.portfolio.repository;

import com.web.portfolio.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Long> {
     public Optional<Educacion> findByEstablecimiento(String establecimiento);
     public boolean existsByEstablecimiento(String establecimiento);
    
}

