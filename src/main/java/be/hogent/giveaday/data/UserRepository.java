package be.hogent.giveaday.data;

import be.hogent.giveaday.model.User;

/**
 * User repository
 */
public interface UserRepository {
    User getByName(String username);

    void update(User currentUser);
}
