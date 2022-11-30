
package com.web.portfolio.repository;

import com.web.portfolio.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<User, Long> {
    
    List<User> findByUsername(String username);    
    
}

