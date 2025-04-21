package com.mycompany.odontologia;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // No crear nueva si no existe
        if (session != null) {
            session.invalidate(); // Cierra sesión
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp"); // Regresa al login
    }
}
