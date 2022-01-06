package com.ejemplo1.model;

import java.util.Objects;

public class Persona {
    private Integer idPersona;
    private String nombre;
    private Integer edad;

    public Persona(Integer idPersona, String nombre, Integer edad) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(idPersona, persona.idPersona) && Objects.equals(nombre, persona.nombre) && Objects.equals(edad, persona.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nombre, edad);
    }
}
