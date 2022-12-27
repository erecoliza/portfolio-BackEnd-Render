
package com.web.portfolio.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fallo el metodo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
*/

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    // Implementamos un logger para ver cual metodo da error en caso de falla
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

  //Metodo implementado de AuthenticationEntryPoint
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fallo el metodo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No esta autorizado");
    }
}


