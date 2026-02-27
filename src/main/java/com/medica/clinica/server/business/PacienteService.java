package com.medica.clinica.server.business;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações de domínio de Paciente.
 * TODO: Conectar uma implementação real de PacienteRepository ao adicionar persistência.
 */
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────

    public Paciente cadastrarPaciente(Paciente paciente) {
        return pacienteRepository.create(paciente);
    }

    public Paciente atualizarPaciente(Paciente paciente) {
        return pacienteRepository.update(paciente);
    }

    public void removerPaciente(UUID id) {
        pacienteRepository.deleteById(id);
    }

    public Optional<Paciente> buscarPacientePorId(UUID id) {
        return pacienteRepository.findById(id);
    }

    public Optional<Paciente> buscarPacientePorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
}
