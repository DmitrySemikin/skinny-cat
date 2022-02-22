package xyz.dsemikin.skinnycat.guiswing.jpa;

import xyz.dsemikin.skinnycat.jpa.dao.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntityManagerProviderHibernate implements AutoCloseable, EntityManagerProvider {

    private final EntityManagerFactory entityManagerFactory;
    private static final String PERSISTENCE_UNIT_NAME = "skinny-cat-persistence";

    public EntityManagerProviderHibernate() {
        entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
    public void close() {
        entityManagerFactory.close();
    }

    @Override
    public EntityManager em() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void doWithEntityManager(final Consumer<EntityManager> consumer) {
        EntityManager entityManager = null;
        try {
             entityManager = entityManagerFactory.createEntityManager();
             consumer.accept(entityManager);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void doInTransaction(final Consumer<EntityManager> consumer) {
        doWithEntityManager(entityManager -> {
            entityManager.getTransaction().begin();
            try {
                consumer.accept(entityManager);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw e;
            }
        });
    }

    @Override
    public <ResultType> ResultType doWithEntityManagerWithResult(final Function<EntityManager, ResultType> function) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            return function.apply(entityManager);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public <ResultType> ResultType doInTransactionWithResult(final Function<EntityManager, ResultType> function) {
        return doWithEntityManagerWithResult(entityManager -> {
            entityManager.getTransaction().begin();
            try {
                final ResultType result = function.apply(entityManager);
                entityManager.getTransaction().commit();
                return result;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw e;
            }
        });
    }
}
