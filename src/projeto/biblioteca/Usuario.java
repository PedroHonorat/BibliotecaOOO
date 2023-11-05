package projeto.biblioteca;

public class Usuario {
    private int matricula;
    private String nome;
    private int idade;

    public Usuario(int matricula, String nome,int idade) {
        this.matricula= matricula;
        this.nome=nome;
        this.idade=idade;

    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
}
