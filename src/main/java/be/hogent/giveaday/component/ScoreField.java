package be.hogent.giveaday.component;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;
import java.util.List;

public class ScoreField extends CustomField<Integer> {

    private static final List<Integer> scoreValues = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);

    RadioButtonGroup<Integer> score = new RadioButtonGroup<>("Score:", scoreValues);

    @Override
    protected Component initContent() {
        score.setStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
        return score;
    }

    @Override
    protected void doSetValue(Integer integer) {
        score.setValue(integer);
    }

    @Override
    public Integer getValue() {
        return score.getValue();
    }
}
