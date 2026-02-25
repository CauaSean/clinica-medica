package com.medica.clinica.infrastructure.repository;

import com.medica.clinica.infrastructure.entity.Paciente;
import com.medica.clinica.infrastructure.entity.PontuarioEletronico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de PontuarioEletronico.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface PontuarioEletronicoRepository {

    default PontuarioEletronico create(PontuarioEletronico pontuario) { return null; }

    default PontuarioEletronico update(PontuarioEletronico pontuario) { return null; }

    default void deleteById(UUID id) {}

    default Optional<PontuarioEletronico> findById(UUID id) { return Optional.empty(); }

    default List<PontuarioEletronico> findAll() { return List.of(); }

    default Optional<PontuarioEletronico> findByPaciente(Paciente paciente) { return Optional.empty(); }
}
