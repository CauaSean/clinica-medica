package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Funcionario {
    String matricula;
    double salarioBase;

    public abstract double calcularSalario(double salario);

    public abstract double calcularSalario();
}
