package com.medica.clinica.server.infrastructure.repository;

import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.entity.RegistroMedico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface RegistroMedicoRepository {

    default RegistroMedico create(RegistroMedico registro) { return null; }

    default RegistroMedico update(RegistroMedico registro) { return null; }

    default void deleteById(UUID id) {}

    default Optional<RegistroMedico> findById(UUID id) { return Optional.empty(); }

    default List<RegistroMedico> findAll() { return List.of(); }

    default List<RegistroMedico> findByPontuario(PontuarioEletronico pontuario) { return List.of(); }
}
