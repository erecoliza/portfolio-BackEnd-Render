package com.web.portfolio.entity;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalTime fechayhora;  

    public User() {
    }

    public User(String username, String email, String password, LocalTime fechayhora) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fechayhora = fechayhora;
    }   
    
    
}
