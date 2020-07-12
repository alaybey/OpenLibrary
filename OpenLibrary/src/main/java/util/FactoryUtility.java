package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryUtility {

    private FactoryUtility() {
        throw new AssertionError();
    }

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
