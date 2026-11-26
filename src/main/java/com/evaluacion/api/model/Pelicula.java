package com.evaluacion.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String director;
    private String genero;
    private Integer duracionMinutos;
    private Integer anioEstreno;
}
