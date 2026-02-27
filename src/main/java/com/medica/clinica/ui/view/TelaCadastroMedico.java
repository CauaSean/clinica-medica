package com.medica.clinica.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCadastroMedico extends JDialog {

    private final Color COR_DESTAQUE_TEAL  = new Color(0, 150, 136);
    private final Color COR_FUNDO_CLARO    = new Color(238, 238, 238);
    private final Color COR_BOTAO_CANCELAR = new Color(120, 120, 120);

    protected JTextField txtNome, txtCpf, txtDataNasc, txtTelefone;
    protected JTextField txtMatricula, txtSalario, txtCrm;
    protected JComboBox<String> cmbEspecialidade;
    private JButton btnSalvar, btnCancelar;

    public TelaCadastroMedico(Frame parent) {
        super(parent, "Cadastro de Médico", true);
        setSize(550, 550);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(COR_FUNDO_CLARO);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo(formPanel, gbc, "Nome Completo:",   txtNome     = new JTextField(20), 0);
        adicionarCampo(formPanel, gbc, "CPF:",             txtCpf      = new JTextField(15), 1);
        adicionarCampo(formPanel, gbc, "Data Nascimento:", txtDataNasc = new JTextField(10), 2);
        adicionarCampo(formPanel, gbc, "Telefone:",        txtTelefone = new JTextField(15), 3);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formPanel.add(new JSeparator(), gbc);
        gbc.gridwidth = 1;

        adicionarCampo(formPanel, gbc, "Matrícula:",   txtMatricula = new JTextField(10), 5);
        adicionarCampo(formPanel, gbc, "Salário Base:", txtSalario  = new JTextField(10), 6);
        adicionarCampo(formPanel, gbc, "CRM:",          txtCrm      = new JTextField(10), 7);

        gbc.gridx = 0; gbc.gridy = 8;
        formPanel.add(criarLabel("Especialidade:"), gbc);
        gbc.gridx = 1;
        cmbEspecialidade = new JComboBox<>(new String[]{
            "NEUROCIRURGIA", "CARDIOLOGIA", "GINECOLOGIA", "PEDIATRIA", "ORTOPEDIA"
        });
        cmbEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(cmbEspecialidade, gbc);

        add(formPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(COR_FUNDO_CLARO);
        btnPanel.setBorder(new EmptyBorder(0, 0, 20, 0));

        btnSalvar = new JButton("Salvar Médico");
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

        // Ação de salvar — conectada ao serviço em Step 3
        btnSalvar.addActionListener(e -> salvarMedico());
        btnCancelar.addActionListener(e -> dispose());

        btnPanel.add(btnSalvar);
        btnPanel.add(btnCancelar);
        add(btnPanel, BorderLayout.SOUTH);
    }

    /** Sobrescrito pelo controller após injeção de serviço. */
    protected void salvarMedico() {
        JOptionPane.showMessageDialog(this, "Médico cadastrado com sucesso!");
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
