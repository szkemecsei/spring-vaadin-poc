package hu.keme.spring.poc.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.keme.spring.poc.server.entity.User;
import hu.keme.spring.poc.server.entity.WordSet;

public interface WordSetRepository extends JpaRepository<WordSet, Long>{
	List<WordSet> findByUser(User user);
}
