package be.hogent.giveaday.data;

import be.hogent.giveaday.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * User repository implementation
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    public UserRepositoryImpl() {
    }

    @Override
    public User getByName(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", username);
        return query.getSingleResult();
    }
}
