package cz.bernhard.playground.java.spring.xml_configured.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
public class ConcurrentCacheProxyWithAspectJAdviceModeConfiguration {
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
