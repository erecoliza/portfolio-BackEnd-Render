package com.web.portfolio.service;

import com.web.portfolio.entity.User;
import com.web.portfolio.repository.RUser;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class SUser {
    @Autowired            
    RUser rUser;
    
    public List<User> list() {
        return rUser.findAll();
    }
    
    public Optional<User> getONe(Long id){
        return rUser.findById(id);
    }
    
    public void Save(User usr) {
        rUser.save(usr);        
    }
    
    public void Delete(Long id) {
        rUser.deleteById(id);
    }

    
    
    
    
}
