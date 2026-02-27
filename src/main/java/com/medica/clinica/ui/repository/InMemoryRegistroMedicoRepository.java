package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.entity.RegistroMedico;
import com.medica.clinica.server.infrastructure.repository.RegistroMedicoRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryRegistroMedicoRepository implements RegistroMedicoRepository {

    private final Map<UUID, RegistroMedico> store = new LinkedHashMap<>();

    @Override
    public RegistroMedico create(RegistroMedico registro) {
        store.put(registro.getId(), registro);
        return registro;
    }

    @Override
    public RegistroMedico update(RegistroMedico registro) {
        store.put(registro.getId(), registro);
        return registro;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<RegistroMedico> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<RegistroMedico> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<RegistroMedico> findByPontuario(PontuarioEletronico pontuario) {
        return store.values().stream()
                .filter(r -> pontuario.getId().equals(r.getPontuarioEletronico().getId()))
                .collect(Collectors.toList());
    }
}
