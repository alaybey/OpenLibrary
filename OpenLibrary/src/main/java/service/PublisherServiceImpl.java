package service;

import model.Book;
import model.Publisher;
;
import repository.PublisherRepository;
import repository.PublisherRepositoryImpl;

import java.util.List;

public class PublisherServiceImpl implements PublisherService{
    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(){
        publisherRepository = new PublisherRepositoryImpl();
    }

    @Override
    public void add(Publisher publisher) {
        publisherRepository.add(publisher);
    }

    @Override
    public Publisher getPublisher(int id) {
        return publisherRepository.getPublisher(id);
    }

    @Override
    public List<Publisher> findAllPublisher() {
        return publisherRepository.findAllPublisher();
    }

    public List<Publisher> findByPublisherName(String name){
       return publisherRepository.findByPublisherName(name);
    }

    @Override
    public List<Book> getBooks(int id) {
        return publisherRepository.getPublisher(id).getBooks();
    }
    @Override
    public void update(int id) {
        publisherRepository.update(getPublisher(id));
    }

    @Override
    public void remove(int id) {
        publisherRepository.remove(id);
    }


}
