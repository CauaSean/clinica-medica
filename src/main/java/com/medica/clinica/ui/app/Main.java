package com.medica.clinica.ui.app;

import com.medica.clinica.ui.view.TelaPrincipal;

import javax.swing.*;

/**
 * Entrypoint da aplicação HealthSys.
 * Inicializa o Look & Feel e abre a janela principal.
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> new TelaPrincipal().setVisible(true));
    }
}
