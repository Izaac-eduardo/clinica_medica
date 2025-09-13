package principal;

import estrutura.PilhaHistoricoAtendimentos;
import estrutura.FilaDeAtendimento;
import modelo.Paciente;

public class GerenciadorClinica {

    public static void main(String[] args) {

        PilhaHistoricoAtendimentos historicoDeAtendimentos = new PilhaHistoricoAtendimentos();

        System.out.println("--- DEMONSTRAÇÃO DA PILHA ---");
        
        Paciente p1 = new Paciente("Maria da Silva", 30, "Febre");
        Paciente p2 = new Paciente("Pedro Souza", 55, "Dor no peito");
        Paciente p3 = new Paciente("Ana Lima", 12, "Fratura no braço");

        historicoDeAtendimentos.adicionarAoHistorico(p1);
        historicoDeAtendimentos.adicionarAoHistorico(p2);
        historicoDeAtendimentos.adicionarAoHistorico(p3);
        
        System.out.println("Último paciente atendido: " + historicoDeAtendimentos.verUltimoAtendido().exibirInfo());
        System.out.println("--------------------------------------------------------------------------");
        
        historicoDeAtendimentos.mostrarHistorico();
        System.out.println("\n");


        FilaDeAtendimento filaDeEspera = new FilaDeAtendimento();
        
        System.out.println("--- DEMONSTRAÇÃO DA FILA ---");

        Paciente p4 = new Paciente("Lucas Santos", 25, "Enxaqueca");
        Paciente p5 = new Paciente("Julia Ferreira", 40, "Dores no corpo");
        
        filaDeEspera.adicionarPaciente(p4);
        filaDeEspera.adicionarPaciente(p5);
        
        System.out.println("Próximo paciente a ser atendido: " + filaDeEspera.atenderPaciente().exibirInfo());
        System.out.println("--------------------------------------------------------------------------");

        filaDeEspera.mostrarFila();
    }
}