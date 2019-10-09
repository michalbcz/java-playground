package cz.bernhard.playground.java.spring.xml_configured.cache;

import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = {ServicesBeanConfiguration.class})
public class UserCachedServiceCacheNotEnabledTest extends UserCachedServiceTest {

}
