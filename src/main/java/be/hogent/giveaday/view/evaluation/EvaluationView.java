package be.hogent.giveaday.view.evaluation;

import be.hogent.giveaday.GoedBezigUI;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.view.assessment.AssessmentView;
import be.hogent.giveaday.view.groups.GroupsView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = EvaluationView.VIEW_NAME)
public class EvaluationView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "evaluation";

    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here
        setSizeFull();

        Button assessment = new Button("Assessment");
        Button groupMembers = new Button("Evaluation");

        assessment.addClickListener(clickEvent -> GoedBezigUI.showView(AssessmentView.VIEW_NAME));
        groupMembers.addClickListener(clickEvent -> GoedBezigUI.showView(GroupsView.VIEW_NAME));

        addComponent(assessment);
        addComponent(groupMembers);
        setComponentAlignment(assessment, Alignment.MIDDLE_CENTER);
        setComponentAlignment(groupMembers, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
