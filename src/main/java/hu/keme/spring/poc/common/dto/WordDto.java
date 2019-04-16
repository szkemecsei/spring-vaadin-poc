package hu.keme.spring.poc.common.dto;

import lombok.Data;

@Data
public class WordDto {

	private Long id;
	private String type;
	private String fromWord;
	private String toWord;
}
