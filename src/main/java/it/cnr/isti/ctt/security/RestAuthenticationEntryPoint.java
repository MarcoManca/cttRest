/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.security;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marco
 *
 * In a standard web application, the authentication process may be
 * automatically triggered when the client tries to access a secured resource
 * without being authenticated this is usually done by redirecting to a login
 * page so that the user can enter credentials. However, for a REST Web Service
 * this behavior does not make much sense. Authentication should only be done by
 * a request to the correct URI and all other requests should simply fail with a
 * 401 UNAUTHORIZED status code if the user is not authenticated.
 */
@Component( "restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) {
        //System.out.println("restAuthenticationEntryPoint");
        System.out.println("req url " + request.getRequestURL());
        try {
            /* CORS support also for 401 Unauthorized response */
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.addHeader("Access-Control-Max-Age", "3600");
            response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
            /* END CORS support */
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        } catch (IOException ex) {
            Logger.getLogger(RestAuthenticationEntryPoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
