package hu.hmei.spring.poc.server.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import hu.hmei.spring.poc.common.dto.UserDto;
import hu.hmei.spring.poc.server.entity.User;

@Mapper(componentModel = "spring",uses = WordSetMapper.class, injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {
	
	UserDto map(User user);
	
	User map(UserDto UserDto);
	
	List<User> mapUserDtoList(List<UserDto> userDtoList);
	
	List<UserDto> mapUserList(List<User> userList);

}
