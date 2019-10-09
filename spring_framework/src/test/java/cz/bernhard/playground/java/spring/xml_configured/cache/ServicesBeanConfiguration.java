package cz.bernhard.playground.java.spring.xml_configured.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.bernhard.playground.java.spring.CachedService;
import cz.bernhard.playground.java.spring.UserCachedService;

@Configuration
public class ServicesBeanConfiguration {
	
	@Bean
	public CachedService cachedService() {
		return new CachedService();
	}
	
	@Bean
	public UserCachedService userBlabla() {
		return new UserCachedService();
	}
	
	
	
}