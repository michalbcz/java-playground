package cz.bernhard.playground.java.spring.xml_configured.cache;

import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {ServicesBeanConfiguration.class, ConcurrentCacheProxyConfiguration.class})
public class UserCachedServiceConcurrentMapCacheTest extends UserCachedServiceTest {

}
