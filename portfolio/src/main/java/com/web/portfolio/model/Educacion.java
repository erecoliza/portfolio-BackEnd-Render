
package com.web.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String establecimiento;
    private String web;
    private String logo;
    private String carrera;
    private String periodo_desde;
    private String periodo_hasta;  
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    public Educacion() {
    }

    public Educacion(String establecimiento, String web, String logo, String carrera, String periodo_desde, String periodo_hasta, String descripcion) {
        this.establecimiento = establecimiento;
        this.web = web;
        this.logo = logo;
        this.carrera = carrera;
        this.periodo_desde = periodo_desde;
        this.periodo_hasta = periodo_hasta;
        this.descripcion = descripcion;
    }

}
