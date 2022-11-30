
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    private String apellido_nombre;
    private String imagen;
    private String telefono;
    private String email;
    private String posicion;
    private String acercade;  
    
    public DtoPersona() {
    }

    public DtoPersona(String apellido_nombre, String imagen, String telefono, String email, String posicion, String acercade) {
        this.apellido_nombre = apellido_nombre;
        this.imagen = imagen;
        this.telefono = telefono;
        this.email = email;
        this.posicion = posicion;
        this.acercade = acercade;
    }
            
}
