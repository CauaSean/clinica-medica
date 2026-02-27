package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.repository.PontuarioEletronicoRepository;

import java.util.*;

public class InMemoryPontuarioEletronicoRepository implements PontuarioEletronicoRepository {

    private final Map<UUID, PontuarioEletronico> store = new LinkedHashMap<>();

    @Override
    public PontuarioEletronico create(PontuarioEletronico pontuario) {
        store.put(pontuario.getId(), pontuario);
        return pontuario;
    }

    @Override
    public PontuarioEletronico update(PontuarioEletronico pontuario) {
        store.put(pontuario.getId(), pontuario);
        return pontuario;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<PontuarioEletronico> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<PontuarioEletronico> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<PontuarioEletronico> findByPaciente(Paciente paciente) {
        return store.values().stream()
                .filter(p -> paciente.getId().equals(p.getPaciente().getId()))
                .findFirst();
    }
}
