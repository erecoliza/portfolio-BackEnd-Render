
package com.web.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String habilidad;
    private int porcentaje;
    private String color;
   
    public Habilidad() {
    }

    public Habilidad(String habilidad, int porcentaje, String color) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.color = color;
    }
     
    
}
