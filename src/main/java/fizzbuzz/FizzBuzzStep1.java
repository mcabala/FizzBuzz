package fizzbuzz;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * FizzBuzz Step1 Execution.
 * 
 * @author Bala
 *
 */
public class FizzBuzzStep1 {

	public static void main(String[] args) {

		int start = 1, n = 20;
		try {
			if (args.length >= 2) {
				start = Integer.parseInt(args[0]);
				n = Integer.parseInt(args[1]);
			}
			if (args.length == 1) {
				n = Integer.parseInt(args[0]);
			}
		} catch (Exception err) {
			System.err.println("Number must be valid integer");
			System.exit(-1);
		}
		System.out.println(String.format("Printing FizzBuzzStep1 output between %d and %d", start, n));

		new FizzBuzzStep1().getFizzBuzzStream(start, n).forEach(it -> System.out.print(it + " "));
	}

	Stream<String> getFizzBuzzStream(int start, int n) {

		if (n < start) {
			throw new IllegalArgumentException("Number is not in the range");
		}
		return IntStream.range(start, n + 1).<String>mapToObj(value -> {
			String result = String.valueOf(value);
			if (value % 15 == 0) {
				result = "fizzbuzz";
			} else if (value % 5 == 0) {
				result = "buzz";
			} else if (value % 3 == 0) {
				result = "fizz";
			}
			return result;
		}).sequential();
	}

	String getFizzBuzzString(int start, int n) {
		StringBuilder builder = new StringBuilder();
		getFizzBuzzStream(start, n).forEach(it -> builder.append(it).append(" "));
		return builder.toString();
	}
}