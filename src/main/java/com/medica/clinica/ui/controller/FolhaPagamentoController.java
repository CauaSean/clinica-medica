package com.medica.clinica.ui.controller;

import com.medica.clinica.server.infrastructure.entity.Medico;
import com.medica.clinica.server.infrastructure.entity.Recepcionista;
import com.medica.clinica.ui.view.TelaFolhaPagamento;

import java.awt.*;
import java.util.List;

public class FolhaPagamentoController extends TelaFolhaPagamento {

    private final ServiceRegistry registry;

    public FolhaPagamentoController(Frame parent) {
        super(parent);
        this.registry = ServiceRegistry.getInstance();
    }

    @Override
    protected void calcularFolha() {
        List<Medico> medicos             = registry.getMedicoService().listarMedicos();
        List<Recepcionista> recepcionistas = registry.getRecepcionistaService().listarRecepcionistas();

        if (medicos.isEmpty() && recepcionistas.isEmpty()) {
            txtRelatorio.setText("Nenhum funcionário cadastrado.\nCadastre médicos ou recepcionistas para calcular a folha.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== FOLHA DE PAGAMENTO ===\n\n");

        double totalFolha = 0.0;

        if (!medicos.isEmpty()) {
            sb.append("--- MÉDICOS ---\n");
            for (Medico m : medicos) {
                double salario = m.calcularSalario();
                totalFolha += salario;
                sb.append(String.format("%-30s | CRM: %-10s | %-14s | R$ %,.2f%n",
                        m.getNome(), m.getCrm(), m.getEspecialidade(), salario));
            }
            sb.append("\n");
        }

        if (!recepcionistas.isEmpty()) {
            sb.append("--- RECEPCIONISTAS ---\n");
            for (Recepcionista r : recepcionistas) {
                double salario = r.calcularSalario();
                totalFolha += salario;
                sb.append(String.format("%-30s | Matrícula: %-8s | %-5s | R$ %,.2f%n",
                        r.getNome(), r.getMatricula(), r.getTurnoTrabalho(), salario));
            }
            sb.append("\n");
        }

        sb.append(String.format("TOTAL DA FOLHA: R$ %,.2f", totalFolha));
        txtRelatorio.setText(sb.toString());
    }
}
