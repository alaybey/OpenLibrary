package repository;

import model.Book;

import javax.persistence.PersistenceException;
import java.util.List;

public interface BookRepository extends GenericRepository {

    void add(Book book) throws PersistenceException;
    void remove(int isbn) throws PersistenceException;
    Book findBook(int isbn);
    List<Book> findAllBook();
    Book update(Book book);



}
