package com.mycompany.odontologia;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author proye
 */
@Entity

@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    private String correo;
    private String contrasena;
    private String tipo;

    // Getters y setters
    public int getId() { return id; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public String getTipo() { return tipo; }

    public void setCorreo(String correo) { this.correo = correo; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
