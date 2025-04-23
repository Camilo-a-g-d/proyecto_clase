/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.odontologia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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
@WebServlet("/editarPerfil")
public class PerfilServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, id);
            u.setCorreo(correo);
            u.setContrasena(contrasena);
            em.getTransaction().commit();

            req.getSession().setAttribute("usuario", u);
            resp.sendRedirect("perfil.jsp");
        }
    }
}

