package projeto.biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private boolean disponivel;

    public Livro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }
}

