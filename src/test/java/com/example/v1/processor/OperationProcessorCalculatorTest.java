package com.example.v1.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationProcessorCalculatorTest {
	
	private static Stream<Arguments> operatorAndExpressionDummy() {
		return Stream.of(
			Arguments.of("+", 1, 2, 3),
			Arguments.of("-", 1, 2, -1),
			Arguments.of("*", 1, 2, 2),
			Arguments.of("/", 1, 2, 0.5)
		);
	}
	
	@DisplayName("Calculator 연산 테스트")
	@MethodSource("operatorAndExpressionDummy")
	@ParameterizedTest(name = "{index} => {1} {0} {2} = {3}")
	void testCase1(String operator, int left, int right, double expected) {
		// given
		
		// when
		double actual = OperationProcessor.of(operator).calculate(left, right);
		
		// then
		assertThat(actual).isEqualTo(expected);
	}
}