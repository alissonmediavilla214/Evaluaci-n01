package com.evaluacion.api.controller;

import com.evaluacion.api.model.Medicamento;
import com.evaluacion.api.repository.MedicamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoRepository repo;

    public MedicamentoController(MedicamentoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Medicamento> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Medicamento> crear(@RequestBody Medicamento m) {
        m.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(m));
    }

    //Listar los medicamentos que requieren receta.
    @GetMapping("/receta")
    public List<Medicamento> conReceta() {
        return repo.findByRequiereRecetaTrue();
    }
}
