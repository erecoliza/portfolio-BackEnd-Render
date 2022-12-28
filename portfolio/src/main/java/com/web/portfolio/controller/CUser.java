
package com.web.portfolio.controller;

import com.web.portfolio.model.User;
import com.web.portfolio.service.SUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://portfolio-8cf55.web.app")

public class CUser {
    
    @Autowired  SUser UserServ;
    
    @PostMapping("/new")
    public String agregarUsuario(@RequestBody User usr) {
        UserServ.Save(usr);
        return "El usuario fue creado correctamente";
       } 
    
    @GetMapping("/list")   
    @ResponseBody
    public List <User> verUsers() {
        return UserServ.list();
        }
    
    @GetMapping("/detailbyid/{id}")
    @ResponseBody
    public Optional <User> verUser(@PathVariable Long id) {
        return UserServ.getOne(id);
        }

    @GetMapping("/detailbyusername/{username}")
    @ResponseBody
    public List <User> verUsername(@PathVariable String username) {
        return UserServ.findByname(username);
        }
       
    @DeleteMapping("/delete/{id}")      
    public String eliminarUsuario(@PathVariable Long id) {
            UserServ.Delete(id);     
             return "El Usuario fue eliminado correctamente";
        }       
    
}
