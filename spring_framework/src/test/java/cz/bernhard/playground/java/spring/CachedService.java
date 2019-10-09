package cz.bernhard.playground.java.spring;

import javax.annotation.PostConstruct;

import org.joda.time.Duration;
import org.springframework.cache.annotation.Cacheable;

public class CachedService {
	
	@Cacheable("cache1")
	public long veryLongMethod(long time) {
		try {
			Thread.sleep(time);
			return time;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public long callInternalVeryLongMethod(long time) {
		return veryLongMethod(time);		
	}
	
	
	public long callInternalPrivateVeryLongMethod(long time) {
		return veryLongMethod(time);		
	}
	
	@Cacheable("cache2")
	private long doInternalVeryLongMethod(long time) {
		try {
			Thread.sleep(time);
			return time;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void initializeCache() {
		veryLongMethod(Duration.standardSeconds(5).getMillis()); 
	}

}
