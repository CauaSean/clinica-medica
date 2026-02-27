package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.repository.PacienteRepository;

import java.util.*;

public class InMemoryPacienteRepository implements PacienteRepository {

    private final Map<UUID, Paciente> store = new LinkedHashMap<>();

    @Override
    public Paciente create(Paciente paciente) {
        store.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public Paciente update(Paciente paciente) {
        store.put(paciente.getId(), paciente);
        return paciente;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<Paciente> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Paciente> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Paciente> findByCpf(String cpf) {
        return store.values().stream()
                .filter(p -> cpf.equals(p.getCpf()))
                .findFirst();
    }
}
