package cz.bernhard.playground;

/**
 * 
 * JVM will hang forever
 * 
 * see <a href="http://bugs.openjdk.java.net/show_bug.cgi?id=100119">http://bugs.openjdk.java.net/show_bug.cgi?id=100119</a>
 *
 */
class RunHang {
	
	public static void main(String[] args) {
		System.out.println("Test:");
		double d = Double.parseDouble("2.2250738585072012e-308");
		System.out.println("Value: " + d);
	}
	
}
