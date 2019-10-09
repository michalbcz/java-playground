package cz.bernhard.playground.java.spring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringJavaConfigsDeclaringSameBeans.Config1.class, SpringJavaConfigsDeclaringSameBeans.Config2.class, SpringJavaConfigsDeclaringSameBeans.Config3.class })
public class SpringJavaConfigsDeclaringSameBeans {

    @Autowired
    private User user;

    @Autowired
    private ApplicationContext context;

    @Test
    public void springCreateSameBeanTwiceButUseOnlyThatDeclaredAsLastOne() {
        assertThat(user.getFirstName(), is("Tomas"));
    }

    @Test
    public void applicationContextHaveAllTheBeans() {
        Map<String, User> beansOfType = context.getBeansOfType(User.class);
        assertThat(beansOfType.keySet(), hasSize(3));
    }

    @Configuration
    public static class Config1 {
        
        @Bean
        public User user() {
            User user = new User();
            user.setFirstName("Michal");
            user.setLastName("Bernhard");
            return user;
        }
        
    }

    @Configuration
    public static class Config2 {

        @Bean
        public User user() {
            User user = new User();
            user.setFirstName("Tomas");
            user.setLastName("Laco");
            return user;
        }

        @Bean
        public User user2() {
            User user = new User();
            user.setFirstName("Tomas");
            user.setLastName("Laco");
            return user;
        }

    }

    @Configuration
    public static class Config3 {

        @Bean
        public User user2() {
            User user = new User();
            user.setFirstName("Petr");
            user.setLastName("Klic");
            return user;
        }

    }
}
