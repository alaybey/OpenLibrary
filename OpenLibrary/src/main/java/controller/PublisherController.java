package controller;

import model.Book;
import model.Publisher;;
import service.PublisherService;
import service.PublisherServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class PublisherController  implements IController, Serializable {

    private final PublisherService publisherService = new PublisherServiceImpl();
    private String fullName;
    private String about;
    private List<Publisher> publishers = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    @PostConstruct
    public void init(){
        publishers = publisherService.findAllPublisher();
    }

    public void addPublisher(){
        publisherService.add(new Publisher(this.fullName,this.about));
    }
    public void removePublisher(int id){
        publisherService.remove(id);
    }

    public void editPublisher(int id){
        Publisher publisher = publisherService.getPublisher(id);

        this.fullName = publisher.getName();
        this.about = publisher.getAbout();

        publisher.setRender(!publisher.isRender());

    }

    public void savePublisher(int id){
        Publisher publisher = publisherService.getPublisher(id);

        publisher.setName(this.fullName);
        publisher.setAbout(this.about);

        publisherService.update(publisher.getId());
        publisher.setRender(!publisher.isRender());
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

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Book> getBooks(int id) {
        return publisherService.getBooks(id);
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
