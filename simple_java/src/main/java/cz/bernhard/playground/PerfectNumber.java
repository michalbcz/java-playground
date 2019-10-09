package cz.bernhard.playground;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Perfect number is a number which is equal to sum of its dividers eg. 6 = 3+2+1)
 * 
 * @author Michal Bernhard (michal@bernhard.cz)
 *
 */
public class PerfectNumber {

	private static final int LIMIT = 10000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Numbers less than " + LIMIT + " which are perfect:" );
		
		List<Integer> perfectNumbers = findPerfectNumber(LIMIT);
		for(int perfectNumber : perfectNumbers) {
			System.out.print(perfectNumber + " ");
			System.out.println(findDividers(perfectNumber));
		}

	}

	/**
	 * @param range
	 * @return
	 */
	private static List<Integer> findPerfectNumber(int max) {

		List<Integer> perfectNumbers = new ArrayList<Integer>();
		
		for(int number = 2; number < max; number++) {
			if (isPerfectNumber(number)) {
				perfectNumbers.add(number);
			}
		}
		
		return perfectNumbers;
	}

	/**
	 * @param number
	 * @return if it is perfect number (= perfect number is a number which is equal to
	 * sum of its dividers eg. 6 = 3+2+1)
	 */
	private static boolean isPerfectNumber(int number) {
		
		List<Integer> dividers = findDividers(number);		
		return sum(dividers) == number;
		
	}

	private static List<Integer> findDividers(int number) {
		List<Integer> dividers = new ArrayList<Integer>();
		
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				dividers.add(i);
			}
		}
		
		return dividers;
	}

	private static int sum(List<Integer> numbers) {
		int sum = 0;
		
		for(int number : numbers) {
			sum += number;
		}
		
		return sum;
	}
	
	

}
