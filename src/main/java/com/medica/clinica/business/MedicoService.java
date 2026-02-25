package com.medica.clinica.business;

import com.medica.clinica.infrastructure.entity.Consulta;
import com.medica.clinica.infrastructure.entity.Medico;
import com.medica.clinica.infrastructure.entity.Paciente;
import com.medica.clinica.infrastructure.repository.ConsultaRepository;
import com.medica.clinica.infrastructure.repository.MedicoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações de domínio de Medico.
 * TODO: Conectar uma implementação real de MedicoRepository/ConsultaRepository ao adicionar persistência.
 */
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final ConsultaRepository consultaRepository;

    public MedicoService(MedicoRepository medicoRepository, ConsultaRepository consultaRepository) {
        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
    }

    // ── CRUD ─────────────────────────────────────────────────────────────────

    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.create(medico);
    }

    public Medico atualizarMedico(Medico medico) {
        return medicoRepository.update(medico);
    }

    public void removerMedico(UUID id) {
        medicoRepository.deleteById(id);
    }

    public Optional<Medico> buscarMedicoPorId(UUID id) {
        return medicoRepository.findById(id);
    }

    public Optional<Medico> buscarMedicoPorCrm(String crm) {
        return medicoRepository.findByCrm(crm);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    // ── Operações de domínio ──────────────────────────────────────────────────

    /**
     * Agenda uma nova Consulta e persiste no repositório.
     */
    public Consulta agendarConsulta(Paciente paciente, Medico medico, double valor) {
        Consulta consulta = new Consulta();
        consulta.setId(UUID.randomUUID());
        consulta.setDataHora(LocalDate.now());
        consulta.setStatusConsulta("Agendada");
        consulta.setValor(valor);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        return consultaRepository.create(consulta);
    }

    /**
     * Cancela uma Consulta existente e persiste a alteração.
     */
    public Consulta cancelarConsulta(Consulta consulta) {
        consulta.setStatusConsulta("Cancelada");
        return consultaRepository.update(consulta);
    }
}
