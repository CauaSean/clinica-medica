package com.medica.clinica.ui.controller;

import com.medica.clinica.server.business.enums.Especialidade;
import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.ui.view.TelaCadastroMedico;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MedicoController extends TelaCadastroMedico {

    private final ServiceRegistry registry;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public MedicoController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
    }

    @Override
    protected void salvarMedico() {
        try {
            String nome       = txtNome.getText().trim();
            String cpf        = txtCpf.getText().trim();
            String dataNascTxt = txtDataNasc.getText().trim();
            String telefone   = txtTelefone.getText().trim();
            String matricula  = txtMatricula.getText().trim();
            String salarioTxt = txtSalario.getText().trim();
            String crm        = txtCrm.getText().trim();
            String espStr     = (String) cmbEspecialidade.getSelectedItem();

            if (nome.isEmpty() || cpf.isEmpty() || crm.isEmpty() || salarioTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Medico medico = new Medico();
            medico.setNome(nome);
            medico.setCpf(cpf);
            medico.setDataNascimento(dataNascTxt.isEmpty() ? null : SDF.parse(dataNascTxt));
            medico.setTelefone(telefone);
            medico.setMatricula(matricula);
            medico.setSalarioBase(Double.parseDouble(salarioTxt));
            medico.setCrm(crm);
            medico.setEspecialidade(Especialidade.valueOf(espStr));

            registry.getMedicoService().cadastrarMedico(medico);

            JOptionPane.showMessageDialog(this, "Médico cadastrado com sucesso!");
            dispose();

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salário inválido. Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
