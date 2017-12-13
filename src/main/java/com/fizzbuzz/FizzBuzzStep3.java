package com.fizzbuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fizzbuzz.constant.FizzBuzzConst;

/**
 * FizzBuzz Step3 Execution.
 * 
 * @author Bala
 *
 */
public class FizzBuzzStep3 {
	/**
	 * Main Method for Step3 Program.
	 * 
	 * @param args
	 *            args
	 * 
	 */
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
			System.err.println(FizzBuzzConst.ValidNumber);
			System.exit(-1);
		}
		System.out.println(String.format("Printing FizzBuzzStep3 output between %d and %d", start, n));

		Map<String, AtomicInteger> report = new HashMap<>();
		new FizzBuzzStep3().getFizzBuzzStream(start, n, report).forEach(it -> System.out.print(it + " "));
		System.out.println();
		report.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue().get()));
	}

	/**
	 * Method for getFizzBuzzStream.
	 * 
	 * @param start
	 *            start
	 * @param n
	 *            n
	 * @param report
	 *            report
	 * @return Stream<String>
	 */
	Stream<String> getFizzBuzzStream(int start, int n, final Map<String, AtomicInteger> report) {
		if (report == null) {
			throw new IllegalArgumentException(FizzBuzzConst.missingReport);
		}
		if (n < start) {
			throw new IllegalArgumentException(FizzBuzzConst.NotRange);
		}

		report.clear();
		report.put(FizzBuzzConst.fizz, new AtomicInteger());
		report.put(FizzBuzzConst.buzz, new AtomicInteger());
		report.put(FizzBuzzConst.fizzbuzz, new AtomicInteger());
		report.put(FizzBuzzConst.lucky, new AtomicInteger());
		report.put(FizzBuzzConst.integer, new AtomicInteger());

		return IntStream.range(start, n + 1).<String>mapToObj(value -> {
			String result = String.valueOf(value);
			// check highest value rule first...
			if (result.contains(FizzBuzzConst.Three)) {
				report.get(FizzBuzzConst.lucky).incrementAndGet();
				result = FizzBuzzConst.lucky;
			} else if (value % 15 == 0) {
				report.get(FizzBuzzConst.fizzbuzz).incrementAndGet();
				result = FizzBuzzConst.fizzbuzz;
			} else if (value % 5 == 0) {
				report.get(FizzBuzzConst.buzz).incrementAndGet();
				result = FizzBuzzConst.buzz;
			} else if (value % 3 == 0) {
				report.get(FizzBuzzConst.fizz).incrementAndGet();
				result = FizzBuzzConst.fizz;
			} else {
				report.get(FizzBuzzConst.integer).incrementAndGet();
			}
			return result;
		}).sequential();
	}

	/**
	 * Method for getFizzBuzzString.
	 * 
	 * @param start
	 *            start
	 * @param n
	 *            n
	 * @param report
	 *            report
	 * @return String
	 */
	String getFizzBuzzString(int start, int n, Map<String, AtomicInteger> report) {
		StringBuilder builder = new StringBuilder();
		getFizzBuzzStream(start, n, report).forEach(it -> builder.append(it).append(" "));
		return builder.toString();
	}
}
