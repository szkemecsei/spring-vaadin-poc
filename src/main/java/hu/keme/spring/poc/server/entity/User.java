package hu.keme.spring.poc.server.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class User {

	@Id
    @GeneratedValue
    private Long id;

	@Column(unique=true)
    private String name;
    
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<WordSet> wordSets;

}
