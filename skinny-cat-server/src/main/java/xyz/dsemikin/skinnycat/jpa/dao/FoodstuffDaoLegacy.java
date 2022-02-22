package xyz.dsemikin.skinnycat.jpa.dao;

import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpaLegacy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class FoodstuffDaoLegacy {

    @Inject
    private EntityManagerProviderLegacy entityManager;

    public void put(final FoodstuffDtoJpaLegacy foodstuff) {
        entityManager.em().persist(foodstuff);
    }

    public static final String DELETE_FOODSTUFF = "delete from foodstuff f where f.id=:foodstuff_id";
    public void delete(final long id) {
        final Query query = entityManager.em().createQuery(DELETE_FOODSTUFF);
        query.setParameter("foodstuff_id", id);
        query.executeUpdate();
    }

    public static final String ALL = "from foodstuff";
    public List<FoodstuffDtoJpaLegacy> all() {
        final TypedQuery<FoodstuffDtoJpaLegacy> query = entityManager.em().createQuery(ALL, FoodstuffDtoJpaLegacy.class);
        return query.getResultList();
    }

    public FoodstuffDtoJpaLegacy findById(final long id) {
        return entityManager.em().find(FoodstuffDtoJpaLegacy.class, id);
    }
}
