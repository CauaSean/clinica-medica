package com.medica.clinica.infrastructure.repository;

import com.medica.clinica.infrastructure.entity.Recepcionista;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de Recepcionista.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface RecepcionistaRepository {

    default Recepcionista create(Recepcionista recepcionista) { return null; }

    default Recepcionista update(Recepcionista recepcionista) { return null; }

    default void deleteById(UUID id) {}

    default Optional<Recepcionista> findById(UUID id) { return Optional.empty(); }

    default List<Recepcionista> findAll() { return List.of(); }

    /** Busca pelo identificador natural da recepcionista. */
    default Optional<Recepcionista> findByMatricula(String matricula) { return Optional.empty(); }
}
