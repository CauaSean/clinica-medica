package com.medica.clinica.server.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {

    UUID id = UUID.randomUUID();
    LocalDate dataHora;
    String statusConsulta;
    Double valor;
    MedicoDTO medico;
    PacienteDTO pacienteDTO;
}
