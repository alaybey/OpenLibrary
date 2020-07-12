package service;

import model.Book;
import model.Publisher;

import java.util.List;

public interface PublisherService {

    void add(Publisher publisher);
    Publisher getPublisher(int id);
    List<Publisher> findAllPublisher();
    void update(int id);
    void remove(int id);
    List<Book> getBooks(int id);
    List<Publisher> findByPublisherName(String name);
    }
