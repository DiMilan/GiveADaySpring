package be.hogent.giveaday;

import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.view.LoginView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("giveaday")
@SpringUI
@SpringViewDisplay
public class GoedBezigUI extends UI implements ViewDisplay {

    @Autowired
    private DomainController domainController;

    private Button logoutButton;
    private Panel springViewDisplay;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        setContent(root);

        HorizontalLayout header = new HorizontalLayout();

        header.setSpacing(true);
        header.setWidth(100, Unit.PERCENTAGE);

        // Title

        Label title = new Label("Give A Day");
        Label subtitle = new Label("peer assessment");

        title.setStyleName(ValoTheme.LABEL_HUGE);
        subtitle.setStyleName(ValoTheme.LABEL_LARGE);

        header.addComponent(title);
        header.addComponent(subtitle);

        header.setComponentAlignment(title, Alignment.BOTTOM_LEFT);
        header.setComponentAlignment(subtitle, Alignment.BOTTOM_LEFT);

        // Navigation buttons

        HorizontalLayout navigation = new HorizontalLayout();

        navigation.setSpacing(true);
        navigation.setWidth(100,Unit.PERCENTAGE);

        header.addComponent(navigation);
        header.setExpandRatio(navigation, 1.0f);

        logoutButton = new Button("Logout");

        logoutButton.addClickListener(clickEvent -> {
            domainController.logout();
            showView(LoginView.VIEW_NAME);
        });

        navigation.addComponent(logoutButton);
        navigation.setComponentAlignment(logoutButton, Alignment.MIDDLE_RIGHT);

        root.addComponent(header);

        springViewDisplay = new Panel();
        springViewDisplay.setSizeFull();

        root.addComponent(springViewDisplay);
        root.setExpandRatio(springViewDisplay, 1.0f);
    }

    @Override
    public void showView(View view) {
        springViewDisplay.setContent((Component) view);
        // Show logout only if logged in
        logoutButton.setVisible(!(view instanceof LoginView));
    }

    public static void showView(String viewName) {
        UI.getCurrent().getNavigator().navigateTo(viewName);
    }
}