
package com.web.portfolio.repository;

import com.web.portfolio.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findByEmpresa(String empresa);
    public Boolean existsByEmpresa(String empresa);    
}

