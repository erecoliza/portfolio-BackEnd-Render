
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
public class Red {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long persona_id;
    private String red;
    private String link;
    private LocalTime fechayhora;       

    public Red() {
    }

    public Red(Long persona_id, String red, String link, LocalTime fechayhora) {
        this.persona_id = persona_id;
        this.red = red;
        this.link = link;
        this.fechayhora = fechayhora;
    }

    
        
    
}
