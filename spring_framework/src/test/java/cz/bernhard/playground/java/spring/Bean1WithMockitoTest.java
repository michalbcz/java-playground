package cz.bernhard.playground.java.spring;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Bean1WithMockitoTest {

    @Mock
    private IBean1 bean1;

    /**
     * http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html
     */
    @Before
    public void before()
    {
         when(bean1.hello("world")).thenReturn("Hello, world");
    }

    @Test
    public void testHello()
    {
        System.out.println(getClass().getName() + ".testHello");

        //when
        String result = bean1.hello("world");

        //then
        assertThat(result).isEqualTo("Hello, world");

    }
}
