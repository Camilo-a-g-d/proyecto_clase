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
import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        LocalDate fecha = LocalDate.parse(req.getParameter("fecha"));
        LocalTime hora = LocalTime.parse(req.getParameter("hora"));
        int pacienteId = Integer.parseInt(req.getParameter("paciente"));
        int odontologoId = Integer.parseInt(req.getParameter("odontologo"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        EntityManager em = emf.createEntityManager();

        Paciente paciente = em.find(Paciente.class, pacienteId);
        Odontologo odontologo = em.find(Odontologo.class, odontologoId);

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setHora(hora);
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setEstado("PROGRAMADO");

        TurnoDAO dao = new TurnoDAO();
        dao.guardarTurno(turno);

        resp.sendRedirect("ccitas.jsp"); 
    }


@WebServlet("/editarTurno")
public class TurnoeServlet extends HttpServlet {

        /**
         *
         * @param req
         * @param resp
         * @throws ServletException
         * @throws IOException
         */
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        LocalDate fecha = LocalDate.parse(req.getParameter("fecha"));
        LocalTime hora = LocalTime.parse(req.getParameter("hora"));
        int pacienteId = Integer.parseInt(req.getParameter("paciente"));
        int odontologoId = Integer.parseInt(req.getParameter("odontologo"));
        String estado = req.getParameter("estado");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
            try (EntityManager em = emf.createEntityManager()) {
                Turno turno = em.find(Turno.class, id);
                Paciente paciente = em.find(Paciente.class, pacienteId);
                Odontologo odontologo = em.find(Odontologo.class, odontologoId);
                
                em.getTransaction().begin();
                turno.setFecha(fecha);
                turno.setHora(hora);
                turno.setPaciente(paciente);
                turno.setOdontologo(odontologo);
                turno.setEstado(estado);
                em.getTransaction().commit();
            }

        resp.sendRedirect("bcitas.jsp");
        
    }
}
}
