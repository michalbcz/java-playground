package cz.bernhard.playground;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatchman;


public class JUnitTest {
	
	@Rule
	public TestWatchman watchman = new MyTestWatchman();
	
	@Before
	public void beforeTest() {
		System.out.println("@Before");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}
	
	@Test(expected = Throwable.class)
	public void shouldThrowException() {
		System.out.println("shouldThrowException method called");
		throw new RuntimeException("testing exception");
	}
	
	@After
	public void afterTest() {
		System.out.println("@After");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}
	
	
	
}
