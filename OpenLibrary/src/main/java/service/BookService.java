package service;

import model.Book;
import java.util.List;

public interface BookService {

    void add(Book book) ;
    void remove(int isbn) ;
    Book findBook(int isbn);
    List<Book> findAllBook();
    Book update(int isbn);
    List<Book> findByBookName(String name);
    List<Book> findByBookSubName(String name);
    List<Book> findByBookISBN(String name);

}
