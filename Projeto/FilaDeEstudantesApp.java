package Projeto;

import javax.swing.JOptionPane;

public class FilaDeEstudantesApp {
    public static void main(String[] args) {
        int tamanhoFila = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho da fila:"));
        FilaDeEstudantes filaDeEstudantes = new FilaDeEstudantes(tamanhoFila);

        while (true) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                                                        "1. Adicionar estudante à fila\n" +
                                                        "2. Remover estudante da fila\n" +
                                                        "3. Mostrar fila\n" +
                                                        "4. Sair");

            switch (opcao) {
                case "1":
                    String nomeEstudante = JOptionPane.showInputDialog("Informe o nome do estudante:");
                    Estudante estudante = new Estudante(nomeEstudante);
                    filaDeEstudantes.incluirNaFila(estudante);
                    break;
                case "2":
                    Estudante estudanteRemovido = filaDeEstudantes.removerDaFila();
                    if (estudanteRemovido != null) {
                        JOptionPane.showMessageDialog(null, "Estudante removido: " + estudanteRemovido.getNome());
                    }
                    break;
                case "3":
                    filaDeEstudantes.mostrarFila();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha novamente.");
                    break;
            }
        }
    }
}