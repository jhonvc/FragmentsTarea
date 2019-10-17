package com.example.tiendafragments.Entidades;

public class Categoria {
    int id;
    String descripcion;
    String imagen_banner;
    String imagen_cuadrada;

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen_banner() {
        return imagen_banner;
    }

    public void setImagen_banner(String imagen_banner) {
        this.imagen_banner = imagen_banner;
    }

    public String getImagen_cuadrada() {
        return imagen_cuadrada;
    }

    public void setImagen_cuadrada(String imagen_cuadrada) {
        this.imagen_cuadrada = imagen_cuadrada;
    }
}
