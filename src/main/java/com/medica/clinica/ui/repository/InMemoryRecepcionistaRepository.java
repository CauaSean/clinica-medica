package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.Recepcionista;
import com.medica.clinica.server.infrastructure.repository.RecepcionistaRepository;

import java.util.*;

public class InMemoryRecepcionistaRepository implements RecepcionistaRepository {

    private final Map<UUID, Recepcionista> store = new LinkedHashMap<>();

    @Override
    public Recepcionista create(Recepcionista recepcionista) {
        store.put(recepcionista.getId(), recepcionista);
        return recepcionista;
    }

    @Override
    public Recepcionista update(Recepcionista recepcionista) {
        store.put(recepcionista.getId(), recepcionista);
        return recepcionista;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<Recepcionista> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Recepcionista> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Recepcionista> findByMatricula(String matricula) {
        return store.values().stream()
                .filter(r -> matricula.equals(r.getMatricula()))
                .findFirst();
    }
}
