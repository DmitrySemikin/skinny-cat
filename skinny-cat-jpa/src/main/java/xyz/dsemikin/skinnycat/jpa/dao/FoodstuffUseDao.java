package xyz.dsemikin.skinnycat.jpa.dao;

import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffUseDtoJpa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class FoodstuffUseDao {

    private final EntityManagerProvider entityManagerProvider;

    public FoodstuffUseDao(final EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void persistNew(final FoodstuffUseDtoJpa foodstuffUse) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.persist(foodstuffUse));
    }

    public void persistExisting(final FoodstuffUseDtoJpa foodstuffUse) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.merge(foodstuffUse));
    }

    private static final String DELETE_FOODSTUFF_USE = "delete from foodstuff_use f where f.id = :foodstuff_use_id";
    public void delete(final long id) {
        entityManagerProvider.doInTransaction(entityManager -> {
            final Query query = entityManager.createQuery(DELETE_FOODSTUFF_USE);
            query.setParameter("foodstuff_use_id", id);
            query.executeUpdate();
        });
    }

    public static final String ALL = "from foodstuff_use";
    public List<FoodstuffUseDtoJpa> all() {
        return entityManagerProvider.doInTransactionWithResult(entityManager -> {
            final TypedQuery<FoodstuffUseDtoJpa> query = entityManager.createQuery(ALL, FoodstuffUseDtoJpa.class);
            return query.getResultList();
        });
    }

    public FoodstuffUseDtoJpa findById(final long id) {
        return entityManagerProvider.doInTransactionWithResult(
                entityManager -> entityManager.find(FoodstuffUseDtoJpa.class, id)
        );
    }
}
