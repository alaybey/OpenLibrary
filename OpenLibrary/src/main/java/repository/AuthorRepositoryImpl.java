package repository;

import model.Author;
import util.FactoryUtility;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository{
    EntityManager entityManager;

    public AuthorRepositoryImpl(){
        EntityManagerFactory entityManagerFactory = FactoryUtility.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void add(Author author) {
        entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(author);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();

    }


    @Override
    public Author getAuthor(int id) {
        Author author = null;   // remove two return statement
        try {
            author = this.entityManager.find(Author.class, id);
        } catch (Exception e) {
            ;
            System.out.println(e.getMessage());
        }
        return author;    // null or author
    }

    @Override
    public List<Author> findAllAuthor() {
        TypedQuery<Author> query = entityManager.createQuery("Select a from Author a", Author.class);
        List<Author> authors = null;
        try {
            authors = query.getResultList();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return authors;
    }

    @Override
    public Author update(Author author) {
        Author updated = null;
        entityManager.getTransaction().begin();
        try {
            updated = this.entityManager.merge(author);
        } catch (Exception ignored) {
            System.out.println("ignored update");
        }
        entityManager.getTransaction().commit();
        return updated;
    }

    @Override
    public void remove(int id) {
        Author author = getAuthor(id);
        if (author != null) {
            entityManager.getTransaction().begin();
            try {
                entityManager.remove(author);
            } catch (PersistenceException e) {
                System.out.println(e.getMessage());
            }
            entityManager.getTransaction().commit();

        }

    }
}
