package com.example.atencion.Repository;

import com.example.atencion.Model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findByIdPaciente(Integer idPaciente);
}
