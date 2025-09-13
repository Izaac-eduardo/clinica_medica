package estrutura;

import java.util.Stack;
import modelo.Paciente;

public class PilhaHistoricoAtendimentos {
    private Stack<Paciente> historico;

    public PilhaHistoricoAtendimentos() {
        historico = new Stack<>();
    }

    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
    }

    public Paciente verUltimoAtendido() {
        if (!historico.isEmpty()) {
            return historico.peek();
        }
        return null;
    }

    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("O histórico de atendimentos está vazio.");
        } else {
            System.out.println("Histórico de Atendimentos (do mais recente para o mais antigo):");
            for (int i = historico.size() - 1; i >= 0; i--) {
                System.out.println(historico.get(i).exibirInfo());
            }
        }
    }
}