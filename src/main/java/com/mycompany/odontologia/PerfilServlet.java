package com.mycompany.odontologia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/editarPerfil")
public class PerfilServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");
        String tipo = req.getParameter("tipo");

        HttpSession session = req.getSession();
        Usuario u = (Usuario) session.getAttribute("usuario");

        if (u != null) {
            u.setCorreo(correo);
            u.setContrasena(contrasena);
            u.setTipo(tipo);

            UsuarioDAO dao = new UsuarioDAO();
            dao.actualizar(u); // este método debe usar merge()

            session.setAttribute("usuario", u); // actualiza la sesión también
            session.setAttribute("msg", "¡Perfil actualizado correctamente!");

            resp.sendRedirect("busuario.jsp"); // ✅ solo esto, sin forward
        } else {
            session.setAttribute("error", "No se pudo actualizar el perfil.");
            resp.sendRedirect("login.jsp");
        }
    }
}
