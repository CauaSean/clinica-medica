package com.medica.clinica.infrastructure.entity;

import java.util.Date;
import java.util.List;

public class ProntuarioEletronico {
    Date dataAbertura;
    List<String> alergias;
    List<RegistroMedico> registros;
}
