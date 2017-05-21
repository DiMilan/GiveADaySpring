package be.hogent.giveaday.data;


import be.hogent.giveaday.model.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Group repository implementation.
 */
@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public GroupRepositoryImpl() {
    }

    @Override
    public void update(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        entityManager.refresh(group);
    }
}
