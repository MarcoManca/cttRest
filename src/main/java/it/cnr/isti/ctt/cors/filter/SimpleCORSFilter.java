package it.cnr.isti.ctt.cors.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marco
 */
@Component
public class SimpleCORSFilter implements Filter {
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {}
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletResponse response=(HttpServletResponse) resp;
        HttpServletRequest request=(HttpServletRequest) req;
        System.out.println("*** cors filter ***");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.addHeader("Access-Control-Max-Age", "3600");
        if(request.getMethod().equals("OPTIONS")) {
            response.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        } else {
            response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
        }
        chain.doFilter(req, response);
    }
 
    @Override
    public void destroy() {}
 
}