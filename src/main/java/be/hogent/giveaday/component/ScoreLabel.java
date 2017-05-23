package be.hogent.giveaday.component;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import com.vaadin.ui.themes.ValoTheme;

import java.awt.*;

/**
 * Created by maximiliaandevloo on 22/05/17.
 */
public class ScoreLabel extends com.vaadin.ui.Label {

    public ScoreLabel(String caption, Double value) {
        super(Double.toString(value) + "&nbsp;");
        this.setContentMode(ContentMode.HTML);
        this.setCaption(caption);
        this.addStyleName(ValoTheme.LABEL_BOLD);
    }
}
