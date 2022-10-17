package com.example.v1.specification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorConverterTest {
	
	private static Stream<Arguments> infixExpressionDummy() {
		return Stream.of(
			Arguments.of("1 + 2", "1 2 +"),
			Arguments.of("1 - 2", "1 2 -"),
			Arguments.of("1 * 2", "1 2 *"),
			Arguments.of("1 / 2", "1 2 /"),
			Arguments.of("1 + 2 + 3", "1 2 + 3 +"),
			Arguments.of("1 + 2 - 3", "1 2 + 3 -"),
			Arguments.of("1 + 2 * 3", "1 2 3 * +"),
			Arguments.of("1 + 2 / 3", "1 2 3 / +"),
			Arguments.of("1 - 2 + 3", "1 2 - 3 +"),
			Arguments.of("1 - 2 - 3", "1 2 - 3 -"),
			Arguments.of("1 - 2 * 3", "1 2 3 * -")
		);
	}
	
	@DisplayName("중위 표기법 변환 테스트")
	@MethodSource("infixExpressionDummy")
	@ParameterizedTest(name = "{index} => {0} ==> {1}")
	void testCase1(String infixExpression, String expected) {
		// given
		
		// when
		CalculatorConverter calculatorConverter = new CalculatorConverter(new Calculator());
		String actual = calculatorConverter.parseExpressionInfixToPostFix(infixExpression);
		
		// then
		assertThat(actual).isEqualTo(expected);
	}
	
	private static Stream<Arguments> infixExpressionCalculatorDummy() {
		return Stream.of(
			Arguments.of("1 + 2", 3),
			Arguments.of("1 - 2", -1),
			Arguments.of("1 * 2", 2),
			Arguments.of("1 / 2", 0.5),
			Arguments.of("1 + 2 + 3", 6),
			Arguments.of("1 + 2 - 3", 0),
			Arguments.of("1 + 2 * 3", 7),
			Arguments.of("1 - 2 + 3", 2),
			Arguments.of("1 - 2 - 3", -4),
			Arguments.of("1 - 2 * 3", -5),
			Arguments.of("1 * 2 + 3", 5),
			Arguments.of("1 * 2 - 3", -1),
			Arguments.of("1 * 2 * 3", 6),
			Arguments.of("1 * 2 / 3", 0.6666666666666666),
			Arguments.of("1 / 2 + 3", 3.5),
			Arguments.of("1 / 2 - 3", -2.5),
			Arguments.of("1 / 2 * 3", 1.5),
			Arguments.of("1 / 2 / 3", 0.16666666666666666),
			Arguments.of("1 + 2 + 3 + 4", 10),
			Arguments.of("1 + 2 + 3 - 4", 2),
			Arguments.of("1 + 2 + 3 * 4", 15),
			Arguments.of("1 + 2 + 3 / 4", 3.75),
			Arguments.of("1 + 2 - 3 + 4", 4),
			Arguments.of("1 + 2 - 3 - 4", -4),
			Arguments.of("1 + 2 - 3 * 4", -9),
			Arguments.of("1 + 2 - 3 / 4", 2.25)
		);
	}
	
	@DisplayName("중위 표기법 변환 연산 테스트")
	@MethodSource("infixExpressionCalculatorDummy")
	@ParameterizedTest(name = "{index} => {0} ==> {1}")
	void testCase2(String infixExpression, double expected) {
		// given
		
		// when
		CalculatorConverter calculatorConverter = new CalculatorConverter(new Calculator());
		double actual = calculatorConverter.calculate(infixExpression);
		
		// then
		assertThat(actual).isEqualTo(expected);
	}
}