package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Funcionario extends Pessoa {

    String matricula;
    Double salarioBase;

    public abstract double calcularSalario();
}
