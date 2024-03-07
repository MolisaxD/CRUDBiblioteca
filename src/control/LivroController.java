package control;

import dao.DBConnection;
import model.Livro;

import java.util.ArrayList;

public class LivroController {

    DBConnection db = new DBConnection();
    public void cadastrarLivro(String titulo, String autor) {
        Livro livroNovo = new Livro(titulo, autor);
        db.create(livroNovo);
    }

    public void listarLivros() {
        ArrayList<Livro> listaLivros = db.read();
        int tamanhoLista = db.read().size();
        for (int i = 0; i <= tamanhoLista - 1; i++) {
            System.out.println("Livro " + (i + 1) + ":");
            System.out.println("Titulo: " + listaLivros.get(i).getTitulo() + "\nAutor: " + listaLivros.get(i).getAutor());
        }
    }

    public void editarLivro(int idLivro, String tituloNovo, String autorNovo) {
        Livro livroAtualizado = new Livro(tituloNovo, autorNovo);
        db.update(livroAtualizado, idLivro);
    }

    public void deletarLivro(int idLivro) {
        db.delete(idLivro);
    }
}
