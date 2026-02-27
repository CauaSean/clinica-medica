package com.medica.clinica.server.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa {
    String nome;
    String cpf;
    Date dataNascimento;
    String telefone;
}
