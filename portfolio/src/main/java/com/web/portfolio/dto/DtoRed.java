
package com.web.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoRed {

    private String red;
    private String link;
    
    public DtoRed() {
    }

    public DtoRed(String red, String link) {
        this.red = red;
        this.link = link;
    }
            
}
