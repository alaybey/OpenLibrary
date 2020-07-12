package model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Book implements IModel, Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;
    @Column(updatable = false)
    private String name;
    @Column(updatable = false)
    private String subName;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;

    @Lob
    private String description;

    private boolean render = false;

    public Book() {
        // no-constructor for jpa
    }

    public Book(String name, String subName, String description, Author author, Publisher publisher ) {
        this.name = name;
        this.subName = subName;
        this.description = description;
        this.author = author;
        this.publisher = publisher;

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getIsbn() {
        return isbn;
    }
    public int setIsbn(int isbn){
        return this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", subName='" + subName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
