package com.camavilca.orlando.presentarhoy.modelo;

import com.orm.dsl.Table;

import java.util.Date;

@Table

public class Nota {

    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private Boolean favorito;
    private Boolean archivar;

    public Nota(String titulo, String descripcion,Date fecha) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Nota(String titulo, String descripcion, Date fecha, Boolean favorito, Boolean archivar) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.favorito = favorito;
        this.archivar = archivar;
    }

    public Nota() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getArchivar() {
        return archivar;
    }

    public void setArchivar(Boolean archivar) {
        this.archivar = archivar;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", favorito=" + favorito +
                ", archivar=" + archivar +
                '}';
    }
}
