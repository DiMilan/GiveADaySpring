package be.hogent.giveaday.model;

import be.hogent.giveaday.data.AssessmentRepository;
import be.hogent.giveaday.data.GroupRepository;
import be.hogent.giveaday.data.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DomainController {
    private static final Logger log = LoggerFactory.getLogger(DomainController.class);

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AssessmentRepository assessmentRepository;

    public void logout() {
        //ttpServletRequest.logout();
    }

    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        log.debug("Retrieving user details (name = {})", username);
        return userRepository.getByName(username);
    }

    public boolean isUserAdmin() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        for (GrantedAuthority a : userDetails.getAuthorities()) {
            if (a.getAuthority().contains("ADMIN")) {
                return true;
            }
        }
        return false;
    }

    public void addAssessment(Assessment assessment) {
        log.info("Adding assessment");
        assessmentRepository.save(assessment);
    }
}
