package hu.keme.spring.poc.client.ui;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@SpringView(name = TemplateView.VIEW_NAME)
@DesignRoot
public class TemplateView extends VerticalLayout implements View {

    Button myButton;
    Label myLabel;
	int counter=0;
    
	private static final long serialVersionUID = -8292012215969432352L;

	public static final String VIEW_NAME = "view";

	public TemplateView() {
		Design.read("TemplateView.html",this);
		myButton.addClickListener(event -> {
			counter++;
			myLabel.setValue("Click Hihi! " + counter);			
		});
	}
}