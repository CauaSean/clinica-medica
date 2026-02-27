package com.medica.clinica.server.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {

    UUID id = UUID.randomUUID();
    String numeroCarteirinha;
    String tipoSanguineo;
}
