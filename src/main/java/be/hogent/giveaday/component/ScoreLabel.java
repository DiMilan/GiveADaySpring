package be.hogent.giveaday.component;

import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.*;

/**
 * Created by maximiliaandevloo on 22/05/17.
 */
public class ScoreLabel extends com.vaadin.ui.Label {

    public ScoreLabel(String string) {
        super(string);
        this.addStyleName(ValoTheme.LABEL_LIGHT);
        this.addStyleName(ValoTheme.LABEL_SMALL);
    }
}
