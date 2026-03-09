package com.medica.clinica.server.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO extends PessoaDTO {

    UUID id = UUID.randomUUID();
    String numeroCarteirinha;
    String tipoSanguineo;
}
