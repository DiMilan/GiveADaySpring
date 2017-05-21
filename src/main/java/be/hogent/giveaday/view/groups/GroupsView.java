package be.hogent.giveaday.view.groups;

import be.hogent.giveaday.model.DomainController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = GroupsView.VIEW_NAME)
public class GroupsView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "groups";

    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here

        setSizeFull();
        //AssessmentForm form = new AssessmentForm(user);
        //addComponent(form);
        //setComponentAlignment(assessment, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
