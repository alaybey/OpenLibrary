package repository;

import model.Book;
import util.FactoryUtility;

import javax.persistence.*;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    EntityManager entityManager;

    public BookRepositoryImpl(){
        EntityManagerFactory entityManagerFactory = FactoryUtility.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(Book book) throws PersistenceException {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(book);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(int isbn) throws PersistenceException {
        Book book = findBook(isbn);
        if (book != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(book);
            } catch (PersistenceException e) {
                System.out.println(e.getMessage());
            }
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public Book findBook(int isbn) {
        Book book = null;   // remove two return statement
        try {
            book = this.entityManager.find(Book.class, isbn);
        } catch (Exception e) {
            ;
            System.out.println(e.getMessage());
        }
        return book;    // null or book
    }

    @Override
    public List<Book> findAllBook() {
        TypedQuery<Book> query = entityManager.createQuery("Select b from Book b", Book.class);
        List<Book> books = null;
        try {
            books = query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return books;
    }


    @Override
    public Book update(Book book) {
        Book updated = null;
        entityManager.getTransaction().begin();
        try {
            updated = this.entityManager.merge(book);
        } catch (Exception ignored) {
            System.out.println("ignored update");
        }
        entityManager.getTransaction().commit();
        return updated;
    }

}
