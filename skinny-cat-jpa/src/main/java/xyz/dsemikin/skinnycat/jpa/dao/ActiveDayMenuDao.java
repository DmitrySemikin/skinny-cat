package xyz.dsemikin.skinnycat.jpa.dao;

import xyz.dsemikin.skinnycat.jpa.dto.ActiveDayMenuDtoJpa;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ActiveDayMenuDao {

    private final EntityManagerProvider entityManagerProvider;

    public ActiveDayMenuDao(final EntityManagerProvider entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void persistNew(final ActiveDayMenuDtoJpa activeDayMenu) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.persist(activeDayMenu));
    }

    public void persistExisting(final ActiveDayMenuDtoJpa activeDayMenu) {
        entityManagerProvider.doInTransaction(entityManager -> entityManager.merge(activeDayMenu));
    }

    private static final String DELETE_ACTIVE_DAY_MENU = "delete from active_day_menu a where a.id = :active_day_menu_id";
    public void delete(final long id) {
        entityManagerProvider.doInTransaction(entityManager -> {
            final Query query = entityManager.createQuery(DELETE_ACTIVE_DAY_MENU);
            query.setParameter("active_day_mnenu_id", id);
            query.executeUpdate();
        });
    }

    private static final String ALL = "from active_day_menu";
    public List<ActiveDayMenuDtoJpa> all() {
        return entityManagerProvider.doInTransactionWithResult(entityManager -> {
            final TypedQuery<ActiveDayMenuDtoJpa> query = entityManager.createQuery(ALL, ActiveDayMenuDtoJpa.class);
            return query.getResultList();
        });
    }

    public ActiveDayMenuDtoJpa findById(final long id) {
        return entityManagerProvider.doInTransactionWithResult(
                entityManager -> entityManager.find(ActiveDayMenuDtoJpa.class, id)
        );
    }
}
