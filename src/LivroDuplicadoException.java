package src;

public class LivroDuplicadoException extends Exception {
    public LivroDuplicadoException() {
        super("Erro: Tentativa de adicionar um livro duplicado. O título já existe na biblioteca.");
    }

    public LivroDuplicadoException(String message) {
        super(message);
    }

    public LivroDuplicadoException(String message, Throwable cause) {
        super(message, cause);
    }
}


