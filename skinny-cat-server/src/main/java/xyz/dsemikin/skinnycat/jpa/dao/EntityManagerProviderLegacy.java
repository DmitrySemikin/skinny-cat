package xyz.dsemikin.skinnycat.jpa.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EntityManagerProviderLegacy {

    @PersistenceContext(unitName = "skinny-cat-ds")
    private EntityManager entityManager;

    public EntityManager em() {
        return entityManager;
    }
}
