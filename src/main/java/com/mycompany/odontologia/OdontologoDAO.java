package com.mycompany.odontologia;

import jakarta.persistence.*;
import java.util.List;

public class OdontologoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public List<Odontologo> listarTodos() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT o FROM Odontologo o", Odontologo.class).getResultList();
    }
}
