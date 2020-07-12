package repository;

import model.Publisher;
import util.FactoryUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {

    EntityManager entityManager;

    public PublisherRepositoryImpl(){
        EntityManagerFactory entityManagerFactory = FactoryUtility.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Publisher publisher) {
        entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(publisher);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();

    }

    @Override
    public Publisher getPublisher(int id) {
        Publisher publisher = null;   // remove two return statement
        try {
            publisher = this.entityManager.find(Publisher.class, id);
        } catch (Exception e) {
            ;
            System.out.println(e.getMessage());
        }
        return publisher;    // null or publisher
    }

    @Override
    public List<Publisher> findAllPublisher() {
        TypedQuery<Publisher> query = entityManager.createQuery("Select p from Publisher p", Publisher.class);
        List<Publisher> publishers = null;
        try {
            publishers = query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return publishers;
    }

    @Override
    public Publisher update(Publisher publisher) {
        Publisher updated = null;
        entityManager.getTransaction().begin();
        try {
            updated = this.entityManager.merge(publisher);
        } catch (Exception ignored) {
            System.out.println("ignored update");
        }
        entityManager.getTransaction().commit();
        return updated;    }

    @Override
    public void remove(int id) {
        Publisher publisher = getPublisher(id);
        if (publisher != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(publisher);
            } catch (PersistenceException e) {
                System.out.println(e.getMessage());
            }
            entityManager.getTransaction().commit();
        }
    }
    public List<Publisher> findByPublisherName(String name){
        TypedQuery<Publisher> query = entityManager.createNamedQuery("Publisher.findByPublisherName", Publisher.class);
        List<Publisher> publisherNames = null;
        query.setParameter("name",name);
        try {
            publisherNames = query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return publisherNames;
    }

}
