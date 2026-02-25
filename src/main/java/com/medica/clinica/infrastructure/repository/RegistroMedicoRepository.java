package com.medica.clinica.infrastructure.repository;

import com.medica.clinica.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.infrastructure.entity.RegistroMedico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Contrato de repositório para persistência de RegistroMedico.
 * TODO: Substituir as implementações padrão por chamadas reais ao banco de dados.
 */
public interface RegistroMedicoRepository {

    default RegistroMedico create(RegistroMedico registro) { return null; }

    default RegistroMedico update(RegistroMedico registro) { return null; }

    default void deleteById(UUID id) {}

    default Optional<RegistroMedico> findById(UUID id) { return Optional.empty(); }

    default List<RegistroMedico> findAll() { return List.of(); }

    default List<RegistroMedico> findByPontuario(PontuarioEletronico pontuario) { return List.of(); }
}
