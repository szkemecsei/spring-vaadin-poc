package hu.keme.spring.poc.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.keme.spring.poc.common.dto.WordDto;
import hu.keme.spring.poc.server.dao.WordRepository;

@Service
public class WordService {

	@Autowired
	WordRepository repository;
	
	@Autowired
	WordSetService wordSetService;
	
	public void addWord(Long userId,WordDto wordDto) {
		
	}
}
