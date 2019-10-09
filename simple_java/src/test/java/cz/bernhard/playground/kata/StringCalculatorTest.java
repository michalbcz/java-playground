package cz.bernhard.playground.kata;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.bernhard.playground.kata.StringCalculator.NegativesNotAllowed;

public class StringCalculatorTest {

	private static StringCalculator calc;

	@BeforeClass
	public static void doBeforeAllTests() {
		calc = StringCalculator.create();
	}
	
	@Test
	public void testEmptyString() {
		assertEquals(calc.add(""), 0);
	}
	
	@Test
	public void testEmptyString2() {
		assertEquals(calc.add("    \n"), 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionAsItIsNotValidExpression2() {
		assertEquals(calc.add(",,,\n,,"), 0);
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(calc.add("1"), 1);
	}
	
	@Test
	public void testOneNumberWithTwoDecimals() {
		assertEquals(calc.add("10"), 10);
	}
	
	@Test
	public void testTwoNumbersWithCommaAsDelimiter() {
		assertEquals(calc.add("1,2"), 1 + 2);
	}
	
	@Test
	public void testTwoNumbersWithCommaAsCustomDelimiter() {
		assertEquals(calc.add("//,\n1,2"), 1 + 2);
	}
	
	@Test
	public void testTwoNumbersWithCommaAsCustomDelimiter2() {
		assertEquals(calc.add("//a\n1a2a3a4a5"), 1 + 2 + 3 + 4 + 5);
	}
	
	@Test
	public void testTwoNumbersWithCommaAsCustomDelimiter3() {
		assertEquals(calc.add("//a\n1a2a3\n4"), 1 + 2 + 3 + 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailBecauseDelimiterIsOtherThanUsed() {
		assertEquals(calc.add("//;\n1,2"), 1 + 2);
	}
	
	@Test
	public void testFiveNumbers() {
		assertEquals(calc.add("1,2,3,4,5,10"), 1 + 2 + 3 + 4 + 5 + 10);
	}
	
	@Test(expected = NegativesNotAllowed.class)
	public void testNegativeNumber() {
		calc.add("-1,2,3,4,5,10");
	}


	@Test
	public void testFiveNumbersWithNewLineAsDelimiter() {
		assertEquals(calc.add("1,2,3,4,5\n10"), 1 + 2 + 3 + 4 + 5 + 10);
	}
	
	@Test
	public void testFiveNumbersWithNewLineAsDelimiter2() {
		assertEquals(calc.add("1,2\n3,4,5\n10"), 1 + 2 + 3 + 4 + 5 + 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionAsItIsNotValidExpression() {
		calc.add("1,\n");
	}
	
	
	
}
