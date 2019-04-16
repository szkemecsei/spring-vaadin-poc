package hu.keme.spring.poc.common.dto;

import java.util.List;

import hu.keme.spring.poc.server.entity.Word;
import lombok.Data;

@Data
public class WordSetDto {
	
	private Long id;
	
	private List<Word> words;

}
