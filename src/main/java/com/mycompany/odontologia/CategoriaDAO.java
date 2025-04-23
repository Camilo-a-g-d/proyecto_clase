package com.mycompany.odontologia;

import jakarta.persistence.*;
import java.util.List;

public class CategoriaDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public List<Categoria> listarTodas() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        }
    }

    public Categoria buscarPorId(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Categoria.class, id);
        }
    }
}
