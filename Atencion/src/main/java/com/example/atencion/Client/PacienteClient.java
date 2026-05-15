
package com.example.atencion.Client;

import com.example.atencion.Dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Nombre exacto al cual hace referencia el Client
@FeignClient(name="Paciente")
public interface PacienteClient {

    @GetMapping("/api/v1/pacientes/{id}")
    PacienteDTO buscarPorId(@PathVariable Integer id);
}
