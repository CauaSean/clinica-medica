package com.medica.clinica.server.business.dto;

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
public class PontuarioEletronicoDTO {

    UUID id = UUID.randomUUID();
    PacienteDTO pacienteDTO;
    Date dataAbertura;
    List<String> alergias;
    List<RegistroMedicoDTO> registros;

    public void adicionarRegistro(RegistroMedicoDTO registro) {
        registros.add(registro);
    }
}
