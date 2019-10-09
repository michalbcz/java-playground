package cz.bernhard.playground.java.spring.xml_configured.cache;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import cz.bernhard.playground.java.spring.CachedService;
import org.apache.commons.lang3.time.StopWatch;
import org.joda.time.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/* !!! BEWARE HERE BE DRAGONS !!!
 * 
 * When ConcurrentCacheProxyWithAspectJAdviceModeConfiguration.class Spring Java Configuration
 * is after configuration class defining CachedService bean (class using @Cache) then
 * @PostConstruc called in CachedService can call method of beans, but @Cacheable annotations
 * don't trigger caching mechanism. 
 * 
 * It seems that bean initialization and @PostConstruct are for some reason triggered before
 * @EnableCaching machinery even starts. 
 *
 **/
//@ContextConfiguration(classes = {ServicesBeanConfiguration.class, ConcurrentCacheProxyWithAspectJAdviceModeConfiguration.class})
@ContextConfiguration(classes = {ConcurrentCacheProxyWithAspectJAdviceModeConfiguration.class, ServicesBeanConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCacheTest {
	
	@Autowired
	private CachedService cachedService;
	
	@Test
	public void secondTimeMethodCallIsCached() {

        Duration time = Duration.millis(200);

        StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		cachedService.veryLongMethod(time.getMillis());
		stopWatch.stop();
        assertThat(stopWatch.getTime(), greaterThanOrEqualTo(200L));
        System.out.println(stopWatch.toString());
		
		stopWatch.reset();
		stopWatch.start();
		cachedService.veryLongMethod(time.getMillis());
		stopWatch.stop();
		
		System.out.println(stopWatch.toString());

        assertThat(stopWatch.getTime(), lessThan(600L));

    }
	
	@Test
	public void precachedValueShouldBeReturnedFromCacheFromVeryFirstTime() {

        Duration time = Duration.millis(200);

        StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		cachedService.veryLongMethod(time.getMillis());
		stopWatch.stop();
		
		System.out.println(stopWatch.toString());

        assertThat(stopWatch.getTime(), lessThan(1000L));

    }
	
	@Test
	public void classMethodCallingAnotherCachedClassMethodShouldMakeCacheHit() {

        Duration time = Duration.millis(200);

        StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		cachedService.callInternalVeryLongMethod(time.getMillis());
		stopWatch.stop();
        assertThat(stopWatch.getTime(), greaterThanOrEqualTo(200L));
        System.out.println(stopWatch.toString());
		
		stopWatch.reset();
		stopWatch.start();
		cachedService.callInternalVeryLongMethod(time.getMillis());
		stopWatch.stop();
		
		System.out.println(stopWatch.toString());

        assertThat(stopWatch.getTime(), lessThan(1000L));
    }
	
}