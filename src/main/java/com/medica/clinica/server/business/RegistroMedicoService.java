package com.medica.clinica.server.business;

import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.entity.RegistroMedico;
import com.medica.clinica.server.infrastructure.repository.RegistroMedicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações de domínio de RegistroMedico.
 * TODO: Conectar uma implementação real de RegistroMedicoRepository ao adicionar persistência.
 */
public class RegistroMedicoService {

    private final RegistroMedicoRepository registroRepository;

    public RegistroMedicoService(RegistroMedicoRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────

    public RegistroMedico criarRegistro(RegistroMedico registro) {
        return registroRepository.create(registro);
    }

    public RegistroMedico atualizarRegistro(RegistroMedico registro) {
        return registroRepository.update(registro);
    }

    public void removerRegistro(UUID id) {
        registroRepository.deleteById(id);
    }

    public Optional<RegistroMedico> buscarRegistroPorId(UUID id) {
        return registroRepository.findById(id);
    }

    public List<RegistroMedico> listarRegistros() {
        return registroRepository.findAll();
    }

    public List<RegistroMedico> listarRegistrosPorPontuario(PontuarioEletronico pontuario) {
        return registroRepository.findByPontuario(pontuario);
    }
}
