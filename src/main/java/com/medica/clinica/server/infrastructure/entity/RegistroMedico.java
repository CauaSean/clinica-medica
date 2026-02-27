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
public class RegistroMedico {

    UUID id = UUID.randomUUID();
    PontuarioEletronico pontuarioEletronico;
    String sintomas;
    String diagnostico;
    String prescricao;
}
