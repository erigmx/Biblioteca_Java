import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Biblioteca {
    private Map<String, Set<Livro>> bibliotecaLivros;
    private Set<String> titulosDuplicados;

    public Biblioteca() {
        this.bibliotecaLivros = new HashMap<>();
        this.titulosDuplicados = new HashSet<>();
    }

    public void adicionarLivro(Livro livro){
     if(livro == null){
         //exceção de livro nulo
     }

     String nomeAutor = livro.getAutor();

     //verifica se contem o nome do autor na biblioteca e adiciona
     if (!bibliotecaLivros.containsKey(nomeAutor)){
         bibliotecaLivros.put(nomeAutor, new HashSet<>());
     }

     //adiciona o livro na biblioteca do autor
     bibliotecaLivros.get(nomeAutor).add(livro);
     titulosDuplicados.add(livro.getTitulo());
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Título inválido para busca");
            return null;
        }

        for (Set<Livro> livros : bibliotecaLivros.values()) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
        }

        System.out.println("Livro, " + titulo + ", não encontrado");
        return null;
    }
}
