package com.medica.clinica.server.business;

import com.medica.clinica.server.infrastructure.entity.Recepcionista;
import com.medica.clinica.server.infrastructure.repository.RecepcionistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações de domínio de Recepcionista.
 * TODO: Conectar uma implementação real de RecepcionistaRepository ao adicionar persistência.
 */
public class RecepcionistaService {

    private final RecepcionistaRepository recepcionistaRepository;

    public RecepcionistaService(RecepcionistaRepository recepcionistaRepository) {
        this.recepcionistaRepository = recepcionistaRepository;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────

    public Recepcionista cadastrarRecepcionista(Recepcionista recepcionista) {
        return recepcionistaRepository.create(recepcionista);
    }

    public Recepcionista atualizarRecepcionista(Recepcionista recepcionista) {
        return recepcionistaRepository.update(recepcionista);
    }

    public void removerRecepcionista(UUID id) {
        recepcionistaRepository.deleteById(id);
    }

    public Optional<Recepcionista> buscarRecepcionistaPorId(UUID id) {
        return recepcionistaRepository.findById(id);
    }

    public Optional<Recepcionista> buscarRecepcionistaPorMatricula(String matricula) {
        return recepcionistaRepository.findByMatricula(matricula);
    }

    public List<Recepcionista> listarRecepcionistas() {
        return recepcionistaRepository.findAll();
    }
}
