package be.hogent.giveaday.data;

import model.User;

/**
 * User repository
 */
public interface UserRepository {
    User getByName(String username);
}
