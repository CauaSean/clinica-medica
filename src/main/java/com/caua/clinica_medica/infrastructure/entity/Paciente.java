package com.caua.clinica_medica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String endereco;

}
