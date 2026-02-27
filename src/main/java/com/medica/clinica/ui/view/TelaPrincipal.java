package com.medica.clinica.ui.view;

import com.medica.clinica.ui.controller.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

    private final Color COR_DESTAQUE_TEAL = new Color(0, 150, 136);
    private final Color COR_LATERAL_ESCURA = new Color(20, 40, 60);
    private final Color COR_LATERAL_HOVER = new Color(40, 70, 100);
    private final Color COR_FUNDO_CLARO = new Color(238, 238, 238);
    private final Color COR_TEXTO_ESCURO = new Color(33, 33, 33);

    public TelaPrincipal() {
        setTitle("HealthSys - Gestão Clínica");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelLateral = new JPanel();
        painelLateral.setLayout(new BoxLayout(painelLateral, BoxLayout.Y_AXIS));
        painelLateral.setBackground(COR_LATERAL_ESCURA);
        painelLateral.setPreferredSize(new Dimension(230, 0));
        painelLateral.setBorder(new EmptyBorder(30, 15, 30, 15));

        JLabel lblMenuTitulo = new JLabel("HealthSys");
        lblMenuTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblMenuTitulo.setForeground(Color.WHITE);
        lblMenuTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelLateral.add(lblMenuTitulo);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 30)));

        JButton btnPacientes       = criarBotaoMenu("  Pacientes");
        JButton btnMedicos         = criarBotaoMenu("  Médicos");
        JButton btnRecepcionistas  = criarBotaoMenu("  Recepcionistas");
        JButton btnAgendamento     = criarBotaoMenu("  Agendar Consulta");
        JButton btnProntuario      = criarBotaoMenu("  Prontuário Médico");
        JButton btnFolha           = criarBotaoMenu("  Folha de Pagamento");
        JButton btnSair            = criarBotaoMenu("  Sair do Sistema");

        btnSair.setBackground(COR_DESTAQUE_TEAL);

        painelLateral.add(btnPacientes);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLateral.add(btnMedicos);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLateral.add(btnRecepcionistas);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLateral.add(btnAgendamento);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLateral.add(btnProntuario);
        painelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelLateral.add(btnFolha);
        painelLateral.add(Box.createVerticalGlue());
        painelLateral.add(btnSair);

        JPanel painelCentral = new JPanel(new GridBagLayout());
        painelCentral.setBackground(COR_FUNDO_CLARO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;

        try {
            java.net.URL imgURL = getClass().getResource("/com/medica/clinica/ui/images/logo.png");
            if (imgURL != null) {
                ImageIcon logoIcon = new ImageIcon(imgURL);
                Image img = logoIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
                JLabel lblLogo = new JLabel(new ImageIcon(img));
                painelCentral.add(lblLogo, gbc);
                gbc.gridy++;
            }
        } catch (Exception ignored) {}

        JLabel lblBemVindo = new JLabel("Bem vindo!");
        lblBemVindo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblBemVindo.setForeground(COR_TEXTO_ESCURO);
        painelCentral.add(lblBemVindo, gbc);

        gbc.gridy++;
        JLabel lblSub = new JLabel("Utilize o menu lateral para navegar.");
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblSub.setForeground(COR_LATERAL_ESCURA);
        painelCentral.add(lblSub, gbc);

        add(painelLateral, BorderLayout.WEST);
        add(painelCentral, BorderLayout.CENTER);

        btnSair.addActionListener(e -> System.exit(0));
        btnPacientes.addActionListener(e -> new PacienteController(this).setVisible(true));
        btnMedicos.addActionListener(e -> new MedicoController(this).setVisible(true));
        btnRecepcionistas.addActionListener(e -> new RecepcionistaController(this).setVisible(true));
        btnAgendamento.addActionListener(e -> new AgendamentoController(this).setVisible(true));
        btnProntuario.addActionListener(e -> new ProntuarioController(this).setVisible(true));
        btnFolha.addActionListener(e -> new FolhaPagamentoController(this).setVisible(true));
    }

    private JButton criarBotaoMenu(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(COR_LATERAL_ESCURA);
        btn.setOpaque(true);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(230, 45));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!btn.getBackground().equals(COR_DESTAQUE_TEAL)) {
                    btn.setBackground(COR_LATERAL_HOVER);
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!btn.getBackground().equals(COR_DESTAQUE_TEAL)) {
                    btn.setBackground(COR_LATERAL_ESCURA);
                }
            }
        });
        return btn;
    }
}
