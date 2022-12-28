
package com.web.portfolio.controller;

import com.web.portfolio.dto.DtoPersona;
import com.web.portfolio.dto.Mensaje;
import com.web.portfolio.model.Persona;
import com.web.portfolio.service.SPersona;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("persona")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolio-8cf55.web.app")
public class CPersona {
    
    @Autowired SPersona PersonaServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = PersonaServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")long id){
        if(!PersonaServ.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = PersonaServ.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtopers) {
        if (StringUtils.isBlank(dtopers.getApellidonombre())) {
            return new ResponseEntity(new Mensaje("Apellido y Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(PersonaServ.existByApellidonombre(dtopers.getApellidonombre())) {            
            return new ResponseEntity(new Mensaje("Apellido y Nombre Ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopers.getApellidonombre(), dtopers.getImagen() 
                ,dtopers.getTelefono(), dtopers.getEmail(), dtopers.getPosicion()
                , dtopers.getAcercade());        
        PersonaServ.Save(persona);
        return new ResponseEntity(new Mensaje("Persona Agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoPersona dtopers) {
        if(!PersonaServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
        if(PersonaServ.existByApellidonombre(dtopers.getApellidonombre()))
            return new ResponseEntity(new Mensaje("Esa Persona YA Existe"), HttpStatus.BAD_REQUEST);
       if(StringUtils.isBlank(dtopers.getApellidonombre()))      
           return new ResponseEntity(new Mensaje("Apellido y Nombre no debe ser blanco"), HttpStatus.BAD_REQUEST);
       
       Persona persona = PersonaServ.getOne(id).get();       
       persona.setApellidonombre(dtopers.getApellidonombre());
       persona.setImagen(dtopers.getImagen());
       persona.setTelefono(dtopers.getTelefono());
       persona.setEmail(dtopers.getEmail());
       persona.setPosicion(dtopers.getPosicion());
       persona.setAcercade(dtopers.getAcercade());
       PersonaServ.Save(persona);
       return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")    
    public ResponseEntity<?> delete(@PathVariable("id") Long id, @RequestBody DtoPersona dtopers) {
       if(!PersonaServ.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.BAD_REQUEST);
       PersonaServ.Delete(id);
       return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }
}
