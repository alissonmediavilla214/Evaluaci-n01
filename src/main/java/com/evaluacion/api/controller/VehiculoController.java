package com.evaluacion.api.controller;

import com.evaluacion.api.model.Vehiculo;
import com.evaluacion.api.repository.VehiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository repo;

    public VehiculoController(VehiculoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Vehiculo> crear(@RequestBody Vehiculo v) {
        v.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(v));
    }

    // Listar los vehículos de una marca.
    @GetMapping("/marca")
    public List<Vehiculo> porMarca(@RequestParam String nombre) {
        return repo.findByMarcaIgnoreCase(nombre);
    }
}
