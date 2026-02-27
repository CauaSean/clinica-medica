package com.medica.clinica.server.infrastructure.repository;

import com.medica.clinica.server.infrastructure.entity.Consulta;
import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.entity.Paciente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de Consulta.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface ConsultaRepository {

    default Consulta create(Consulta consulta) { return null; }

    default Consulta update(Consulta consulta) { return null; }

    default void deleteById(UUID id) {}

    default Optional<Consulta> findById(UUID id) { return Optional.empty(); }

    default List<Consulta> findAll() { return List.of(); }

    default List<Consulta> findByPaciente(Paciente paciente) { return List.of(); }

    default List<Consulta> findByMedico(Medico medico) { return List.of(); }
}
