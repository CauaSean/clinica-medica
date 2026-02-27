package com.medica.clinica.ui.controller;

import com.medica.clinica.server.business.enums.TurnoTrabalho;
import com.medica.clinica.server.infrastructure.entity.Recepcionista;
import com.medica.clinica.ui.view.TelaCadastroRecepcionista;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class RecepcionistaController extends TelaCadastroRecepcionista {

    private final ServiceRegistry registry;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    private static final Map<String, TurnoTrabalho> TURNO_MAP = Map.of(
        "Manhã",  TurnoTrabalho.MANHA,
        "Tarde",  TurnoTrabalho.TARDE,
        "Noite",  TurnoTrabalho.NOITE
    );

    public RecepcionistaController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
    }

    @Override
    protected void salvarRecepcionista() {
        try {
            String nome        = txtNome.getText().trim();
            String cpf         = txtCpf.getText().trim();
            String dataNascTxt = txtDataNasc.getText().trim();
            String telefone    = txtTelefone.getText().trim();
            String matricula   = txtMatricula.getText().trim();
            String salarioTxt  = txtSalario.getText().trim();
            String turnoStr    = (String) cmbTurno.getSelectedItem();

            if (nome.isEmpty() || cpf.isEmpty() || salarioTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Recepcionista recepcionista = new Recepcionista();
            recepcionista.setNome(nome);
            recepcionista.setCpf(cpf);
            recepcionista.setDataNascimento(dataNascTxt.isEmpty() ? null : SDF.parse(dataNascTxt));
            recepcionista.setTelefone(telefone);
            recepcionista.setMatricula(matricula);
            recepcionista.setSalarioBase(Double.parseDouble(salarioTxt));
            recepcionista.setTurnoTrabalho(TURNO_MAP.getOrDefault(turnoStr, TurnoTrabalho.MANHA));

            registry.getRecepcionistaService().cadastrarRecepcionista(recepcionista);

            JOptionPane.showMessageDialog(this, "Recepcionista cadastrada com sucesso!");
            dispose();

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Salário inválido. Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
