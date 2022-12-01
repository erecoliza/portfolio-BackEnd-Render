
package com.web.portfolio.security.repository;

import com.web.portfolio.security.entity.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findBynombreUsuario(String nombreUsuario);
    
    Boolean existsBynombreUsuario(String nombreUsuario);
    
    Boolean existsByEmail(String email);
    
}
