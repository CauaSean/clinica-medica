package com.medica.clinica.infrastructure.repository;

import com.medica.clinica.infrastructure.entity.Medico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de Medico.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface MedicoRepository {

    default Medico create(Medico medico) { return null; }

    default Medico update(Medico medico) { return null; }

    default void deleteById(UUID id) {}

    default Optional<Medico> findById(UUID id) { return Optional.empty(); }

    default List<Medico> findAll() { return List.of(); }

    /** Busca pelo identificador natural do médico. */
    default Optional<Medico> findByCrm(String crm) { return Optional.empty(); }
}
