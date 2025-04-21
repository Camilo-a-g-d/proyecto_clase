package com.mycompany.odontologia;

import jakarta.persistence.*;
import java.util.List;


public class TurnoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public void guardarTurno(Turno turno) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        }
    }

    public List<Turno> listarTurnos() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT t FROM Turno t", Turno.class).getResultList();
    }
}
