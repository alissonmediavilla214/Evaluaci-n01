package com.evaluacion.api.repository;

import com.evaluacion.api.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findByRequiereRecetaTrue();
}
