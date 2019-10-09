package cz.bernhard.playground.java.spring;

import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.google.common.collect.Sets;

public class UserCachedService {
	
	public static final long PRELOADED_USER_ID = 1337L;
	
	private Set<User> users = Sets.newHashSet();
	
	public UserCachedService() {
		
		User preloadedUser = new User()
									.setId(PRELOADED_USER_ID)
									.setFirstName("FirstName-" + RandomStringUtils.randomAlphabetic(5))
									.setLastName("LastName-" + RandomStringUtils.randomAlphabetic(5));
		
		users.add(preloadedUser);
	}
	
	@Cacheable(value = "users", key = "#p0")
	public User findUserById(final Long id) {
		
		User selectedUser = null;
		for (User user : users) {
			
			if (user.getId().equals(id)) {
				selectedUser = user;
				break;
			}
			
		}
		
		return selectedUser;
	}
	
	@CacheEvict(value = "users", key = "#user.id")
	public void save(User user) {
		users.add(user);
	}
	

}
