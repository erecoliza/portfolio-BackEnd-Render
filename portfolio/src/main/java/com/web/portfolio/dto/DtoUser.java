
package com.web.portfolio.dto;

import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoUser {
    
    private String username;
    private String email;
    private String password;
    private LocalTime fechayhora; 
    
    public DtoUser() {
    }

    public DtoUser(String username, String email, String password, LocalTime fechayhora) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fechayhora = fechayhora;
    }
            
}
