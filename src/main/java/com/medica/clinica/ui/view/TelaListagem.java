package com.medica.clinica.ui.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaListagem extends JFrame {

    public TelaListagem(String tipoDeListagem) {
        setTitle("Listagem de " + tipoDeListagem);
        setSize(600, 400);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        String[] colunas = {"ID", "Nome", "Papel", "Telefone/Contato"};
        
        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modeloTabela);
        
        JScrollPane scrollPane = new JScrollPane(tabela);

        modeloTabela.addRow(new Object[]{"1", "Ana Paula", "Médica (Cardiologista)", "(34) 99999-1111"});
        modeloTabela.addRow(new Object[]{"2", "Carlos Eduardo", "Paciente", "(34) 98888-2222"});
        modeloTabela.addRow(new Object[]{"3", "Dr. Roberto", "Médico (Pediatra)", "(34) 97777-3333"});

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}