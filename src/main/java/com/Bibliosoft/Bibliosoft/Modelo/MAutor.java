package com.Bibliosoft.Bibliosoft.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="autor")
public class MAutor {
    @Id
    @Column(name = "ideautor", nullable = false)
    private Integer ideautor;
    @Column(length = 100, nullable = false)
    private String nombreautor;
    @Column(length = 60, nullable = false)
    private String apellidoautor;
    @Column (length = 80, nullable = false)
    private String nacionalidadautor;
    @Column(length = 5, nullable = false)
    private String activo;

    // Constructores


    public MAutor(Integer ideautor, String nombreautor, String apellidoautor, String nacionalidadautor, String activo) {
        this.ideautor = ideautor;
        this.nombreautor = nombreautor;
        this.apellidoautor = apellidoautor;
        this.nacionalidadautor = nacionalidadautor;
        this.activo = activo;
    }

    public MAutor() {
    }

    // Metodos Get y Set (Encapsulamiento)

    public Integer getIdeautor() {
        return ideautor;
    }

    public void setIdeautor(Integer ideautor) {
        this.ideautor = ideautor;
    }

    public String getNombreautor() {
        return nombreautor;
    }

    public void setNombreautor(String nombreautor) {
        this.nombreautor = nombreautor;
    }

    public String getApellidoautor() {
        return apellidoautor;
    }

    public void setApellidoautor(String apellidoautor) {
        this.apellidoautor = apellidoautor;
    }

    public String getNacionalidadautor() {
        return nacionalidadautor;
    }

    public void setNacionalidadautor(String nacionalidadautor) {
        this.nacionalidadautor = nacionalidadautor;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
