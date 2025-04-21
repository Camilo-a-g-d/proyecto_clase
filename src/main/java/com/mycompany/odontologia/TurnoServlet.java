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

@WebServlet("/crearTurno")
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

        resp.sendRedirect("pages/Dashboard.jsp"); // o donde quieras redirigir
    }
}
