package repository;

import model.Publisher;
import java.util.List;

public interface PublisherRepository {

    void add(Publisher publisher);
    Publisher getPublisher(int id);
    List<Publisher> findAllPublisher();
    Publisher update(Publisher publisher);
    void remove(int id);
    List<Publisher> findByPublisherName(String name);
}
