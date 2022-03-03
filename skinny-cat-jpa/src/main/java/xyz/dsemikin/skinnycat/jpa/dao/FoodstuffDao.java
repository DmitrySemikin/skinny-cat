package xyz.dsemikin.skinnycat.jpa.dao;

import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class FoodstuffDao {

    private final EntityManagerProvider entityManagerProvider;

    public FoodstuffDao(final EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void persistNew(final FoodstuffDtoJpa foodstuff) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.persist(foodstuff));
    }

    public void persistExisting(final FoodstuffDtoJpa foodstuff) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.merge(foodstuff));
    }

    private static final String DELETE_FOODSTUFF = "delete from foodstuff f where f.id=:foodstuff_id";
    public void delete(final long id) {
        entityManagerProvider.doInTransaction(entityManager -> {
            final Query query = entityManager.createQuery(DELETE_FOODSTUFF);
            query.setParameter("foodstuff_id", id);
            query.executeUpdate();
        });
    }

    private static final String ALL = "from foodstuff";
    public List<FoodstuffDtoJpa> all() {
        return entityManagerProvider.doInTransactionWithResult(entityManager -> {
            final TypedQuery<FoodstuffDtoJpa> query = entityManager.createQuery(ALL, FoodstuffDtoJpa.class);
            return query.getResultList();
        });
    }

    public FoodstuffDtoJpa findById(final long id) {
        return entityManagerProvider.doInTransactionWithResult(
                entityManager -> entityManager.find(FoodstuffDtoJpa.class, id)
        );
    }
}
