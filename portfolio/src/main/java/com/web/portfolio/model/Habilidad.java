
package com.web.portfolio.model;

import java.time.LocalTime;
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
    private Long persona_id;
    private String habilidad;
    private int porcentaje;
    private String color;
    private LocalTime fechayhora;       

    public Habilidad() {
    }

    public Habilidad(Long persona_id, String habilidad, int porcentaje, String color, LocalTime fechayhora) {
        this.persona_id = persona_id;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.color = color;
        this.fechayhora = fechayhora;
    }
     
    
}
