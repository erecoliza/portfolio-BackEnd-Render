
package com.web.portfolio.repository;

import com.web.portfolio.model.Red;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRed extends JpaRepository<Red, Long> {
    public Optional<Red> findByRed(String red);
     public boolean existsByRed(String red);
}

