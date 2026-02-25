package com.medica.clinica.infrastructure.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface MedicoRepository {
   void lerArquivo();
   void escreverArquivo(String conteudo);
}

