package controller;

import model.Author;
import model.Book;
import service.AuthorService;
import service.AuthorServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AuthorController  implements IController, Serializable {

    private final AuthorService authorService = new AuthorServiceImpl();
    private String fullName;
    private String about;
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    @PostConstruct
    public void init(){
        authors = authorService.findAllAuthor();
    }

    public void addAuthor(){
        authorService.add(new Author(this.fullName,this.about));
    }
    public void removeAuthor(int id){
        authorService.remove(id);
    }

    public void editAuthor(int id){
        Author author = authorService.getAuthor(id);

        this.fullName = author.getFullName();
        this.about = author.getAbout();

        author.setRender(!author.isRender());

    }

    public void saveAuthor(int id){
        Author author = authorService.getAuthor(id);

        author.setFullName(this.fullName);
        author.setAbout(this.about);

        authorService.update(author.getId());
        author.setRender(!author.isRender());
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Book> getBooks(int id) {
        return authorService.getBooks(id);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
