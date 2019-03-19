/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosalbertoxw.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
public class User extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando servlet");
        String page = request.getParameter("page") != null ? request.getParameter("page") : "";
        Boolean session = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("data") && cookie.getValue().equals("true")) {
                    session = true;
                }
            }
        }

        if (page.equals("dashboard")) {
            if (!session) {
                response.sendRedirect("/JavaServletFilter/");
            } else {
                RequestDispatcher view = request.getRequestDispatcher("dashboard.jsp");
                view.forward(request, response);
            }
        } else if (page.equals("")) {
            if (session) {
                response.sendRedirect("/JavaServletFilter/?page=dashboard");
            } else {
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            }
        } else if (page.equals("logout")) {
            if (session) {
                Cookie cookie = new Cookie("data", "true");
                cookie.setMaxAge(0);
                cookie.setDomain("localhost");
                cookie.setHttpOnly(true);
                cookie.setPath("/JavaServletFilter");
                response.addCookie(cookie);
                response.sendRedirect("/JavaServletFilter/");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        if (user.equals("admin") && password.equals("123456")) {
            Cookie cookie = new Cookie("data", "true");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            cookie.setDomain("localhost");
            cookie.setHttpOnly(true);
            cookie.setPath("/JavaServletFilter");
            response.addCookie(cookie);
            response.sendRedirect("/JavaServletFilter/?page=dashboard");
        } else {
            request.getSession().setAttribute("message", "Usuario o contraseña incorrectos");
            response.sendRedirect("/JavaServletFilter/");
        }
    }
}
