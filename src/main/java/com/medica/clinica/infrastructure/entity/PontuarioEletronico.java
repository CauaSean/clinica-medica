package com.medica.clinica.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PontuarioEletronico {

    UUID id = UUID.randomUUID();
    Paciente paciente;
    Date dataAbertura;
    List<String> alergias;
    List<RegistroMedico> registros;

    public void adicionarRegistro(RegistroMedico registro) {
        registros.add(registro);
    }
}
