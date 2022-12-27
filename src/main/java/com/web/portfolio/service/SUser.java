package com.web.portfolio.service;

import com.web.portfolio.model.User;
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
    
    public Optional<User> getOne(Long id){
        return rUser.findById(id);
    }
    
    public List<User> findByname(String username) {
        return rUser.findByUsername(username);
    }
          
    public void Save(User usr) {
        rUser.save(usr);        
    }
    
    public void Delete(Long id) {
        rUser.deleteById(id);
    }     
    
    
}