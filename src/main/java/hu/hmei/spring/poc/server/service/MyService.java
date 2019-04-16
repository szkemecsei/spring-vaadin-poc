package hu.hmei.spring.poc.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import hu.hmei.spring.poc.common.dto.UserDto;
import hu.hmei.spring.poc.server.entity.User;
import hu.hmei.spring.poc.server.mapper.UserMapper;

@Service
@SessionScope
public class MyService {

	@Autowired
	UserService userService;
		
	@Autowired 
	UserMapper userMapper;
	
	public void createUser(UserDto userDto) {
		User user = userMapper.map(userDto); 
		userService.createUser(user);
	}
	
	public List<UserDto> listAllUser(){		
		return userMapper.mapUserList(userService.getAllUser());
	}
		
}
