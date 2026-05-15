package com.example.atencion.Service;

import com.example.atencion.Client.PacienteClient;
import com.example.atencion.Dto.PacienteDTO;
import com.example.atencion.Model.Atencion;
import com.example.atencion.Repository.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;
    @Autowired
    private  PacienteClient pacienteClient;

    public List<Atencion> findAll() {
        return atencionRepository.findAll();
    }

    public Atencion findById(int id) {
        return atencionRepository.findById(id).get();
    }

    public List<Atencion> findAllByIdPaciente(Integer idPaciente) {
        pacienteClient.buscarPorId(idPaciente);
        return atencionRepository.findByIdPaciente(idPaciente);
    }

    public Atencion save(Atencion atencion) {
        PacienteDTO paciente = pacienteClient.buscarPorId(atencion.getIdPaciente());
        System.out.println("Registrando atencion para cliente"+paciente.getNombres());
        return atencionRepository.save(atencion);
    }

    public Atencion update(Integer id , Atencion nueva) {
        Atencion buscada = findById(id);
        if(atencionRepository.existsById(id)) {
            buscada.setFechaAtencion(nueva.getFechaAtencion());
            buscada.setHoraAtencion(nueva.getHoraAtencion());
            buscada.setCosto(nueva.getCosto());
            buscada.setIdPaciente(nueva.getIdPaciente());
            buscada.setComentario(nueva.getComentario());
            return atencionRepository.save(buscada);
        } else {
            return null;
        }
    }
    public boolean deleteById(int id) {
        Atencion buscada =  findById(id);
        if(atencionRepository.existsById(id)) {
            atencionRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
