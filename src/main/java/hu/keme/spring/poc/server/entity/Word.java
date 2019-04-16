package hu.keme.spring.poc.server.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Word {

	@Id
	@GeneratedValue
	private Long id;
	private String type;
	private String fromWord;
	private String toWord;
	
	@ManyToOne
	@JoinColumn(name = "word_set_id", nullable = false)
	private WordSet wordSet;
	
}
