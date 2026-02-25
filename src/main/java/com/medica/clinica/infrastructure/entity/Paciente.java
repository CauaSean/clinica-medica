package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {
    String numeroCarteirinha;
    String tipoSanguineo;
}
