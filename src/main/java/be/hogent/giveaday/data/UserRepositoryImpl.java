package be.hogent.giveaday.data;

import be.hogent.giveaday.model.User;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * User repository implementation
 */
@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<User, String> implements UserRepository {



    @PersistenceContext
    private EntityManager entityManager;


    public UserRepositoryImpl(EntityManager em) {
        super(User.class, em);
    }


    @Override
    public User getByName(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", username);
        User user = query.getSingleResult();
        if (user != null) {
            return findOne(user.getId());
        } else {
            return null;
        }
    }

    public void update(User user){
        save(user);
    }
}
