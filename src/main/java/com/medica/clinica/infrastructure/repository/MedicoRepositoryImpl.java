package com.medica.clinica.infrastructure.repository;

import org.springframework.stereotype.Repository;

import java.io.*;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {
    private static final String PATH = "/home/caua/codes/POO/clinica/src/main/java/com/medica/clinica/medicos.txt";

    @Override
    public void lerArquivo() {
        try (FileReader fr = new FileReader(PATH);
             BufferedReader br = new BufferedReader(fr)) {

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro! " + e.getMessage());
        }

    }

    public void escreverArquivo(String conteudo){
        try (FileWriter fw = new FileWriter(PATH, true); // true = append
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(conteudo);
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Erro ao escrever! " + e.getMessage());
        }
    }
}
