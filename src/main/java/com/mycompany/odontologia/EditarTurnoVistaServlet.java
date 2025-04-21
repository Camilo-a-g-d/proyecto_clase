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
import java.util.List;


/**
 *
 * @author proye
 */
@WebServlet("/editarTurnoVista")
public class EditarTurnoVistaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        try (EntityManager em = emf.createEntityManager()) {
            Turno turno = em.find(Turno.class, id);
            PacienteDAO pacienteDAO = new PacienteDAO();
            OdontologoDAO odontologoDAO = new OdontologoDAO();
            
            List<Paciente> pacientes = pacienteDAO.listarTodos();
            List<Odontologo> odontologos = odontologoDAO.listarTodos();
            
            req.setAttribute("turno", turno);
            req.setAttribute("pacientes", pacientes);
            req.setAttribute("odontologos", odontologos);
            req.getRequestDispatcher("pages/ecitas.jsp").forward(req, resp);
        }
    }
}
