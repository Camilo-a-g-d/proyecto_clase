package com.mycompany.odontologia;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "odontologos")
public class Odontologo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String especialidad;
    private String registroProfesional;

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getRegistroProfesional() { return registroProfesional; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public void setRegistroProfesional(String registroProfesional) { this.registroProfesional = registroProfesional; }
}
