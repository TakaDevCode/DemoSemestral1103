package com.example.paciente.Controller;

import com.example.paciente.Model.Paciente;
import com.example.paciente.Service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("")
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        if (pacientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable int id) {
        Paciente paciente = pacienteService.getPacienteById(id);
        if (paciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Paciente> save(@RequestBody @Valid Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.addPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = pacienteService.deletePaciente(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable int id, @RequestBody @Valid Paciente paciente) {
        Paciente updatedPaciente = pacienteService.updatePaciente(id, paciente);
        if (updatedPaciente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedPaciente, HttpStatus.OK);
        }
    }
}
