
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long persona_id;
    private String proyecto;
    private String web;
    private String fecha;
    private String descripcion;
    private LocalTime fechayhora;       

    public Proyecto() {
    }

    public Proyecto(Long persona_id, String proyecto, String web, String fecha, String descripcion, LocalTime fechayhora) {
        this.persona_id = persona_id;
        this.proyecto = proyecto;
        this.web = web;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.fechayhora = fechayhora;
    }
   
}
