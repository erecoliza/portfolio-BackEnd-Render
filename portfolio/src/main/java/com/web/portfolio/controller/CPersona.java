
package com.web.portfolio.controller;

import com.web.portfolio.model.Persona;
import com.web.portfolio.service.SPersona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CPersona {
    @Autowired
    SPersona PersonaServ;
    
    
    @PostMapping("/new/persona")
    public void agregarUsuario(@RequestBody Persona pers) {
        PersonaServ.Save(pers);
       } 
    
    @GetMapping("/ver/personas")   
    @ResponseBody
    public List <Persona> verPersonas() {
        return PersonaServ.list();
        }
    
    @GetMapping("/ver/persona/{id}")
    @ResponseBody
    public Optional <Persona> verPersona(@PathVariable Long id) {
        return PersonaServ.getONe(Long.MIN_VALUE);
        }
    
    
    @DeleteMapping("/delete/persona/{id}")      
    public void eliminarUsuario(@PathVariable Long id) {
            PersonaServ.Delete(id);
        }       
    
}
