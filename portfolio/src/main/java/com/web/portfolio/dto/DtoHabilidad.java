
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoHabilidad {
    
    private String habilidad;
    private int porcentaje;
    private String color;

      
    public DtoHabilidad() {
    }

    public DtoHabilidad(String habilidad, int porcentaje, String color) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.color = color;
    }
            
}
