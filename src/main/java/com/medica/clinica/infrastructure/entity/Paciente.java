package com.medica.clinica.infrastructure.entity;

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

    UUID id;
    String numeroCarteirinha;
    String tipoSanguineo;
}
