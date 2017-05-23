package be.hogent.giveaday.component;

import be.hogent.giveaday.model.Assessment;
import be.hogent.giveaday.model.User;
import com.vaadin.data.Binder;
import com.vaadin.data.BinderValidationStatus;
import com.vaadin.data.ValidationException;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

public class AssessmentForm extends CustomComponent {

    public static final String QUESTION_1 = "enthousiasme en participatie";
    public static final String QUESTION_2 = "ideeën aanbrengen";
    public static final String QUESTION_3 = "inhouden correct en duidelijk kunnen uitleggen";
    public static final String QUESTION_4 = "groep organiseren en sturen";
    public static final String QUESTION_5 = "precisie en nauwkeurigheid";
    public static final String QUESTION_6 = "afspraken respecteren";

    private final Binder<Assessment> binder = new Binder<>(Assessment.class);

    private final ScoreField q1 = new ScoreField(QUESTION_1);
    private final ScoreField q2 = new ScoreField(QUESTION_2);
    private final ScoreField q3 = new ScoreField(QUESTION_3);
    private final ScoreField q4 = new ScoreField(QUESTION_4);
    private final ScoreField q5 = new ScoreField(QUESTION_5);
    private final ScoreField q6 = new ScoreField(QUESTION_6);

    private final Assessment assessment;

    public AssessmentForm(User source, User user) {
        this.assessment = new Assessment();
        this.assessment.setSourceUser(source);
        this.assessment.setGroup(source.getGroup());
        this.assessment.setTargetUser(user);

        initForm();
        initBindings();
    }

    public AssessmentForm(Assessment assessment) {
        this.assessment = assessment;

        initForm();
        initBindings();
        setEnabled(false);
    }

    private void initForm() {
        Label user = new Label(assessment.getTargetUser().getName());

        user.setStyleName(ValoTheme.LABEL_HUGE);

        FormLayout form = new FormLayout(q1, q2, q3, q4, q5, q6);

        form.setStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        form.addStyleName(ValoTheme.LAYOUT_WELL);
        form.setMargin(false);

        CssLayout formLayout = new CssLayout(form);

        formLayout.setStyleName(ValoTheme.LAYOUT_WELL);

        VerticalLayout layout = new VerticalLayout(user, formLayout);

        layout.setSpacing(true);
        layout.setMargin(false);

        setCompositionRoot(layout);
    }

    private void initBindings() {
        binder.forField(q1).asRequired("Required").bind(Assessment::getVraag1, Assessment::setVraag1);
        binder.forField(q2).asRequired("Required").bind(Assessment::getVraag2, Assessment::setVraag2);
        binder.forField(q3).asRequired("Required").bind(Assessment::getVraag3, Assessment::setVraag3);
        binder.forField(q4).asRequired("Required").bind(Assessment::getVraag4, Assessment::setVraag4);
        binder.forField(q5).asRequired("Required").bind(Assessment::getVraag5, Assessment::setVraag5);
        binder.forField(q6).asRequired("Required").bind(Assessment::getVraag6, Assessment::setVraag6);

        binder.setBean(assessment);
    }

    public BinderValidationStatus<Assessment> validate() {
        return binder.validate();
    }

    public void commit() throws ValidationException {
        binder.writeBean(assessment);
    }

    public Assessment getAssessment() {
        return assessment;
    }
}
