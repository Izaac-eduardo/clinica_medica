package estrutura;

import java.util.LinkedList;
import modelo.Paciente;

public class FilaDeAtendimento {
    private LinkedList<Paciente> fila;

    public FilaDeAtendimento() {
        fila = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente p) {
        fila.addLast(p);
    }

    public Paciente atenderPaciente() {
        if (!fila.isEmpty()) {
            return fila.removeFirst();
        }
        return null;
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila de atendimento está vazia.");
        } else {
            System.out.println("Fila de Atendimento:");
            for (Paciente p : fila) {
                System.out.println(p.exibirInfo());
            }
        }
    }
}