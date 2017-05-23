package be.hogent.giveaday.view.main;

import be.hogent.giveaday.GoedBezigUI;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.view.groups.GroupsView;
import be.hogent.giveaday.view.lector.LectorView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CssLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = MainView.VIEW_NAME)
public class MainView extends CssLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    DomainController domainController;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        if (domainController.isUserAdmin()) {
            GoedBezigUI.showView(LectorView.VIEW_NAME);
        } else {
            GoedBezigUI.showView(GroupsView.VIEW_NAME);
        }
    }
}
