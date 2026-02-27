package com.medica.clinica.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCadastroPaciente extends JDialog {

    private final Color COR_DESTAQUE_TEAL  = new Color(0, 150, 136);
    private final Color COR_FUNDO_CLARO    = new Color(238, 238, 238);
    private final Color COR_BOTAO_CANCELAR = new Color(120, 120, 120);

    protected JTextField txtNome, txtCpf, txtDataNasc, txtTelefone, txtCarteirinha;
    protected JComboBox<String> cmbTipoSanguineo;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroPaciente(Frame parent) {
        super(parent, "Cadastro de Paciente", true);
        setSize(550, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(COR_FUNDO_CLARO);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo(formPanel, gbc, "Nome Completo:",   txtNome        = new JTextField(20), 0);
        adicionarCampo(formPanel, gbc, "CPF:",             txtCpf         = new JTextField(15), 1);
        adicionarCampo(formPanel, gbc, "Data Nascimento:", txtDataNasc    = new JTextField(10), 2);
        adicionarCampo(formPanel, gbc, "Telefone:",        txtTelefone    = new JTextField(15), 3);
        adicionarCampo(formPanel, gbc, "Nº Carteirinha:",  txtCarteirinha = new JTextField(15), 4);

        gbc.gridx = 0; gbc.gridy = 5;
        formPanel.add(criarLabel("Tipo Sanguíneo:"), gbc);
        gbc.gridx = 1;
        cmbTipoSanguineo = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        cmbTipoSanguineo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(cmbTipoSanguineo, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(COR_FUNDO_CLARO);
        btnPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        btnSalvar = new JButton("Salvar Dados");
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

        btnSalvar.addActionListener(e -> salvarPaciente());
        btnCancelar.addActionListener(e -> dispose());

        btnPanel.add(btnSalvar);
        btnPanel.add(btnCancelar);
        add(btnPanel, BorderLayout.SOUTH);
    }

    /** Sobrescrito pelo controller após injeção de serviço. */
    protected void salvarPaciente() {
        JOptionPane.showMessageDialog(this, "Paciente salvo com sucesso!");
        dispose();
    }

    private void adicionarCampo(JPanel p, GridBagConstraints g, String text, JTextField field, int y) {
        g.gridx = 0; g.gridy = y;
        p.add(criarLabel(text), g);
        g.gridx = 1;
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        p.add(field, g);
    }

    private JLabel criarLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(new Color(54, 71, 79));
        return lbl;
    }
}
