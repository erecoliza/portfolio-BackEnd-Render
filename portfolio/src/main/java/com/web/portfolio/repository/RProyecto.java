
package com.web.portfolio.repository;

import com.web.portfolio.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Long> {
    public Optional<Proyecto> findByProyecto(String proyecto);
    //public Boolean existByProyecto(String proyecto); 
    
}

