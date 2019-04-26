/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosalbertoxw.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class UserFilter implements Filter {

    public UserFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("UserFilter:doFilter");

        //Save logs of inputs
        //Data validations
        //Validar sesión de usuarios mediante los objetos HttpServletRequest y HttpServletResponse
        if (true) {
            //Si los datos son validos enviarlos al servlet
            chain.doFilter(request, response);
        } else {
            //Si hay algún error redireccionarlo a una página de error
        }
        //Save logs of outputs
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init");
    }

}
