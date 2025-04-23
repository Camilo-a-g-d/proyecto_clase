/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.odontologia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author proye
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("password");

        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.validar(correo, contrasena);

        if (u != null) {
            req.getSession().setAttribute("usuario", u);
            resp.sendRedirect("Dashboard.jsp");
        } else {
            req.setAttribute("error", "Credenciales incorrectas");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        System.out.println("LOGIN - Correo recibido: " + correo);
        System.out.println("LOGIN - Contraseña recibida: " + contrasena);

    }
    
}
