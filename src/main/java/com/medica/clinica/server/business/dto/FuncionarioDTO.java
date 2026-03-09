package com.medica.clinica.server.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class FuncionarioDTO extends PessoaDTO {

    String matricula;
    Double salarioBase;

    public abstract double calcularSalario();
}
