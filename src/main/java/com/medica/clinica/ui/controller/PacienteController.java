package com.medica.clinica.ui.controller;

import com.medica.clinica.server.infrastructure.entity.Paciente;
import com.medica.clinica.ui.view.TelaCadastroPaciente;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PacienteController extends TelaCadastroPaciente {

    private final ServiceRegistry registry;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public PacienteController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
    }

    @Override
    protected void salvarPaciente() {
        try {
            String nome        = txtNome.getText().trim();
            String cpf         = txtCpf.getText().trim();
            String dataNascTxt = txtDataNasc.getText().trim();
            String telefone    = txtTelefone.getText().trim();
            String carteirinha = txtCarteirinha.getText().trim();
            String tipoSang    = (String) cmbTipoSanguineo.getSelectedItem();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha ao menos Nome e CPF.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Paciente paciente = new Paciente();
            paciente.setNome(nome);
            paciente.setCpf(cpf);
            paciente.setDataNascimento(dataNascTxt.isEmpty() ? null : SDF.parse(dataNascTxt));
            paciente.setTelefone(telefone);
            paciente.setNumeroCarteirinha(carteirinha);
            paciente.setTipoSanguineo(tipoSang);

            registry.getPacienteService().cadastrarPaciente(paciente);

            JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
            dispose();

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
