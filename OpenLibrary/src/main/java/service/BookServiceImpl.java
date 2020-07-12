package service;

import model.Book;
import repository.BookRepository;
import repository.BookRepositoryImpl;


import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(){
        bookRepository = new BookRepositoryImpl();
    }

    @Override
    public void add(Book book) {
        bookRepository.add(book);
    }

    @Override
    public void remove(int isbn) {
        bookRepository.remove(isbn);
    }

    @Override
    public Book findBook(int isbn) {
        return bookRepository.findBook(isbn);
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAllBook();
    }

    public List<Book> findByBookName(String name){
        return findAllBook().stream().filter(b -> b.getName().equals(name)).collect(Collectors.toList());

    }
    public List<Book> findByBookSubName(String subName){
        return findAllBook().stream().filter(b -> b.getName().equals(subName)).collect(Collectors.toList());

    }
    public List<Book> findByBookISBN(String isbn){
        return findAllBook().stream().filter(b -> String.valueOf(b.getIsbn()).equals(isbn)).collect(Collectors.toList());
    }
    @Override
    public Book update(int isbn) { return bookRepository.update(findBook(isbn)); }
}
