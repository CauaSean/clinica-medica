package com.medica.clinica.business.dto;

import com.medica.clinica.infrastructure.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO extends Funcionario {
    String crm;
    String especialidade;


}
