package hu.hmei.spring.poc.server.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import hu.hmei.spring.poc.common.dto.WordSetDto;
import hu.hmei.spring.poc.server.entity.WordSet;

@Mapper(componentModel = "spring",uses = WordMapper.class, injectionStrategy = InjectionStrategy.FIELD)
public interface WordSetMapper {
	
	WordSetDto map(WordSet wordSet);
	
	WordSet map(WordSetDto wordSetDto);
	
	List<WordSet> mapWordSetDtoList(List<WordSetDto> wordSetDtoList);
	
	List<WordSetDto> mapWordList(List<WordSet> wordSetList);

}
