package be.hogent.giveaday.data;

import be.hogent.giveaday.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * User repository
 */
public interface UserRepository extends CrudRepository<User, String>, JpaRepository<User, String> {
    User getByName(String username);

    void update(User currentUser);
}
