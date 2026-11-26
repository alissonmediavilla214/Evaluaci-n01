package com.evaluacion.api.controller;

import com.evaluacion.api.model.Pelicula;
import com.evaluacion.api.repository.PeliculaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaRepository repo;

    public PeliculaController(PeliculaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula p) {
        p.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula p) {
        return repo.findById(id).map(existente -> {
            existente.setTitulo(p.getTitulo());
            existente.setDirector(p.getDirector());
            existente.setGenero(p.getGenero());
            existente.setDuracionMinutos(p.getDuracionMinutos());
            existente.setAnioEstreno(p.getAnioEstreno());
            return ResponseEntity.ok(repo.save(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Listar las películas estrenadas entre dos años
    @GetMapping("/estrenos")
    public List<Pelicula> estrenos(@RequestParam Integer desde, @RequestParam Integer hasta) {
        return repo.findByAnioEstrenoBetween(desde, hasta);
    }
}
