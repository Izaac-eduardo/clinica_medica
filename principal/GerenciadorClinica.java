package principal;

import java.util.Scanner;
import estrutura.FilaDeAtendimento;
import estrutura.PilhaHistoricoAtendimentos;
import modelo.Paciente;

public class GerenciadorClinica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDeAtendimento filaDeAtendimento = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historicoDeAtendimentos = new PilhaHistoricoAtendimentos();
        int opcao;

        do {
            System.out.println("===================================================");
            System.out.println("1. Adicionar novo paciente à fila");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir fila de atendimento");
            System.out.println("4. Exibir histórico de atendimentos");
            System.out.println("5. Sair");
            System.out.println("===================================================");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();

                    int idade = 0;
                    boolean idadeValida = false;
                    while (!idadeValida) {
                        System.out.print("Idade do paciente: ");
                        if (scanner.hasNextInt()) {
                            idade = scanner.nextInt();
                            scanner.nextLine();
                            idadeValida = true;
                        } else {
                            System.out.println("Entrada inválida para idade. Por favor, digite um número.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Sintoma do paciente: ");
                    String sintoma = scanner.nextLine();

                    Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                    filaDeAtendimento.adicionarPaciente(novoPaciente);
                    System.out.println("Paciente adicionado à fila com sucesso.");
                } else if (opcao == 2) {
                    if (!filaDeAtendimento.estaVazia()) {
                        Paciente pacienteAtendido = filaDeAtendimento.atenderPaciente();
                        historicoDeAtendimentos.adicionarAoHistorico(pacienteAtendido);
                        System.out.println("Paciente atendido: " + pacienteAtendido.exibirInfo());
                    } else {
                        System.out.println("A fila de atendimento está vazia.");
                    }
                } else if (opcao == 3) {
                    filaDeAtendimento.mostrarFila();
                } else if (opcao == 4) {
                    historicoDeAtendimentos.mostrarHistorico();
                } else if (opcao == 5) {
                    System.out.println("Saindo do sistema...");
                } else {
                    System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 5.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = 0;
            }

        } while (opcao != 5);

        scanner.close();
    }
}