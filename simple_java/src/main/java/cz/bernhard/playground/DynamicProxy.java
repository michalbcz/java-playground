package cz.bernhard.playground;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxy {

	public static void main(String[] args) {
		
		TestInterface testClassProxy = (TestInterface) Proxy.newProxyInstance(
					DynamicProxy.class.getClassLoader(),
					new Class[] { TestInterface.class },
					new ProxyHandler(new TestClass()));
		
		testClassProxy.testMethod("first", "second");
				
	}
	
	public static class TestClass implements TestInterface {
		
		public void testMethod(String testArg1, String testArg2) {
			System.out.println("Hello this is testMethod");
		}
		
	}
	
	public static interface TestInterface {
		
		void testMethod(String arg1, String arg2);
	}
	
	private static class ProxyHandler implements InvocationHandler {

		private final Object underlying;

		public ProxyHandler(Object underlying) {
			this.underlying = underlying;
			
		}
		
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			
			System.out.printf("%1$s %2$s\n", method.getName(), Arrays.deepToString(args));
			return method.invoke(underlying, args);
			
		}
		
		
	}
	
}
