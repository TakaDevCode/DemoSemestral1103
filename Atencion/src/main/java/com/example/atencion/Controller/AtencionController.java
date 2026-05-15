package com.example.atencion.Controller;

import com.example.atencion.Model.Atencion;
import com.example.atencion.Service.AtencionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping("")
    public ResponseEntity<List<Atencion>> listar() {
        List<Atencion> atenciones = atencionService.findAll();
        if (atenciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(atenciones);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscarporID(@PathVariable Integer id) {
        Atencion atencion = atencionService.findById(id);
        if (atencion == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(atencion);
        }
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Atencion>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Atencion> lista = atencionService.findAllByIdPaciente(idPaciente);
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(lista);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Atencion> agregar(@RequestBody @Valid Atencion atencion) {
        return ResponseEntity.ok(atencionService.save(atencion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean res =  atencionService.deleteById(id);
        if (res) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody @Valid Atencion atencion) {
        Atencion updated = atencionService.update(id, atencion);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(updated);
        }
    }

}
