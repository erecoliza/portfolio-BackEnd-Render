
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProyecto {
    
    private String proyecto;
    private String web;
    private String fecha;   
    private String descripcion;

    public DtoProyecto() {
    }

    public DtoProyecto(String proyecto, String web, String fecha, String descripcion) {
        this.proyecto = proyecto;
        this.web = web;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
            
}
