package be.hogent.giveaday.view.assessment;

import be.hogent.giveaday.component.AssessmentForm;
import be.hogent.giveaday.component.ScoreField;
import be.hogent.giveaday.model.Assessment;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.model.User;
import com.vaadin.data.ValidationException;
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
        Assessment assessment = new Assessment();

        assessment.setTargetUser(new User("voornaam", "naam"));

        AssessmentForm form = new AssessmentForm(assessment);
        addComponent(form);
//        setExpandRatio(form, 1.0f);

        Button save = new Button("Submit");
        Button cancel = new Button("Cancel");

//        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
//        cancel.setStyleName(ValoTheme.BUTTON_DANGER);

        save.addClickListener(clickEvent -> {
            try {
                form.commit();
            } catch (ValidationException e) {
                Notification.show("Validation failed!", Notification.Type.ERROR_MESSAGE);
            }

        });

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
