package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
@NamedQuery(name="Publisher.findByPublisherName" , query = "SELECT p FROM Publisher p WHERE p.name = :name")
public class Publisher implements IModel,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 64)
    private String name;

    @Lob
    private String about;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    private boolean render = false;

    public Publisher() {
    }

    public Publisher(String name, String about) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String fullName) {
        this.name = fullName;
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
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", books=" + books +
                ", render=" + render +
                '}';
    }
}
