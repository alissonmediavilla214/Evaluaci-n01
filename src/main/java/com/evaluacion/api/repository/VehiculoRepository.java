package com.evaluacion.api.repository;

import com.evaluacion.api.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByMarcaIgnoreCase(String marca);
}
