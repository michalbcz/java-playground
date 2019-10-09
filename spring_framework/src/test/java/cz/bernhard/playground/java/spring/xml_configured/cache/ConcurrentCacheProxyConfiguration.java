package cz.bernhard.playground.java.spring.xml_configured.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching(mode = AdviceMode.PROXY /* this can be omitted as it's default */)
public class ConcurrentCacheProxyConfiguration {
	
	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager();
	}

}
