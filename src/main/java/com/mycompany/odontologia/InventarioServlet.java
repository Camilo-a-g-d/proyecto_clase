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
import java.util.List;



/**
 *
 * @author proye
 */
@WebServlet("/inventario")
public class InventarioServlet extends HttpServlet {
    private final LibroDAO libroDAO = new LibroDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        List<Libro> libros = libroDAO.listarTodos();
        req.setAttribute("libros", libros);
        req.getRequestDispatcher("pages/binventario.jsp").forward(req, resp);
    }
}
