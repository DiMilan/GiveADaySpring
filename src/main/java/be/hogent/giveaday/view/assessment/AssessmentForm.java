package be.hogent.giveaday.view.assessment;

import be.hogent.giveaday.component.ScoreField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

public class AssessmentForm extends FormLayout {

    public AssessmentForm() {
        setStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        setMargin(false);
        Label title = new Label("Assessment");
        title.setStyleName(ValoTheme.LABEL_H2);
        addComponent(title);
    }

    ScoreField addQuestion(String caption) {
        ScoreField question = new ScoreField();

        question.setCaption(caption);

        addComponent(question);

        return question;
    }
}
