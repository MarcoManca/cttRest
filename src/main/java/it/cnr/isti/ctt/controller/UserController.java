/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.isti.ctt.controller;

import it.cnr.isti.ctt.model.User;
import it.cnr.isti.ctt.model.response.LoginDetail;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author munky
 */
@Controller
public class UserController {

    //@Autowired
    //private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/llogin", method = RequestMethod.POST, consumes= "application/json", produces = "application/json")
    public @ResponseBody
    LoginDetail login(/*@PathVariable String userName, @PathVariable String password*/@RequestBody User usr, HttpServletRequest request) {
//        System.out.println("Auth "+usr.getUserName()+" psw: "+usr.getPassword());
//        Authentication authenticationToken =
//                new UsernamePasswordAuthenticationToken(usr.getUserName(), usr.getPassword());
//        try {
//            Authentication authentication = authenticationManager.authenticate(authenticationToken);
//            SecurityContext securityContext = SecurityContextHolder.getContext();
//            securityContext.setAuthentication(authentication);
//
//            if (authentication.isAuthenticated()) {
//                HttpSession session = request.getSession(true);
//                session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//                System.out.println("Auth ok");
//                return new LoginDetail().success().principal(authentication.getName());
//            } else {
//                SecurityContextHolder.getContext().setAuthentication(null);
//                return new LoginDetail().failed();
//            }
//        } catch (AuthenticationException ex) {
//            return new LoginDetail().failed();
//        }
        return new LoginDetail().success().principal("munky");
    }
}
