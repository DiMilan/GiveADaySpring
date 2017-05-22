package be.hogent.giveaday.data;

import be.hogent.giveaday.model.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * User repository implementation
 */
@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<User, Integer> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
    }


    @Override
    public User getByName(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", username);
        return query.getSingleResult();
    }

    public void update(User user){
        save(user);
    }
}
