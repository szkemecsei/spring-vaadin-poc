package hu.keme.spring.poc.server.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class WordSet {

	@Id
    @GeneratedValue
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wordSet")
	private List<Word> words;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
}
