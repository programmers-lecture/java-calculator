package com.example.v1.specification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
	
	@DisplayName("계산 테스트")
	@CsvSource(value = {"1 2 +, 3", "1 2 -, -1", "1 2 *, 2"}, delimiter = ',')
	@ParameterizedTest(name = "{index} => expression={0}, expected={1}")
	void testCase1(String expression, double expected) {
		// given
		
		// when
		double calculate = new Calculator().calculate(expression);
		// then
		assertThat(calculate).isEqualTo(expected);
	}
}