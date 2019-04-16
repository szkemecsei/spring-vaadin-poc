package hu.hmei.spring.poc.common.dto;

import java.util.List;

import hu.hmei.spring.poc.server.entity.WordSet;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;
    
    private String fullName;
    
    private List<WordSet> wordSets;
}
