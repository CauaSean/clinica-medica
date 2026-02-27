package com.medica.clinica.ui.controller;

import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.ui.exception.PacienteNaoEncontradoException;
import com.medica.clinica.ui.view.TelaAgendamento;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AgendamentoController extends TelaAgendamento {

    private final ServiceRegistry registry;
    private Paciente pacienteEncontrado;
    private List<Medico> medicos;

    public AgendamentoController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
        carregarMedicos();
    }

    private void carregarMedicos() {
        medicos = registry.getMedicoService().listarMedicos();
        cmbMedicos.removeAllItems();
        if (medicos.isEmpty()) {
            cmbMedicos.addItem("Nenhum médico cadastrado");
        } else {
            for (Medico m : medicos) {
                cmbMedicos.addItem(m.getNome() + " (" + m.getEspecialidade() + ")");
            }
        }
    }

    @Override
    protected void buscarPaciente() {
        String cpf = txtCpfBusca.getText().trim();
        try {
            if (cpf.isEmpty()) {
                throw new PacienteNaoEncontradoException("Informe o CPF do paciente.");
            }
            pacienteEncontrado = registry.getPacienteService()
                    .buscarPacientePorCpf(cpf)
                    .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente com CPF " + cpf + " não encontrado."));

            lblNomePacienteEncontrado.setText("Paciente: " + pacienteEncontrado.getNome());
            lblNomePacienteEncontrado.setForeground(new java.awt.Color(0, 150, 136));
            btnAgendar.setEnabled(!medicos.isEmpty());

        } catch (PacienteNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Busca", JOptionPane.ERROR_MESSAGE);
            lblNomePacienteEncontrado.setText("Paciente: (Nenhum selecionado)");
            lblNomePacienteEncontrado.setForeground(java.awt.Color.GRAY);
            pacienteEncontrado = null;
            btnAgendar.setEnabled(false);
        }
    }

    @Override
    protected void agendarConsulta() {
        if (pacienteEncontrado == null) {
            JOptionPane.showMessageDialog(this, "Busque um paciente primeiro.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (medicos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum médico cadastrado.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idx = cmbMedicos.getSelectedIndex();
        if (idx < 0 || idx >= medicos.size()) return;
        Medico medico = medicos.get(idx);

        double valor;
        try {
            valor = Double.parseDouble(txtValor.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valor inválido. Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        registry.getMedicoService().agendarConsulta(pacienteEncontrado, medico, valor);

        JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
        dispose();
    }
}
