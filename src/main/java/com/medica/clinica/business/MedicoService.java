package com.medica.clinica.business;

import com.medica.clinica.infrastructure.entity.Consulta;
import com.medica.clinica.infrastructure.entity.Paciente;
import com.medica.clinica.infrastructure.repository.MedicoRepository;
import com.medica.clinica.infrastructure.entity.Medico;
import com.medica.clinica.infrastructure.entity.Recepcionista;

import java.time.LocalDate;

public class MedicoService implements MedicoRepository {

    Consulta consulta;
    Medico medico;
    Recepcionista recepcionista;

    @Override
    public double calcularSalario(double salarioMedico) {
        return salarioMedico;
    }

    public Consulta agendarConsulta(Paciente paciente, Medico medico, double valor){
        consulta.setDataHora(LocalDate.now());
        consulta.setStatusConsulta("Agendada");
        consulta.setValor(valor);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        return consulta;
    }

    public Consulta cancelarConsulta(Consulta consulta){
        consulta.setStatusConsulta("Cancelada");
        return consulta;
    }
}
