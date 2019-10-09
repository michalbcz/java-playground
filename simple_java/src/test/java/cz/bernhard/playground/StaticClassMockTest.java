package cz.bernhard.playground;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



/**	
 * http://stackoverflow.com/questions/4860475/powermock-mocking-of-static-methods-return-original-values-in-some-particular/5063228#5063228
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClassMockTest.MyStaticClass.class)
public class StaticClassMockTest {

	public static class MyStaticClass {
		public static String getA(String a) {
			return a;
		}
		public static String getB(String b) {
			return b;
		}
	}

	@Test
	public void should_partial_mock_static_class() throws Exception {
		//given
		PowerMockito.spy(MyStaticClass.class);

		// Mockito style
//		Mockito.when(MyStaticClass.getB(Mockito.anyString())).thenReturn("B");
		
		// Same as above but BDDMockito style
		given(MyStaticClass.getB(Mockito.anyString())).willReturn("B");
		
		//then
		assertEquals("A", MyStaticClass.getA("A"));
		assertEquals("B", MyStaticClass.getA("B"));
		assertEquals("C", MyStaticClass.getA("C"));
		assertEquals("B", MyStaticClass.getB("A"));
		assertEquals("B", MyStaticClass.getB("B"));
		assertEquals("B", MyStaticClass.getB("C"));
	}

}

