package projeto.biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
public class Biblioteca {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();


        public void adicionaAluno() {
                System.out.print("Quantos usuários deseja criar? ");
                int numUsuarios = teclado.nextInt();
                teclado.nextLine();

                // Consuma a nova linha em branco

                for (int i = 0; i < numUsuarios; i++) {
                        System.out.print("Digite a matrícula do usuário: ");
                        int matricula = teclado.nextInt();

                        System.out.print("Digite o nome do usuário: ");
                        String nome = teclado.nextLine();

                        System.out.print("Digite a idade do usuário: ");
                        int idade = teclado.nextInt();
                        teclado.nextLine();

                        Usuario usuario = new Usuario(matricula, nome, idade);
                        usuarios.add(usuario);
                        }
                }


                        public void mostrarAlunos() {
                        for (Usuario usuario : usuarios) {
                        System.out.println("Nome: " + usuario.getNome() + ", Matrícula: " + usuario.getMatricula());
                }
        }







}








