package hu.hmei.spring.poc.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.hmei.spring.poc.common.dto.WordSetDto;
import hu.hmei.spring.poc.server.dao.WordSetRepository;
import hu.hmei.spring.poc.server.entity.User;
import hu.hmei.spring.poc.server.entity.WordSet;
import hu.hmei.spring.poc.server.mapper.WordSetMapper;

@Service
public class WordSetService {

	@Autowired
	WordSetRepository repository;
	
	@Autowired
	WordSetMapper wordSetMapper;
	
	@Autowired
	UserService userService;
	
	public void addWordSet(WordSetDto wordSetDto) {
		WordSet wordSet = wordSetMapper.map(wordSetDto);
		repository.save(wordSet);
	}
	
	public List<WordSetDto> getAllWordSet(){
		return wordSetMapper.mapWordList(repository.findAll());
	}
	
	public List<WordSetDto> getUserWordSets(Long userId){
		return wordSetMapper.mapWordList(getUserWordSets(userService.getUserById(userId)));
	}
	
	public List<WordSet> getUserWordSets(User user){
		return repository.findByUser(user);
	}
}
