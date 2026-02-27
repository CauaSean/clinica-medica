package com.medica.clinica.server.infrastructure.repository;

import com.medica.clinica.server.infrastructure.entity.Paciente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de Paciente.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface PacienteRepository {

    default Paciente create(Paciente paciente) { return null; }

    default Paciente update(Paciente paciente) { return null; }

    default void deleteById(UUID id) {}

    default Optional<Paciente> findById(UUID id) { return Optional.empty(); }

    default List<Paciente> findAll() { return List.of(); }

    /** Busca pelo identificador natural do paciente. */
    default Optional<Paciente> findByCpf(String cpf) { return Optional.empty(); }
}
