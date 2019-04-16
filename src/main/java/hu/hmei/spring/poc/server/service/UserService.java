package hu.hmei.spring.poc.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.hmei.spring.poc.server.dao.UserRepository;
import hu.hmei.spring.poc.server.entity.User;

@Service
public class UserService {
	
	UserRepository repository;
	
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User getUserByName(String name) {
		return this.repository.getOneByName(name);		
	}
	
	public void createUser(User user) {
		repository.save(user);
	}
	
	public User getUserById(Long id) {
		return repository.getOne(id);
	}
	
	public List<User> getAllUser(){
		return this.repository.findAll();

	}

}
