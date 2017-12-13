package com.fizzbuzz;

import org.junit.Test;

import com.fizzbuzz.FizzBuzzStep1;
import com.fizzbuzz.FizzBuzzStep2;
import com.fizzbuzz.FizzBuzzStep3;
import com.fizzbuzz.constant.FizzBuzzConst;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Junit Test for FizzBuzz.
 * 
 * @author Bala
 */
public class FizzBuzzTest {

	/**
	 * Step 1.
	 *
	 */
	@Test
	public void testFizzBuzzStep1() {
		String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
		String actual = new FizzBuzzStep1().getFizzBuzzString(1, 20);
		assertNotNull(actual);
		assertThat(actual.trim(), is(expected));
	}

	/**
	 * Step 2.
	 * 
	 */
	@Test
	public void testFizzBuzzStep2() {
		String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
		String actual = new FizzBuzzStep2().getFizzBuzzString(1, 20);
		assertNotNull(actual);
		assertThat(actual.trim(), is(expected));
	}

	/**
	 * Step 3.
	 * 
	 */
	@Test
	public void testFizzBuzzStep3() {
		Map<String, AtomicInteger> report = new HashMap<>();
		String expected = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz";
		String actual = new FizzBuzzStep3().getFizzBuzzString(1, 20, report);
		assertNotNull(actual);
		assertThat(actual.trim(), is(expected));
		assertThat(report.get(FizzBuzzConst.fizz).get(), is(4));
		assertThat(report.get(FizzBuzzConst.buzz).get(), is(3));
		assertThat(report.get(FizzBuzzConst.fizzbuzz).get(), is(1));
		assertThat(report.get(FizzBuzzConst.lucky).get(), is(2));
		assertThat(report.get(FizzBuzzConst.integer).get(), is(10));
	}
}