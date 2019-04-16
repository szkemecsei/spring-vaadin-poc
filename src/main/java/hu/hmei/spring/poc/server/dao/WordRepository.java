package hu.hmei.spring.poc.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.hmei.spring.poc.server.entity.Word;
import hu.hmei.spring.poc.server.entity.WordSet;

public interface WordRepository extends JpaRepository<Word, Long>{
	List<Word> findByWordSet(WordSet wordSet);
}
