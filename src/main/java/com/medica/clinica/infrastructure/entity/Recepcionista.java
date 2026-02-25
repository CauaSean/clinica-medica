package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recepcionista extends Funcionario {

    UUID id = UUID.randomUUID();
    TurnoTrabalho turnoTrabalho;

    @Override
    public double calcularSalario() {
        Double salarioBase = super.salarioBase;
        Double bonus;

        switch (turnoTrabalho) {
            case NOITE:
                bonus = 650.0;
                break;
            default:
                bonus = 0.0;
        }

        return salarioBase + bonus;
    }
}
