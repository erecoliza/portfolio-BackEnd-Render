
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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        
    private String apellidonombre;
    private String imagen;
    private String telefono;
    private String email;
    private String posicion;
    @Column(columnDefinition = "TEXT")
    private String acercade;    

    public Persona() {
    }

    public Persona(String apellidonombre, String imagen, String telefono, String email, String posicion, String acercade) {
        this.apellidonombre = apellidonombre;
        this.imagen = imagen;
        this.telefono = telefono;
        this.email = email;
        this.posicion = posicion;
        this.acercade = acercade;
    }
    
}
