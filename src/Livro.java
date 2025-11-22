package src;

import java.util.Objects;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Livro)) return false;
        Livro livro = (Livro) obj;
        return titulo.equals(livro.titulo) && autor.equals(livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor, ano);
    }

    @Override
    public String toString() {
        return titulo + "\n" + autor + "\n" + ano + "\n";
    }

}
