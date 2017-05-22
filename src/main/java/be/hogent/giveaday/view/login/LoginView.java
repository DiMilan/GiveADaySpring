package be.hogent.giveaday.view.login;

import be.hogent.giveaday.GoedBezigUI;
import be.hogent.giveaday.config.VaadinloginUI;
import be.hogent.giveaday.data.UserRepository;
import be.hogent.giveaday.data.UserRepositoryImpl;
import be.hogent.giveaday.model.User;
import be.hogent.giveaday.view.evaluation.EvaluationView;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/login")
@SpringView(name = LoginView.NAME)
@Title("LoginPage")
public class LoginView extends VerticalLayout implements View  {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "";
    UserRepository userRepository;

    public LoginView(){
        Panel panel = new Panel("Login");
        panel.setSizeUndefined();
        addComponent(panel);

        userRepository = new UserRepositoryImpl();

        FormLayout content = new FormLayout();
        TextField username = new TextField("Username");
        content.addComponent(username);
        PasswordField password = new PasswordField("Password");
        content.addComponent(password);

        Button send = new Button("Enter");
        send.addClickListener(new ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                try {
                    User user = userRepository.getByName(username.getValue());
                }catch (java.lang.NullPointerException ex){
                    Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
                }
                if(GoedBezigUI.AUTH.authenticate(username.getValue(), password.getValue())){
                    VaadinSession.getCurrent().setAttribute("user", username.getValue());
                    getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
                    getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
                    Page.getCurrent().setUriFragment("!"+ EvaluationView.VIEW_NAME);
                }else{

                }
            }

        });
        content.addComponent(send);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.setContent(content);
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER);

    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}