package hu.hmei.spring.poc.client.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyUI extends UI implements ViewDisplay {

	private static final long serialVersionUID = 1163614271226299501L;

	private Panel springViewDisplay;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);

		final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("Create User",
                UserView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("List All Users",
                UserListView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Template View",
                TemplateView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("Greeter View",
                GreeterView.VIEW_NAME));
        root.addComponent(navigationBar);
		

		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
	}
	
	private Button createNavigationButton(String caption,
            final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}
}
