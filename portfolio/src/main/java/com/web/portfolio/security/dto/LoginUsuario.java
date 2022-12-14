/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.web.portfolio.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
}
