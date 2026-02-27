package com.medica.clinica.ui.controller;

import com.medica.clinica.server.business.*;
import com.medica.clinica.ui.repository.*;

/**
 * Registro de serviços da aplicação.
 * Instancia os repositórios in-memory e os serviços do servidor, funcionando
 * como ponto único de acesso para as telas da UI.
 */
public class ServiceRegistry {

    private static ServiceRegistry instance;

    private final MedicoService medicoService;
    private final PacienteService pacienteService;
    private final RecepcionistaService recepcionistaService;
    private final ConsultaService consultaService;
    private final PontuarioEletronicoService pontuarioService;
    private final RegistroMedicoService registroService;

    private ServiceRegistry() {
        InMemoryMedicoRepository         medicoRepo        = new InMemoryMedicoRepository();
        InMemoryPacienteRepository       pacienteRepo      = new InMemoryPacienteRepository();
        InMemoryRecepcionistaRepository  recepcionistaRepo = new InMemoryRecepcionistaRepository();
        InMemoryConsultaRepository       consultaRepo      = new InMemoryConsultaRepository();
        InMemoryPontuarioEletronicoRepository pontuarioRepo = new InMemoryPontuarioEletronicoRepository();
        InMemoryRegistroMedicoRepository registroRepo      = new InMemoryRegistroMedicoRepository();

        medicoService        = new MedicoService(medicoRepo, consultaRepo);
        pacienteService      = new PacienteService(pacienteRepo);
        recepcionistaService = new RecepcionistaService(recepcionistaRepo);
        consultaService      = new ConsultaService(consultaRepo);
        pontuarioService     = new PontuarioEletronicoService(pontuarioRepo);
        registroService      = new RegistroMedicoService(registroRepo);
    }

    public static ServiceRegistry getInstance() {
        if (instance == null) {
            instance = new ServiceRegistry();
        }
        return instance;
    }

    public MedicoService getMedicoService()               { return medicoService; }
    public PacienteService getPacienteService()           { return pacienteService; }
    public RecepcionistaService getRecepcionistaService() { return recepcionistaService; }
    public ConsultaService getConsultaService()           { return consultaService; }
    public PontuarioEletronicoService getPontuarioService() { return pontuarioService; }
    public RegistroMedicoService getRegistroService()     { return registroService; }
}
