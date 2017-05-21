package be.hogent.giveaday.model;

import be.hogent.giveaday.data.GroupRepository;
import be.hogent.giveaday.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DomainController {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    public void logout() {
        //ttpServletRequest.logout();
    }

    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getByName(userDetails.getUsername());
    }
}
