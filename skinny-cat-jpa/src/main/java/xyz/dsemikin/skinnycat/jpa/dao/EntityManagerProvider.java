package xyz.dsemikin.skinnycat.jpa.dao;

import javax.persistence.EntityManager;
import java.util.function.Consumer;
import java.util.function.Function;

public interface EntityManagerProvider {

    EntityManager em();

    void doWithEntityManager(final Consumer<EntityManager> consumer);
    void doInTransaction(final Consumer<EntityManager> consumer);
    <ResultType> ResultType doWithEntityManagerWithResult(final Function<EntityManager, ResultType> function);
    <ResultType> ResultType doInTransactionWithResult(final Function<EntityManager, ResultType> function);

}
