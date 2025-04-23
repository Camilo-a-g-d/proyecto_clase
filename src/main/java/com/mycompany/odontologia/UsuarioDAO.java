package com.mycompany.odontologia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class UsuarioDAO {
    private final EntityManagerFactory emf;

    public UsuarioDAO() {
    this.emf = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public Usuario validar(String correo, String contrasena) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Usuario> query;
            query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :contrasena", Usuario.class);
            query.setParameter("correo", correo);
            query.setParameter("contrasena", contrasena);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

public void actualizar(Usuario usuario) {
    EntityManager em = emf.createEntityManager();
    try {
        em.getTransaction().begin();
        em.merge(usuario); // actualiza el registro existente
        em.getTransaction().commit();
    } finally {
        em.close();
    }
}

}
