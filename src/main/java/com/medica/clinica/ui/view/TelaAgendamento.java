package com.medica.clinica.ui.view;

import com.medica.clinica.ui.exception.PacienteNaoEncontradoException;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaAgendamento extends JDialog {

    private final Color COR_DESTAQUE_TEAL = new Color(0, 150, 136);
    private final Color COR_FUNDO_CLARO   = new Color(238, 238, 238);
    private final Color COR_TEXTO_ESCURO  = new Color(54, 71, 79);
    private final Color COR_BOTAO_BUSCAR  = new Color(40, 70, 100);

    protected JTextField txtCpfBusca;
    protected JLabel lblNomePacienteEncontrado;
    protected JComboBox<String> cmbMedicos;
    protected JTextField txtDataHora;
    protected JTextField txtValor;
    private JButton btnBuscarPaciente;
    protected JButton btnAgendar;

    public TelaAgendamento(Frame parent) {
        super(parent, "Agendar Consulta", true);
        setSize(480, 500);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COR_FUNDO_CLARO);
        panel.setBorder(new EmptyBorder(25, 25, 25, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 5, 10, 5);

        Font fonteLabel = new Font("Segoe UI", Font.BOLD, 14);
        Font fonteCampo = new Font("Segoe UI", Font.PLAIN, 14);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JLabel lblBusca = new JLabel("Buscar Paciente (Digite o CPF):");
        lblBusca.setFont(fonteLabel); lblBusca.setForeground(COR_TEXTO_ESCURO);
        panel.add(lblBusca, gbc);

        gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0.7;
        txtCpfBusca = new JTextField();
        txtCpfBusca.setFont(fonteCampo);
        panel.add(txtCpfBusca, gbc);

        gbc.gridx = 1; gbc.weightx = 0.3;
        btnBuscarPaciente = new JButton("Buscar");
        btnBuscarPaciente.setBackground(COR_BOTAO_BUSCAR);
        btnBuscarPaciente.setForeground(Color.WHITE);
        btnBuscarPaciente.setFocusPainted(false);
        panel.add(btnBuscarPaciente, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        lblNomePacienteEncontrado = new JLabel("Paciente: (Nenhum selecionado)");
        lblNomePacienteEncontrado.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        lblNomePacienteEncontrado.setForeground(Color.GRAY);
        panel.add(lblNomePacienteEncontrado, gbc);

        gbc.gridy = 3;
        JLabel lblMedico = new JLabel("Selecione o Médico:");
        lblMedico.setFont(fonteLabel); lblMedico.setForeground(COR_TEXTO_ESCURO);
        panel.add(lblMedico, gbc);

        gbc.gridy = 4;
        cmbMedicos = new JComboBox<>();
        cmbMedicos.setFont(fonteCampo);
        panel.add(cmbMedicos, gbc);

        gbc.gridy = 5;
        JLabel lblData = new JLabel("Data e Hora (dd/MM/yyyy):");
        lblData.setFont(fonteLabel); lblData.setForeground(COR_TEXTO_ESCURO);
        panel.add(lblData, gbc);

        gbc.gridy = 6;
        txtDataHora = new JTextField();
        txtDataHora.setFont(fonteCampo);
        panel.add(txtDataHora, gbc);

        gbc.gridy = 7;
        JLabel lblValor = new JLabel("Valor da Consulta (R$):");
        lblValor.setFont(fonteLabel); lblValor.setForeground(COR_TEXTO_ESCURO);
        panel.add(lblValor, gbc);

        gbc.gridy = 8;
        txtValor = new JTextField();
        txtValor.setFont(fonteCampo);
        panel.add(txtValor, gbc);

        add(panel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(COR_FUNDO_CLARO);
        btnPanel.setBorder(new EmptyBorder(0, 25, 25, 25));

        btnAgendar = new JButton("Confirmar Agendamento");
        btnAgendar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnAgendar.setBackground(COR_DESTAQUE_TEAL);
        btnAgendar.setForeground(Color.WHITE);
        btnAgendar.setFocusPainted(false);
        btnAgendar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgendar.setPreferredSize(new Dimension(400, 45));
        btnAgendar.setEnabled(false);

        btnBuscarPaciente.addActionListener(e -> buscarPaciente());
        btnAgendar.addActionListener(e -> agendarConsulta());

        btnPanel.add(btnAgendar);
        add(btnPanel, BorderLayout.SOUTH);
    }

    /** Sobrescrito pelo controller: busca paciente por CPF via serviço. */
    protected void buscarPaciente() {
        String cpf = txtCpfBusca.getText().trim();
        try {
            if (cpf.isEmpty()) {
                throw new PacienteNaoEncontradoException("Informe o CPF.");
            }
            lblNomePacienteEncontrado.setText("Paciente: (não implementado)");
            lblNomePacienteEncontrado.setForeground(COR_DESTAQUE_TEAL);
            btnAgendar.setEnabled(true);
        } catch (PacienteNaoEncontradoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Busca", JOptionPane.ERROR_MESSAGE);
            lblNomePacienteEncontrado.setText("Paciente: (Nenhum selecionado)");
            lblNomePacienteEncontrado.setForeground(Color.GRAY);
            btnAgendar.setEnabled(false);
        }
    }

    /** Sobrescrito pelo controller: agenda consulta via serviço. */
    protected void agendarConsulta() {
        JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
        dispose();
    }
}
