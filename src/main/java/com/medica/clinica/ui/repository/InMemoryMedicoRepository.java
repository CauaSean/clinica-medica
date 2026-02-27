package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.repository.MedicoRepository;

import java.util.*;

public class InMemoryMedicoRepository implements MedicoRepository {

    private final Map<UUID, Medico> store = new LinkedHashMap<>();

    @Override
    public Medico create(Medico medico) {
        store.put(medico.getId(), medico);
        return medico;
    }

    @Override
    public Medico update(Medico medico) {
        store.put(medico.getId(), medico);
        return medico;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<Medico> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Medico> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Medico> findByCrm(String crm) {
        return store.values().stream()
                .filter(m -> crm.equals(m.getCrm()))
                .findFirst();
    }
}
