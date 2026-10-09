package com.miempresa.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase POJO (Plain Old Java Object) para representar la entidad Persona.
 * Implementa Serializable para permitir su transporte entre capas en entornos web.
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;

    // 1. Constructor vacío (obligatorio para un JavaBeans / POJO)
    public Persona() {
    }

    // 2. Constructor con todos los parámetros
    public Persona(Long id, String nombre, String apellidos, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    // 3. Constructor conveniente sin ID (ideal para creación previa a guardar en BBDD)
    public Persona(String nombre, String apellidos, String email, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.edad = edad;
    }

    // --- GETTERS Y SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // --- MÉTODOS SOBREESCRITOS ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }
}