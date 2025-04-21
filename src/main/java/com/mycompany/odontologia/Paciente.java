package com.mycompany.odontologia;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String documento;
    private String telefono;

    // Getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTelefono() { return telefono; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDocumento(String documento) { this.documento = documento; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
