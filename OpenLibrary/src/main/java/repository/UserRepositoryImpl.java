package repository;

import model.User;
import util.FactoryUtility;

import javax.persistence.*;

public class UserRepositoryImpl implements UserRepository {
    EntityManager entityManager;

    public UserRepositoryImpl(){
        EntityManagerFactory entityManagerFactory = FactoryUtility.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void addUser(User user) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
        } catch (PersistenceException p) {
            System.out.println(p.getMessage());
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String username){
        TypedQuery<User> query = entityManager.createQuery("Select u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        entityManager.getTransaction().begin();
        try {
            user = entityManager.merge(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if(user != null){
            entityManager.getTransaction().begin();
            try{
                entityManager.remove(user);
            } catch (PersistenceException p){
                System.out.println(p.getMessage());
            }
            entityManager.getTransaction().commit();
        }
    }
}
