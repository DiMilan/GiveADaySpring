package be.hogent.giveaday.config;

import javax.servlet.annotation.WebServlet;

import be.hogent.giveaday.view.login.LoginView;
import be.hogent.giveaday.view.login.OtherSecurePage;
import be.hogent.giveaday.view.login.SecurePage;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.Page.UriFragmentChangedEvent;
import com.vaadin.server.Page.UriFragmentChangedListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class VaadinloginUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = VaadinloginUI.class)
	public static class Servlet extends VaadinServlet {
	}

	public static Authentication AUTH;
	@Override
	protected void init(VaadinRequest request) {
		AUTH = new Authentication();
		new Navigator(this, this);
		
		getNavigator().addView(LoginView.NAME, LoginView.class);
		getNavigator().setErrorView(LoginView.class);
		
		Page.getCurrent().addUriFragmentChangedListener(new UriFragmentChangedListener() {
			
			@Override
			public void uriFragmentChanged(UriFragmentChangedEvent event) {
				router(event.getUriFragment());
			}
		});
		
		
		router("");
	}
	
	private void router(String route){
		Notification.show(route);
		if(getSession().getAttribute("user") != null){
			getNavigator().addView(SecurePage.NAME, SecurePage.class);
			getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
			if(route.equals("!OtherSecure")){
				getNavigator().navigateTo(OtherSecurePage.NAME);
			}else{
				getNavigator().navigateTo(SecurePage.NAME);
			}
		}else{
			getNavigator().navigateTo(LoginView.NAME);
		}
	}

}