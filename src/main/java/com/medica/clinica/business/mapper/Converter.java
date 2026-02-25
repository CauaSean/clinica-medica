package com.medica.clinica.business.mapper;

import com.medica.clinica.business.dto.MedicoDTO;
import com.medica.clinica.infrastructure.entity.Medico;

public class Converter {
    Medico paraMedicoEntity(MedicoDTO dto);
}
