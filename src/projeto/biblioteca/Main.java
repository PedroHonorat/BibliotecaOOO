package projeto.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner teclado = new Scanner(System.in);

        int op;

        do {
            System.out.println("\n==> Menu:\n");
            System.out.println("   0 - sair");
            System.out.println("   1 - adicionar usuarios ");
            System.out.println("   2 - mostra lista de usuarios");
            System.out.println("   3 - devolve livro");
            System.out.println("   4 - remover aluno\n");
            System.out.println("Digite o numero da opcao: ");
            op = teclado.nextInt();


            switch (op) {
                case 0:
                    System.out.println("Saindo..."); // System.exit(0);
                    break;
                case 1:
                    biblioteca.adicionaAluno();
                    break;
                case 2:
                    biblioteca.mostrarAlunos();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opcao invalida!\n\n");
                    break;
            }
        } while (op != 0);

    }
}
