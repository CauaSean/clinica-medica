package com.medica.clinica.business;

import com.medica.clinica.infrastructure.repository.RecepcionistaRepository;

public class RecepcionistaService implements RecepcionistaRepository {
    @Override
    public double calcularSalario(double salarioRecepcionista) {
        return salarioRecepcionista;
    }


}
