package be.hogent.giveaday.view.lector;


import be.hogent.giveaday.component.AssessmentForm;
import be.hogent.giveaday.model.Assessment;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.model.Group;
import be.hogent.giveaday.model.User;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

//import org.springframework.security.core.userdetails.User;


@SpringView(name = LectorView.VIEW_NAME)
public class LectorView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "lector";


    @Autowired
    private DomainController domainController;


    @PostConstruct
    private void init() {
        // Init UI here

        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);
        User currentUser = domainController.getCurrentUser();
        List<User> studenten = currentUser.getStudents();
        Set<Group> lectorGroups = studenten.stream().map(user -> user.getGroup()).distinct().collect(Collectors.toSet());


        //Label groupNameL = new Label(currentGroup.getGroupName());
        //addComponent(groupNameL);
        //groupNameL.setStyleName(ValoTheme.LABEL_H1);

        Button cancel = new Button("Cancel");
        HorizontalLayout actions = new HorizontalLayout(cancel);

        VerticalLayout layout = new VerticalLayout();
        for(Group lectorGroup : lectorGroups) {
            addComponent(new Label (lectorGroup.getGroupName()));
            //.setStyleName(ValoTheme.LABEL_H1)
            //Button view[groupLector.getGroupName()] = new Button("Check Assessments");
            //addComponent(view[groupLector.getGroupName()]);
        }


        actions.setSpacing(true);

        HorizontalLayout footer = new HorizontalLayout(actions);

        footer.setWidth(100, Unit.PERCENTAGE);
        footer.setComponentAlignment(actions, Alignment.MIDDLE_RIGHT);

        addComponent(footer);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
