package be.hogent.giveaday.view;

import be.hogent.giveaday.model.DomainController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = AssessmentView.VIEW_NAME)
public class AssessmentView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "assessment";

    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
