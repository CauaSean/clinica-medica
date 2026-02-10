package com.caua.clinica_medica.infrastructure.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {

    private Long id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate data;
    private LocalDateTime hora;
    private String observacoes;
}
