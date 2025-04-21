package com.mycompany.odontologia;

import jakarta.persistence.*;
import java.util.List;

public class PacienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public List<Paciente> listarTodos() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
    }
}
