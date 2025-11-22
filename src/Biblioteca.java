package src;
import java.util.*;

public class Biblioteca{

    private Map<String, Set<Livro>> bibliotecaLivros;
    private Set<String> titulosDuplicados;

    public Biblioteca() {
        this.bibliotecaLivros = new HashMap<>();
        this.titulosDuplicados = new HashSet<>();
    }

    public void adicionarLivro(Livro livro) throws LivroDuplicadoException{
     if(livro == null){
         throw new LivroDuplicadoException("O livro não pode ser nulo");
     }

        if (titulosDuplicados.contains(livro.getTitulo())) {
            throw new LivroDuplicadoException(
                    "Já existe um livro cadastrado com o título: " + livro.getTitulo()
            );
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

    public List<Livro> listarLivrosPorAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            System.out.println("Nome do autor inválido");
            return new ArrayList<>();
        }

        if (!bibliotecaLivros.containsKey(autor)) {
            System.out.println("Autor não encontrado: " + autor);
            return new ArrayList<>();
        }

        Set<Livro> livrosDoAutor = bibliotecaLivros.get(autor);
        return new ArrayList<>(livrosDoAutor);
    }

}