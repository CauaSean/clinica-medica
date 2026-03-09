package com.medica.clinica.server.business.dto;

import com.medica.clinica.server.business.enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO extends FuncionarioDTO {

    String crm;
    Especialidade especialidade;

    @Override
    public double calcularSalario() {
        Double salarioBase = super.salarioBase;
        Double bonus;

        switch (especialidade) {
            case NEUROCIRURGIA:
                bonus = 15000.0;
                break;
            case CARDIOLOGIA:
                bonus = 10000.0;
                break;
            case GINECOLOGIA:
                bonus = 8000.0;
                break;
            case PEDIATRIA:
                bonus = 6000.0;
                break;
            case ORTOPEDIA:
                bonus = 4000.0;
                break;
            default:
                bonus = 0.0;
        }

        return salarioBase + bonus;
    }
}
