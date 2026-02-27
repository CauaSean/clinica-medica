package com.medica.clinica.ui.controller;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.server.infrastructure.entity.PontuarioEletronico;
import com.medica.clinica.server.infrastructure.entity.RegistroMedico;
import com.medica.clinica.ui.view.TelaProntuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProntuarioController extends TelaProntuario {

    private final ServiceRegistry registry;
    private List<Paciente> pacientes;

    public ProntuarioController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
        carregarPacientes();
    }

    private void carregarPacientes() {
        pacientes = registry.getPacienteService().listarPacientes();
        cmbPacientes.removeAllItems();
        if (pacientes.isEmpty()) {
            cmbPacientes.addItem("Nenhum paciente cadastrado");
        } else {
            for (Paciente p : pacientes) {
                cmbPacientes.addItem(p.getNome() + " (CPF: " + p.getCpf() + ")");
            }
        }
    }

    @Override
    protected void registrarAtendimento() {
        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum paciente cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idx = cmbPacientes.getSelectedIndex();
        if (idx < 0 || idx >= pacientes.size()) return;
        Paciente paciente = pacientes.get(idx);

        String sintomas    = txtSintomas.getText().trim();
        String diagnostico = txtDiagnostico.getText().trim();
        String prescricao  = txtPrescricao.getText().trim();

        if (sintomas.isEmpty() && diagnostico.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe ao menos os sintomas ou o diagnóstico.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Busca ou cria o prontuário do paciente
        PontuarioEletronico pontuario = registry.getPontuarioService()
                .buscarPontuarioPorPaciente(paciente)
                .orElseGet(() -> {
                    PontuarioEletronico novo = new PontuarioEletronico();
                    novo.setPaciente(paciente);
                    novo.setDataAbertura(new Date());
                    novo.setAlergias(new ArrayList<>());
                    novo.setRegistros(new ArrayList<>());
                    return registry.getPontuarioService().criarPontuario(novo);
                });

        RegistroMedico registro = new RegistroMedico();
        registro.setPontuarioEletronico(pontuario);
        registro.setSintomas(sintomas);
        registro.setDiagnostico(diagnostico);
        registro.setPrescricao(prescricao);
        registry.getRegistroService().criarRegistro(registro);

        registry.getPontuarioService().adicionarRegistro(pontuario, registro);

        JOptionPane.showMessageDialog(this, "Prontuário registrado com sucesso!");
        dispose();
    }
}
