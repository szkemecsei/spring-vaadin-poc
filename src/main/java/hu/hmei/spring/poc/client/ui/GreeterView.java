package hu.hmei.spring.poc.client.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = GreeterView.VIEW_NAME)
public class GreeterView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1360443016647621931L;
	
	@Autowired
	private ViewGreeter viewGreeter;
	
	public static final String VIEW_NAME = "greeter";

	@PostConstruct
	void init() {
		addComponent(new Label(viewGreeter.sayHello()));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
}
