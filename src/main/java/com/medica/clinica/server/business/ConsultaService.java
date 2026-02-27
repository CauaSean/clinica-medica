package com.medica.clinica.server.business;

import com.medica.clinica.server.infrastructure.entity.Consulta;
import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.repository.ConsultaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }


    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.create(consulta);
    }

    public Consulta atualizarConsulta(Consulta consulta) {
        return consultaRepository.update(consulta);
    }

    public void removerConsulta(UUID id) {
        consultaRepository.deleteById(id);
    }

    public Optional<Consulta> buscarConsultaPorId(UUID id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public List<Consulta> listarConsultasPorPaciente(Paciente paciente) {
        return consultaRepository.findByPaciente(paciente);
    }

    public List<Consulta> listarConsultasPorMedico(Medico medico) {
        return consultaRepository.findByMedico(medico);
    }
}
