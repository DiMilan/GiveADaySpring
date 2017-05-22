package be.hogent.giveaday.view.groups;

import be.hogent.giveaday.component.AssessmentForm;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.model.Group;
import be.hogent.giveaday.model.User;
import com.vaadin.data.ValidationException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Collection;
import org.springframework.security.core.context.SecurityContextHolder;

//import org.springframework.security.core.userdetails.User;


@SpringView(name = GroupsView.VIEW_NAME)
public class GroupsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "groups";

    //hier wordt de ingelogde user opgehaald en in sprinUser gestoken
    private org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //naam van springUser wordt opgehaald als String
    private String name = springUser.getUsername(); //get logged in username

    //Hier wordt de user uit de db gehaald op basis van de naam van springUser
    private be.hogent.giveaday.model.User currentUser;
    private Group currentGroup;
    private Collection<be.hogent.giveaday.model.User> groupMembers;
    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here

        setWidth(100, Unit.PERCENTAGE);
        setSpacing(true);

        currentUser = domainController.getCurrentUser();
         currentGroup= currentUser.getGroup();
         groupMembers= currentGroup.getUsers();
        for (be.hogent.giveaday.model.User user : groupMembers )
        {

        AssessmentForm form = new AssessmentForm(user);
        addComponent(form);

        //setComponentAlignment(assessment, Alignment.MIDDLE_CENTER);


            Button save = new Button("Submit");


//        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
//        cancel.setStyleName(ValoTheme.BUTTON_DANGER);

            save.addClickListener(clickEvent -> {
                try {
                    form.commit();
                } catch (ValidationException e) {
                    Notification.show("Validation failed!", Notification.Type.ERROR_MESSAGE);
                }

            });

            HorizontalLayout actions = new HorizontalLayout(save);

            actions.setSpacing(true);

            HorizontalLayout footer = new HorizontalLayout(actions);

            footer.setWidth(100, Unit.PERCENTAGE);
            footer.setComponentAlignment(actions, Alignment.MIDDLE_RIGHT);

            addComponent(footer);



        }//END FOR LOOP

        Button cancel = new Button("Cancel");
        HorizontalLayout actions = new HorizontalLayout(cancel);

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
