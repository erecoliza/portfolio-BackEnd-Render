
package com.web.portfolio.model;

import javax.persistence.Column;
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
    private String proyecto;
    private String web;
    private String fecha;
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String proyecto, String web, String fecha, String descripcion) {
        this.proyecto = proyecto;
        this.web = web;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
   
}
