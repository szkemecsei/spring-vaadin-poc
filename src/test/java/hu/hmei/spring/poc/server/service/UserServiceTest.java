package hu.hmei.spring.poc.server.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import hu.hmei.spring.poc.common.dto.UserDto;
import hu.hmei.spring.poc.server.dao.UserRepository;
import hu.hmei.spring.poc.server.entity.User;
import hu.hmei.spring.poc.server.mapper.UserMapper;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByName_thenReturnUser() {
		User user = new User();
		user.setName("TestUser");
		user.setFullName("Test User");
		entityManager.persist(user);
		entityManager.flush();
		
		User found = userRepository.getOneByName(user.getName());
		
		assertThat(found.getFullName()).isEqualTo(user.getFullName());
	}
	
	@Test
	public void whenFindAll_thenReturnUsers() {
		User user = new User();
		user.setName("TestUser");
		user.setFullName("Test User");
		entityManager.persist(user);
		entityManager.flush();
		
		User found = userRepository.findAll().get(0);
		
		assertThat(found.getFullName()).isEqualTo(user.getFullName());
		
		UserDto userDto = Mappers.getMapper(UserMapper.class).map(found);
		assertThat(userDto.getFullName()).isEqualTo(userDto.getFullName());
	}

}
