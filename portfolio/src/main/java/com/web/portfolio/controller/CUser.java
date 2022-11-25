
package com.web.portfolio.controller;

import com.web.portfolio.model.User;
import com.web.portfolio.service.SUser;
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
public class CUser {
    @Autowired
    SUser UserServ;
    
    
    @PostMapping("/new/user")
    public void agregarUsuario(@RequestBody User usr) {
        UserServ.Save(usr);
       } 
    
    @GetMapping("/ver/users")   
    @ResponseBody
    public List <User> verUsers() {
        return UserServ.list();
        }
    
    @GetMapping("/ver/user/{id}")
    @ResponseBody
    public Optional <User> verUser(@PathVariable Long id) {
        return UserServ.getONe(Long.MIN_VALUE);
        }
    
    
    @DeleteMapping("/delete/{id}")      
    public void eliminarUsuario(@PathVariable Long id) {
            UserServ.Delete(id);
        }       
    
}
