package com.evaluacion.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String laboratorio;
    private Double precio;
    private Integer stock;
    private Boolean requiereReceta;
}
