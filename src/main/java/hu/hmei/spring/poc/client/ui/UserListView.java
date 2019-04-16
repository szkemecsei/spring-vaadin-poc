package hu.hmei.spring.poc.client.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import hu.hmei.spring.poc.common.dto.UserDto;
import hu.hmei.spring.poc.server.service.MyService;

// Pay attention to the order of annotations
@UIScope
@SpringView(name = UserListView.VIEW_NAME)
public class UserListView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "userList"; //This is the default SpringViewDisplay

	@Autowired
	private  MyService service;
			
	private Grid<UserDto> grid = new Grid<>(UserDto.class);

	@PostConstruct
	void init() {
		addComponent(grid);
		List<UserDto> users = service.listAllUser();
		grid.setItems(users);
		grid.addColumn(UserDto::getId).setCaption("Id");
		grid.addColumn(UserDto::getName).setCaption("Name");
		grid.addColumn(UserDto::getFullName).setCaption("Full Name");
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
}