package be.hogent.giveaday.view.login;

import be.hogent.giveaday.GoedBezigUI;
import be.hogent.giveaday.model.DomainController;
import be.hogent.giveaday.view.evaluation.EvaluationView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    DomainController domainController;

    @PostConstruct
    private void init() {
        // Init UI here
        setSizeFull();
        Button loginButton = new Button("Login");
        // TODO show correct view per user
        loginButton.addClickListener(clickEvent -> GoedBezigUI.showView(EvaluationView.VIEW_NAME));
        addComponent(loginButton);
        setComponentAlignment(loginButton, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        // Called when view is opened
    }
}
