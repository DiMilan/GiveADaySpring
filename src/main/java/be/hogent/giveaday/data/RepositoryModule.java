package be.hogent.giveaday.data;

import com.google.inject.AbstractModule;

/**
 * Repository module that contains all bindings for Guice.
 */
public class RepositoryModule extends AbstractModule {

    @Override
    protected void configure() {
        // Map repository bindings here (interface -> implementation)
        bind(GroupRepository.class).to(GroupRepositoryImpl.class);
        bind(UserRepository.class).to(UserRepositoryImpl.class);
    }
}
