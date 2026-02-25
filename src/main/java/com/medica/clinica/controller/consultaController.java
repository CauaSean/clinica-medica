package com.medica.clinica.controller;

import com.medica.clinica.business.dto.MedicoDTO;
import com.medica.clinica.business.MedicoService;
import com.medica.clinica.infrastructure.entity.Consulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class consultaController {
    private final MedicoService medicoService;

    public consultaController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/agendar")
    public ResponseEntity<Consulta> agendarConsulta(@RequestBody MedicoDTO medicoDTO){
        Consulta consulta = medicoService.agendarConsulta(
                medicoDTO.getPaciente(),
                medicoDTO.getMedico(),
                medicoDTO.getValor()
        );
        return ResponseEntity.ok(consulta);
    }
}
