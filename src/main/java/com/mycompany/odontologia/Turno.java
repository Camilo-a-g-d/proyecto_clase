package com.mycompany.odontologia;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author proye
 */
@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    // Getters y Setters

    public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
}

public void setHora(LocalTime hora) {
    this.hora = hora;
}

public void setOdontologo(Odontologo odontologo) {
    this.odontologo = odontologo;
}

public void setEstado(String estado) {
    this.estado = estado;
}

public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
}

// También incluye los getters si aún no los tienes:
public LocalDate getFecha() {
    return fecha;
}

public LocalTime getHora() {
    return hora;
}

public Paciente getPaciente() {
    return paciente;
}

public Odontologo getOdontologo() {
    return odontologo;
}

public String getEstado() {
    return estado;
}
}