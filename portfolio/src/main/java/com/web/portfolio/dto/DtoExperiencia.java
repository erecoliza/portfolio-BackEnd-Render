
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {

    private String empresa;
    private String web;
    private String logo;
    private String puesto;
    private String periodo_desde;
    private String periodo_hasta;    
    private String descripcion;
   
    public DtoExperiencia() {
    }

    public DtoExperiencia(String empresa, String web, String logo, String puesto, String periodo_desde, String periodo_hasta, String descripcion) {
        this.empresa = empresa;
        this.web = web;
        this.logo = logo;
        this.puesto = puesto;
        this.periodo_desde = periodo_desde;
        this.periodo_hasta = periodo_hasta;
        this.descripcion = descripcion;
    }

            
}
