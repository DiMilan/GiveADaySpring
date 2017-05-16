package be.hogent.giveaday.view.assessment;

import be.hogent.giveaday.component.ScoreField;
import be.hogent.giveaday.model.DomainController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = AssessmentView.VIEW_NAME)
public class AssessmentView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "assessment";

    @Autowired
    private DomainController domainController;

    @PostConstruct
    private void init() {
        AssessmentForm form = new AssessmentForm();
        ScoreField q1 = form.addQuestion("enthousiasme en participatie");
        ScoreField q2 = form.addQuestion("ideeën aanbrengen");
        ScoreField q3 = form.addQuestion("inhouden correct en duidelijk kunnen uitleggen");
        ScoreField q4 = form.addQuestion("groep organiseren en sturen");
        ScoreField q5 = form.addQuestion("precisie en nauwkeurigheid");
        ScoreField q6 = form.addQuestion("afspraken respecteren");

        addComponent(form);
//        setExpandRatio(form, 1.0f);

        Button save = new Button("Submit");
        Button cancel = new Button("Cancel");

//        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
//        cancel.setStyleName(ValoTheme.BUTTON_DANGER);

        HorizontalLayout actions = new HorizontalLayout(save, cancel);

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
