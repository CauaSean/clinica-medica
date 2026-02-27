package com.medica.clinica.server.business;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.entity.RegistroMedico;
import com.medica.clinica.server.infrastructure.repository.PontuarioEletronicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações de domínio de PontuarioEletronico.
 * TODO: Conectar uma implementação real de PontuarioEletronicoRepository ao adicionar persistência.
 */
public class PontuarioEletronicoService {

    private final PontuarioEletronicoRepository pontuarioRepository;

    public PontuarioEletronicoService(PontuarioEletronicoRepository pontuarioRepository) {
        this.pontuarioRepository = pontuarioRepository;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────

    public PontuarioEletronico criarPontuario(PontuarioEletronico pontuario) {
        return pontuarioRepository.create(pontuario);
    }

    public PontuarioEletronico atualizarPontuario(PontuarioEletronico pontuario) {
        return pontuarioRepository.update(pontuario);
    }

    public void removerPontuario(UUID id) {
        pontuarioRepository.deleteById(id);
    }

    public Optional<PontuarioEletronico> buscarPontuarioPorId(UUID id) {
        return pontuarioRepository.findById(id);
    }

    public Optional<PontuarioEletronico> buscarPontuarioPorPaciente(Paciente paciente) {
        return pontuarioRepository.findByPaciente(paciente);
    }

    public List<PontuarioEletronico> listarPontuarios() {
        return pontuarioRepository.findAll();
    }

    // ── Operações de domínio ──────────────────────────────────────────────────

    /**
     * Adiciona um registro médico ao prontuário informado e persiste a alteração.
     */
    public PontuarioEletronico adicionarRegistro(PontuarioEletronico pontuario, RegistroMedico registro) {
        pontuario.adicionarRegistro(registro);
        return pontuarioRepository.update(pontuario);
    }
}
