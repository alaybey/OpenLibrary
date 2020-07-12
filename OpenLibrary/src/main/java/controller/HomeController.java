package controller;

import model.Author;
import model.Book;
import model.Publisher;
import service.*;
import sessionutil.SessionUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@SessionScoped
public class HomeController implements IController, Serializable {

    private final BookService bookService = new BookServiceImpl();
    private final AuthorService authorService = new AuthorServiceImpl();
    private final PublisherService publisherService = new PublisherServiceImpl();

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Publisher> publishers = new ArrayList<>();

    private boolean renderBooks = false;
    private boolean renderAuthors = false;
    private boolean renderPublishers = false;

    private String keyword;

    @PostConstruct
    public void commit(){
        renderBooks = false;
        renderAuthors = false;
        renderPublishers = false;
    }

    public List<Book> getBook(String keyword){
        commit();
        this.books = bookService.findByBookName(keyword);
        this.books = this.books == null ? bookService.findByBookSubName(keyword) : this.books;
        this.books = this.books == null ? bookService.findByBookISBN(keyword) : this.books;
        renderBooks = true;
        return  this.books;
    }

    public List<Author> getAuthor(String keyword){
        commit();
        authors = authorService.findByAuthorName(keyword);
        renderAuthors = true;
        return authors;
    }

    public List<Publisher> getPublisher(String keyword){
        commit();
        publishers = publisherService.findByPublisherName(keyword);
        renderPublishers = true;
        return publishers;
    }

    public boolean isRenderBooks() {
        return renderBooks;
    }

    public boolean isRenderAuthors() {
        return renderAuthors;
    }

    public boolean isRenderPublishers() {
        return renderPublishers;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
