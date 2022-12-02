package com.web.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String empresa;
    private String web;
    private String logo;
    private String puesto;
    private String periodo_desde;
    private String periodo_hasta;
    private String descripcion;

    public Experiencia() {
    }

    public Experiencia( String empresa, String web, String logo, String puesto, String periodo_desde, String periodo_hasta, String descripcion) {        
        this.empresa = empresa;
        this.web = web;
        this.logo = logo;
        this.puesto = puesto;
        this.periodo_desde = periodo_desde;
        this.periodo_hasta = periodo_hasta;
        this.descripcion = descripcion;
    }

}
