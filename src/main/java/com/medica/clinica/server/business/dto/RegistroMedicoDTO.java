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
public class RegistroMedicoDTO {

    PontuarioEletronicoDTO pontuarioEletronicoDTO;
    String sintomas;
    String diagnostico;
    String prescricao;
}
