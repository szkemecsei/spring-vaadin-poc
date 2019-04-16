package hu.hmei.spring.poc.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.hmei.spring.poc.server.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User getOneByName(String name);
}
