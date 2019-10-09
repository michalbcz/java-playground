package cz.bernhard.playground.java.spring.xml_configured.cache;

import static org.junit.Assert.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.bernhard.playground.java.spring.User;
import cz.bernhard.playground.java.spring.UserCachedService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesBeanConfiguration.class})
public abstract class UserCachedServiceTest {
	
	@Autowired
	public UserCachedService userService;
	
	@Test
	public void userShouldBeSaved() {
		
		long userId = 5L;
		User user = new User()
							.setId(userId)
							.setFirstName("FirstName-" + RandomStringUtils.randomAlphabetic(5))
							.setLastName("LastName-" + RandomStringUtils.randomAlphabetic(5));
		
		assertTrue(userService.findUserById(userId) == null);
		userService.save(user);
		assertTrue(userService.findUserById(userId).equals(user));
		
	}
	
	@Test
	public void shouldReturnNullWhenThereIsNoUserFound() {
		
		long userId = 5L;
		User user = new User()
							.setId(userId)
							.setFirstName("FirstName-" + RandomStringUtils.randomAlphabetic(5))
							.setLastName("LastName-" + RandomStringUtils.randomAlphabetic(5));
		
		assertTrue(userService.findUserById(userId) == null);
		
	}
	
	@Test
	public void shouldReturnAlreadySavedUser() {
		
		Long userId = UserCachedService.PRELOADED_USER_ID;
		assertEquals(userId, userService.findUserById(userId).getId());
		
	}

}
