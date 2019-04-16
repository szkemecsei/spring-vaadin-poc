package hu.hmei.spring.poc.client.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

import hu.hmei.spring.poc.common.dto.UserDto;
import hu.hmei.spring.poc.server.service.MyService;

// Pay attention to the order of annotations
@UIScope
@SpringView(name = UserView.VIEW_NAME)
public class UserView extends FormLayout implements View {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = ""; //This is the default SpringViewDisplay

	@Autowired
	private  MyService service;
	
	private Binder<UserDto> binder = new Binder<UserDto>();
	
	UserDto userDto = new UserDto();

	@PostConstruct
	void init() {
		TextField nameField = new TextField("Name");
		nameField.setIcon(VaadinIcons.USER);
		nameField.setRequiredIndicatorVisible(true);
		nameField.focus();
		addComponent(nameField);
		TextField fullName = new TextField("Full name");
		fullName.setIcon(VaadinIcons.USER);
		fullName.setRequiredIndicatorVisible(true);
		addComponent(fullName);
		
		binder.forField(nameField).bind(UserDto::getName, UserDto::setName);
		binder.forField(fullName).bind(UserDto::getFullName,UserDto::setFullName);
		
		addComponent(createButton("Save", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					binder.writeBean(userDto);
					service.createUser(userDto);
					userDto = new UserDto();
					binder.readBean(userDto);
				} catch (ValidationException e) {
					Notification.show("Error validation!");
				}
				Notification.show("Creat user successful!");
			}
		}));
	}

	private Button createButton(String caption, final ClickListener clickListener) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);

		button.addClickListener(clickListener);
		return button;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
}