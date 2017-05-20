package be.hogent.giveaday.data;


import be.hogent.giveaday.model.Group;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Group repository implementation.
 */
public class GroupRepositoryImpl implements GroupRepository {

    private final EntityManager entityManager;

    @Inject
    public GroupRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void update(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        entityManager.refresh(group);
    }
}
