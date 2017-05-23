package be.hogent.giveaday.view.groups;


import be.hogent.giveaday.component.AssessmentForm;
import be.hogent.giveaday.model.Assessment;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.model.Group;
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
import java.util.ArrayList;
import java.util.Collection;

//import org.springframework.security.core.userdetails.User;


@SpringView(name = GroupsView.VIEW_NAME)
public class GroupsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "groups";

    //hier wordt de ingelogde user opgehaald en in sprinUser gestoken
    private org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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
        currentGroup = currentUser.getGroup();
        groupMembers = currentGroup.getUsers();
        Collection<AssessmentForm> forms = new ArrayList<>();

        Label groupNameL = new Label(currentGroup.getGroupName());
        addComponent(groupNameL);
        groupNameL.setStyleName(ValoTheme.LABEL_H1);


        Button save = new Button("Submit");

        if (CollectionUtils.isEmpty(currentUser.getAssessments())) {
            for (be.hogent.giveaday.model.User user : groupMembers) {

                AssessmentForm form = new AssessmentForm(currentUser, user);
                addComponent(form);
                forms.add(form);

            }//END FOR LOOP
        } //end IF EMPTY

        else {


            for (Assessment a : currentUser.getAssessments()) {

                AssessmentForm form = new AssessmentForm(a);
                addComponent(form);

            }   //end for iterator

            save.setEnabled(false);
        } // end else

        //Button cancel = new Button("Cancel");

        // submit event nog aan te passen !
        save.addClickListener(clickEvent -> {
            boolean isValid = true;

            for( AssessmentForm f : forms ) {
                if(f.validate().hasErrors()) isValid = false;
            }//end for
            if (!isValid) return;
            try {
                for( AssessmentForm f : forms ) {

                    f.commit();
                }
            } catch (ValidationException e) {
                Notification.show("Validation failed!", Notification.Type.ERROR_MESSAGE);
                return;
            }

            for( AssessmentForm f : forms){

                domainController.addAssessment(f.getAssessment());
            }
            for( AssessmentForm f : forms){

                f.setEnabled(false);

            }

            save.setEnabled(false);
        }
        ); // end clickEvent

        HorizontalLayout actions = new HorizontalLayout(save);

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
