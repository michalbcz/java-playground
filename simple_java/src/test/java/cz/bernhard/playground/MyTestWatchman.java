package cz.bernhard.playground;
import org.junit.rules.TestWatchman;
import org.junit.runners.model.FrameworkMethod;


/**
 * Each successful test is listed in console through System.out
 * 
 * @author Michal Bernhard (michal.bernhard@cleverlance.com)
 *
 */
public class MyTestWatchman extends TestWatchman {

	@Override
	public void succeeded(FrameworkMethod method) {
		System.out.printf("Test method %1$s was succesful.\n", method.getName());
	}
	
	@Override
	public void starting(FrameworkMethod method) {
		System.out.printf("Test method %1$s just started.\n", method.getName());
	}
	
}