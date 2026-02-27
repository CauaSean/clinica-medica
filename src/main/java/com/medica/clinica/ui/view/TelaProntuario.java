package com.medica.clinica.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaProntuario extends JDialog {

    private final Color COR_DESTAQUE_TEAL  = new Color(0, 150, 136);
    private final Color COR_FUNDO_CLARO    = new Color(238, 238, 238);
    private final Color COR_BOTAO_CANCELAR = new Color(120, 120, 120);

    protected JComboBox<String> cmbPacientes;
    protected JTextArea txtSintomas, txtDiagnostico, txtPrescricao;
    private JButton btnSalvar, btnCancelar;

    public TelaProntuario(Frame parent) {
        super(parent, "Prontuário Eletrônico", true);
        setSize(600, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(COR_FUNDO_CLARO);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        gbc.gridx = 0; gbc.gridy = 0; gbc.weighty = 0;
        formPanel.add(criarLabel("Paciente:"), gbc);
        gbc.gridx = 1;
        cmbPacientes = new JComboBox<>();
        cmbPacientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(cmbPacientes, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        formPanel.add(criarLabel("Sintomas:"), gbc);
        gbc.gridy = 2; gbc.weighty = 1.0;
        txtSintomas = new JTextArea(4, 20);
        formPanel.add(new JScrollPane(txtSintomas), gbc);

        gbc.gridy = 3; gbc.weighty = 0;
        formPanel.add(criarLabel("Diagnóstico:"), gbc);
        gbc.gridy = 4; gbc.weighty = 1.0;
        txtDiagnostico = new JTextArea(4, 20);
        formPanel.add(new JScrollPane(txtDiagnostico), gbc);

        gbc.gridy = 5; gbc.weighty = 0;
        formPanel.add(criarLabel("Prescrição:"), gbc);
        gbc.gridy = 6; gbc.weighty = 1.0;
        txtPrescricao = new JTextArea(4, 20);
        formPanel.add(new JScrollPane(txtPrescricao), gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(COR_FUNDO_CLARO);
        btnPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        btnSalvar = new JButton("Registrar Atendimento");
        btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSalvar.setBackground(COR_DESTAQUE_TEAL);
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFocusPainted(false);
        btnSalvar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnCancelar.setBackground(COR_BOTAO_CANCELAR);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSalvar.addActionListener(e -> registrarAtendimento());
        btnCancelar.addActionListener(e -> dispose());

        btnPanel.add(btnSalvar);
        btnPanel.add(btnCancelar);
        add(btnPanel, BorderLayout.SOUTH);
    }

    /** Sobrescrito pelo controller após injeção de serviço. */
    protected void registrarAtendimento() {
        JOptionPane.showMessageDialog(this, "Prontuário registrado com sucesso!");
        dispose();
    }

    private JLabel criarLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(new Color(54, 71, 79));
        return lbl;
    }
}
