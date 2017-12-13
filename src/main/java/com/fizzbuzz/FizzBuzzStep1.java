package com.fizzbuzz;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.fizzbuzz.constant.FizzBuzzConst;

/**
 * FizzBuzz Step1 Execution.
 * 
 * @author Bala
 *
 */
public class FizzBuzzStep1 {
	/**
	 * Main Method for FizzBuzzStep1.
	 * 
	 * @param args
	 *            args
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
		System.out.println(String.format("Printing FizzBuzzStep1 output between %d and %d", start, n));

		new FizzBuzzStep1().getFizzBuzzStream(start, n).forEach(it -> System.out.print(it + " "));
	}

	/**
	 * Method for getFizzBuzzStream.
	 * 
	 * @param start
	 *            start
	 * @param n
	 *            n
	 * @return Stream<String>
	 */
	Stream<String> getFizzBuzzStream(int start, int n) {

		if (n < start) {
			throw new IllegalArgumentException(FizzBuzzConst.NotRange);
		}
		return IntStream.range(start, n + 1).<String>mapToObj(value -> {
			String result = String.valueOf(value);
			if (value % 15 == 0) {
				result = FizzBuzzConst.fizzbuzz;
			} else if (value % 5 == 0) {
				result = FizzBuzzConst.buzz;
			} else if (value % 3 == 0) {
				result = FizzBuzzConst.fizz;
			}
			return result;
		}).sequential();
	}

	/**
	 * Method to get FizzBuzz as String.
	 * 
	 * @param start
	 *            start
	 * @param n
	 *            n
	 * @return String
	 */
	String getFizzBuzzString(int start, int n) {
		StringBuilder builder = new StringBuilder();
		getFizzBuzzStream(start, n).forEach(it -> builder.append(it).append(" "));
		return builder.toString();
	}
}