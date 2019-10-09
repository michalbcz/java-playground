package cz.bernhard.playground.kata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * String Calculator code kata
 * 
 * http://katas.softwarecraftsmanship.org/?p=80
 * 
 * @author Michal Bernhard (michal@bernhard.cz)
 *
 */
public class StringCalculator {

	private static final Pattern DELIMITER_DECLARATION_REGEXP = Pattern.compile("\\/\\/(.)\\n");
	private static final String DEFAULT_DELIMITERS_REGEXP = ",";

	public static StringCalculator create() {
		return new StringCalculator();
	}

	/**
	 * @param numbers "1" return 1, "1,2" returns 3 (1 + 2) ... 
	 */
	public int add(String numbers) {
		
		if (StringUtils.isBlank(numbers)) return 0;
		
		if(!isValidExpression(numbers)) {
			throw new IllegalArgumentException("Expression '" + numbers + "' has invalid syntax.");
		}		
		
		String numbersPart = getNumbersPart(numbers); 
		
		String[] numbersInString = numbersPart.split(getDelimiterRegExpFor(numbers));
		
		int result = 0;
		
		for (String numberAsString : numbersInString) {			
			
			Integer number = Integer.valueOf(numberAsString);
			
			if (number < 0) throw new NegativesNotAllowed();
			
			result += number;
		}
		
		return result;
		
	}

	private String getNumbersPart(String numbers) {
		Matcher matcher = DELIMITER_DECLARATION_REGEXP.matcher(numbers);
		if (matcher.find()) {
			return numbers.substring(matcher.end());
		}
		else {
			return numbers;
		}
	}

	private String getDelimiterRegExpFor(String numbers) {
		
		Matcher matcher = DELIMITER_DECLARATION_REGEXP.matcher(numbers);
		
		if (matcher.find()) {
			return wrap(matcher.group(1));			
		}
		else {
			return wrap(DEFAULT_DELIMITERS_REGEXP);
		}
	}

	private String wrap(String str) {
		return "[" + str +"\\s]";
	}

	private boolean isValidExpression(String numbers) {
		int countOfNumbers = countOfNumbers(numbers);
		int countOfDelimiters = countOfDelimiters(numbers);
		return countOfNumbers == (countOfDelimiters + 1);
	}

	private int countOfDelimiters(String numbers) {
		Pattern pattern = Pattern.compile(getDelimiterRegExpFor(numbers));
		
		Matcher matcher = pattern.matcher(getNumbersPart(numbers));
		int countOfDelimiters = 0;
		
		while(matcher.find()) {
			countOfDelimiters++;
		}
		
		return countOfDelimiters;
	}

	private int countOfNumbers(String numbers) {
		
		Pattern pattern = Pattern.compile("(\\d+)(" + getDelimiterRegExpFor(numbers) +  ")?");
		
		Matcher matcher = pattern.matcher(getNumbersPart(numbers));
		
		int countOfNumbers = 0;
		
		while(matcher.find()) {
			countOfNumbers++;
		}
		
		return countOfNumbers;
	}
	

	public static class NegativesNotAllowed extends RuntimeException {

	}

}
