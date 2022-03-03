package xyz.dsemikin.skinnycat.jpa.dao;

import xyz.dsemikin.skinnycat.jpa.dto.DayMenuDtoJpa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DayMenuDao {

    private final EntityManagerProvider entityManagerProvider;

    public DayMenuDao(final EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void persistNew(final DayMenuDtoJpa dayMenu) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.persist(dayMenu));
    }

    public void persistExisting(final DayMenuDtoJpa dayMenu) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.merge(dayMenu));
    }

    public static final String DELETE_DAYMENU = "delete from daymenu d where d.id = :daymenu_id";
    public void delete(final long id) {
        entityManagerProvider.doInTransaction(entityManager -> {
            final Query query = entityManager.createQuery(DELETE_DAYMENU);
            query.setParameter("daymenu_id", id);
            query.executeUpdate();
        });
    }

    public static final String ALL = "from daymenu";
    public List<DayMenuDtoJpa> all() {
        return entityManagerProvider.doInTransactionWithResult(entityManager -> {
            final TypedQuery<DayMenuDtoJpa> query = entityManager.createQuery(ALL, DayMenuDtoJpa.class);
            return query.getResultList();
        });
    }

    public DayMenuDtoJpa findById(final long id) {
        return entityManagerProvider.doInTransactionWithResult(
                entityManager -> entityManager.find(DayMenuDtoJpa.class, id)
        );
    }
}
