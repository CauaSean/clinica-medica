package com.medica.clinica.ui.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaFolhaPagamento extends JDialog {

    private final Color COR_DESTAQUE_TEAL  = new Color(0, 150, 136);
    private final Color COR_FUNDO_CLARO    = new Color(238, 238, 238);
    private final Color COR_LATERAL_ESCURA = new Color(20, 40, 60);

    protected JTextArea txtRelatorio;
    private JButton btnGerarFolha;

    public TelaFolhaPagamento(Frame parent) {
        super(parent, "Folha de Pagamento", true);
        setSize(500, 450);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel(new BorderLayout(10, 10));
        panelCentral.setBackground(COR_FUNDO_CLARO);
        panelCentral.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Relatório de Salários dos Funcionários");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setForeground(COR_LATERAL_ESCURA);
        panelCentral.add(lblTitulo, BorderLayout.NORTH);

        txtRelatorio = new JTextArea();
        txtRelatorio.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtRelatorio.setEditable(false);
        txtRelatorio.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(txtRelatorio);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.setBackground(COR_FUNDO_CLARO);

        btnGerarFolha = new JButton("Calcular Salários");
        btnGerarFolha.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGerarFolha.setBackground(COR_DESTAQUE_TEAL);
        btnGerarFolha.setForeground(Color.WHITE);
        btnGerarFolha.setFocusPainted(false);
        btnGerarFolha.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnGerarFolha.addActionListener(e -> calcularFolha());

        panelInferior.add(btnGerarFolha);
        panelCentral.add(panelInferior, BorderLayout.SOUTH);
        add(panelCentral);
    }

    /** Sobrescrito pelo controller após injeção de serviço. */
    protected void calcularFolha() {
        StringBuilder sb = new StringBuilder();
        sb.append("Calculando salários...\n\n");
        sb.append("Nenhum funcionário cadastrado ainda.\n");
        sb.append("Cadastre médicos e recepcionistas para visualizar a folha.");
        txtRelatorio.setText(sb.toString());
    }
}
