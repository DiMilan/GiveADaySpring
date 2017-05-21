package be.hogent.giveaday.view.groups;

import be.hogent.giveaday.model.DomainController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Collection;

@SpringView(name = GroupsView.VIEW_NAME)
public class GroupsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "groups";

    private Collection groupMembers;


    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here

        setSizeFull();

        for (Iterator iterator = groupMembers.iterator(); iterator.hasNext(); )
        {
        //AssessmentForm form = new AssessmentForm(user);
        //addComponent(form);
        //setComponentAlignment(assessment, Alignment.MIDDLE_CENTER);
        //

        }


    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
