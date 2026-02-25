package com.medica.clinica;


    import com.medica.clinica.infrastructure.repository.MedicoRepository;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.stereotype.Component;

    import java.util.Date;
    import java.util.Scanner;

@Component
    public class StartupRunner implements CommandLineRunner {

        private final MedicoRepository medicoRepository;

        public StartupRunner(MedicoRepository medicoRepository) {
            this.medicoRepository = medicoRepository;
        }

        @Override
        public void run(String... args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o  número de matrícula do funcionário:");
            String matricula = scanner.nextLine();
            medicoRepository.escreverArquivo(matricula);

            System.out.println("Digite o salário base do funcionário:");
            double salarioBase = scanner.nextDouble();
            medicoRepository.escreverArquivo(String.valueOf(salarioBase));



            System.out.println("Digite o crm do médico:");
            String crm = scanner.nextLine();
            medicoRepository.escreverArquivo(crm);

            System.out.println("Digite o especialidade do médico:");
            String especialidade = scanner.nextLine();
            medicoRepository.escreverArquivo(especialidade);



            System.out.println("Digite o número da carteirinha do paciente:");
            String numeroCarteirinha = scanner.nextLine();
            medicoRepository.escreverArquivo(numeroCarteirinha);

            System.out.println("Digite o  tipo sanguíneo  do paciente:");
            String tipoSanguineo = scanner.nextLine();
            medicoRepository.escreverArquivo(tipoSanguineo);




            System.out.println("\nConteúdo do arquivo:");
            medicoRepository.lerArquivo();
        }

        }

