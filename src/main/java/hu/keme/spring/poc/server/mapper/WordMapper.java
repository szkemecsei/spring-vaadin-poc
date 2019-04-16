package hu.keme.spring.poc.server.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.keme.spring.poc.common.dto.WordDto;
import hu.keme.spring.poc.server.entity.Word;

@Mapper(componentModel = "spring")
public interface WordMapper {
	
	WordDto map(Word word);
	
	Word map(WordDto wordDto);
	
	List<Word> mapWordDtoList(List<WordDto> wordDtoList);
	
	List<WordDto> mapWordList(List<Word> wordList);

}
