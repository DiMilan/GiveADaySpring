package be.hogent.giveaday.view.evaluation;

import be.hogent.giveaday.GoedBezigUI;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.view.assessment.AssessmentView;
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

    public static final String VIEW_NAME = "";

    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here
        setSizeFull();

        Button assessment = new Button("Assessment");

        assessment.addClickListener(clickEvent -> GoedBezigUI.showView(AssessmentView.VIEW_NAME));

        addComponent(assessment);
        setComponentAlignment(assessment, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
