package controller;

import model.Author;
import model.Book;
import model.Publisher;
import service.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@SessionScoped
public class BookController implements IController, Serializable {

    private final BookService bookService = new BookServiceImpl();
    private final AuthorService authorService = new AuthorServiceImpl();
    private final PublisherService publisherService = new PublisherServiceImpl();

    private String name;
    private String subName;
    private String description;
    private int authorId;
    private int publisherId;

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Publisher> publishers = new ArrayList<>();

    @PostConstruct
    public void init() {
        publishers = publisherService.findAllPublisher();
        authors = authorService.findAllAuthor();
        books = bookService.findAllBook();
    }

    public void addBook() {
        bookService.add(new Book(name, subName, description, authorService.getAuthor(authorId), publisherService.getPublisher(publisherId)));
        books = bookService.findAllBook();
    }

    public void deleteBook(int isbn) {
        bookService.remove(isbn);
        books = bookService.findAllBook();
    }

    public void editBook(int isbn) {
        Book book = bookService.findBook(isbn);

        this.name = book.getName();
        this.subName = book.getSubName();
        this.description = book.getDescription();

        book.setRender(!book.isRender());
    }

    public void saveBook(int isbn) {
        Book book = bookService.findBook(isbn);
        // set props
        book.setName(this.name);
        book.setSubName(this.subName);
        book.setDescription(this.description);
        // set props
        bookService.update(book.getIsbn());
        book.setRender(!book.isRender());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }
}
