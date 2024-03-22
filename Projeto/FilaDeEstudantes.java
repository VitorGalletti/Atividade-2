package Projeto;

import javax.swing.JOptionPane;

public class FilaDeEstudantes {
 private Estudante[] fila;
 private int tamanho;
 private int inicio;
 private int fim;

 public FilaDeEstudantes(int tamanho) {
     this.tamanho = tamanho;
     fila = new Estudante[tamanho];
     inicio = fim = -1;
 }

 public boolean estaVazia() {
     return inicio == -1;
 }

 public boolean estaCheia() {
     return (inicio == 0 && fim == tamanho - 1) || (inicio == fim + 1);
 }

 public void incluirNaFila(Estudante estudante) {
     if (!estaCheia()) {
         if (inicio == -1)
             inicio = 0;
         fim = (fim + 1) % tamanho;
         fila[fim] = estudante;
         if (inicio == fim)
             inicio = (inicio + 1) % tamanho;
     } else {
         System.out.println("Fila cheia! Não é possível adicionar mais estudantes.");
     }
 }

 public Estudante removerDaFila() {
     if (!estaVazia()) {
         Estudante estudante = fila[inicio];
         if (inicio == fim)
             inicio = fim = -1;
         else
             inicio = (inicio + 1) % tamanho;
         return estudante;
     } else {
         System.out.println("Fila vazia! Não há estudantes para remover.");
         return null;
     }
 }

 public void mostrarFila() {
     if (!estaVazia()) {
         String output = "Fila de Estudantes:\n";
         int i = inicio;
         do {
             output += fila[i].getNome() + "\n";
             i = (i + 1) % tamanho;
         } while (i != (fim + 1) % tamanho);
         JOptionPane.showMessageDialog(null, output);
     } else {
         JOptionPane.showMessageDialog(null, "Fila vazia!");
     }
 }
}