package com.example.paciente.Service;

import com.example.paciente.Model.Paciente;
import com.example.paciente.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }
    public Paciente getPacienteById(int id) {
        return pacienteRepository.findById(id).get();
    }

    public Paciente addPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(int id, Paciente nuevo) {
        Paciente paciente = pacienteRepository.findById(id).get();
        if(pacienteRepository.existsById(id)) {
            paciente.setNombres(nuevo.getNombres());
            paciente.setApellidos(nuevo.getApellidos());
            paciente.setRun(nuevo.getRun());
            paciente.setFechaNacimiento(nuevo.getFechaNacimiento());
            paciente.setCorreo(nuevo.getCorreo());
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public boolean deletePaciente(int id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        pacienteRepository.delete(paciente);
        return pacienteRepository.existsById(id);
    }
}
