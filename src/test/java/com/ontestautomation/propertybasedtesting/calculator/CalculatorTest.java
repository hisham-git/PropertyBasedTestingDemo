package com.ontestautomation.propertybasedtesting.calculator;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class CalculatorTest {
	
	@Test
	public void testAdditionExampleBased() {
		
		Calculator calculator = new Calculator();
		calculator.add(2);
		assertEquals(calculator.getResult(), 2);		
	}
	
	@Property(trials = 5)
	public void testAddition(int number) {
		
		System.out.println("Generated number for testAddition: " + number);
		
		Calculator calculator = new Calculator();
		calculator.add(number);
		assertEquals(calculator.getResult(), number);
	}
	
	@Property(trials = 5)
	public void testAdditionWithFixedSeed(@When(seed = -1L) int number) {
		
		System.out.println("Generated number for testAdditionWithFixedSeed: " + number);
		
		Calculator calculator = new Calculator();
		calculator.add(number);
		assertEquals(calculator.getResult(), number);
	}
	
	@Property(trials = 5)
	public void testAdditionUsingAssume(int number) {
		
		assumeThat(number, greaterThan(0));
		
		System.out.println("Generated number for testAdditionUsingAssume: " + number);
		
		Calculator calculator = new Calculator();
		calculator.add(number);
		assertEquals(calculator.getResult(), number);
	}
	
	@Property(trials = 5)
	public void testAdditionUsingSatisfies(@When(satisfies = "#_ >= 0") int number) {
				
		System.out.println("Generated number for testAdditionUsingSatisfies: " + number);
		
		Calculator calculator = new Calculator();
		calculator.add(number);
		assertEquals(calculator.getResult(), number);
	}
	
	@Property(trials = 5)
	public void testAdditionUsingInRange(@InRange(minInt = 0) int number) {
		
		System.out.println("Generated number for testAdditionUsingInRange: " + number);
		
		Calculator calculator = new Calculator();
		calculator.add(number);
		assertEquals(calculator.getResult(), number);
	}
}
