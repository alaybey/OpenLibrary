package service;

import model.Author;
import model.Book;

import java.util.List;

public interface AuthorService {
    void add(Author author);

    Author getAuthor(int id);

    List<Author> findAllAuthor();

    void update(int id);

    void remove(int id);

    List<Book> getBooks(int id);

    List<Author> findByAuthorName(String name);
}
