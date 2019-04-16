package hu.keme.spring.poc.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.keme.spring.poc.server.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User getOneByName(String name);
}
