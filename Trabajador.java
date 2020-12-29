package com.example.buscadorfiltradorsqlite;

public class Trabajador {

    String usuario;
    String nombre;
    String area;

    public Trabajador(String usuario, String nombre, String area) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.area = area;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
