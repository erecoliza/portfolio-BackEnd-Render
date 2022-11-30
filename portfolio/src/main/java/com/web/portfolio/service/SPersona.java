package com.web.portfolio.service;

import com.web.portfolio.model.Persona;
import com.web.portfolio.repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SPersona {
    @Autowired            
    RPersona rPersona;
    
    public List<Persona> list() {
        return rPersona.findAll();
    }
    
    public Optional<Persona> getONe(Long id){
        return rPersona.findById(id);
    }
    
    public void Save(Persona pers) {
        rPersona.save(pers);        
    }
    
    public void Delete(Long id) {
        rPersona.deleteById(id);
    }     
    
    
}
