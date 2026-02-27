package com.medica.clinica.ui.repository;

import com.medica.clinica.server.infrastructure.entity.Consulta;
import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.repository.ConsultaRepository;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryConsultaRepository implements ConsultaRepository {

    private final Map<UUID, Consulta> store = new LinkedHashMap<>();

    @Override
    public Consulta create(Consulta consulta) {
        store.put(consulta.getId(), consulta);
        return consulta;
    }

    @Override
    public Consulta update(Consulta consulta) {
        store.put(consulta.getId(), consulta);
        return consulta;
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public Optional<Consulta> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Consulta> findByPaciente(Paciente paciente) {
        return store.values().stream()
                .filter(c -> paciente.getId().equals(c.getPaciente().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Consulta> findByMedico(Medico medico) {
        return store.values().stream()
                .filter(c -> medico.getId().equals(c.getMedico().getId()))
                .collect(Collectors.toList());
    }
}
