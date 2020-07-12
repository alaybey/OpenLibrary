package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class Author implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String fullName;

    @Lob
    private String about;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    private boolean render = false;
    public Author() {
    }

    public Author(String fullName, String about) {
        this.fullName = fullName;
        this.about = about;
    }


    public void addBook(Book book){
        books.add(book);
    }

    //add multiple book with varargs
    public void addBooks(Book ...book){
        books.addAll(Arrays.asList(book));
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }




    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
