
package com.web.portfolio.repository;

import com.web.portfolio.model.Red;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRed extends JpaRepository<Red, Long> {
    
}

