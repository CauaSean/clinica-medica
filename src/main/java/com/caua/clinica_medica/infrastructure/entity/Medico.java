package com.caua.clinica_medica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    private Long id;
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private String telefone;
    private String email;
}
