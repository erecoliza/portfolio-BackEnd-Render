
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    
    private String apellidonombre;
    private String imagen;
    private String telefono;
    private String email;
    private String posicion;
    private String acercade;  
    
    public DtoPersona() {
    }

    public DtoPersona(String apellidonombre, String imagen, String telefono, String email, String posicion, String acercade) {
        this.apellidonombre = apellidonombre;
        this.imagen = imagen;
        this.telefono = telefono;
        this.email = email;
        this.posicion = posicion;
        this.acercade = acercade;
    }
            
}
