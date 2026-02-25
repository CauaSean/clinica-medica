package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    LocalDate dataHora;
    String statusConsulta;
    Double valor;
    Medico medico;
    Paciente paciente;
}
