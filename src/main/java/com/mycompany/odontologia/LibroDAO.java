package com.mycompany.odontologia;

import jakarta.persistence.*;
import java.util.List;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public void guardar(Libro libro) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        }
    }

    public void actualizar(Libro libro) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        }
    }

    public Libro buscarPorId(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Libro.class, id);
        }
    }

    public List<Libro> listarTodos() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        }
    }
}
