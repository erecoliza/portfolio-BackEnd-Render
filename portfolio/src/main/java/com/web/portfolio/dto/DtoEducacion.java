
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoEducacion {

    private String establecimiento;
    private String web;
    private String logo;
    private String carrera;
    private String periodo_desde;
    private String periodo_hasta;    
    private String descripcion;
   
    public DtoEducacion() {
    }

    public DtoEducacion(String establecimiento, String web, String logo, String carrera, String periodo_desde, String periodo_hasta, String descripcion) {
        this.establecimiento = establecimiento;
        this.web = web;
        this.logo = logo;
        this.carrera = carrera;
        this.periodo_desde = periodo_desde;
        this.periodo_hasta = periodo_hasta;
        this.descripcion = descripcion;
    }

            
}
