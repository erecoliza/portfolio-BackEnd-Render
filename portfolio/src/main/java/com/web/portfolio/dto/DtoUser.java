
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoUser {
    
    private String username;
    private String email;
    private String password;
    
    public DtoUser() {
    }

    public DtoUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
            
}
